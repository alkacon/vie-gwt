/*
 * File   : $Source$
 * Date   : $Date$
 * Version: $Revision$
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (C) 2002 - 2009 Alkacon Software (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.alkacon.vie.client.widgets;

import com.alkacon.vie.client.Entity;
import com.alkacon.vie.client.I_EntityArrayCallback;
import com.alkacon.vie.client.I_EntityCallback;
import com.alkacon.vie.client.Vie;
import com.alkacon.vie.shared.I_Entity;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

/**
 * Implements an easy version of editable widget.<p>
 */
public final class SimpleEditWidget {

    /**
     * Hide.<p>
     */
    private SimpleEditWidget() {

        // noop
    }

    /**
     * Makes it editable.<p>
     */
    public static void makeEditable() {

        init();

        final Vie vie = Vie.getInstance();
        vie.useRdfaService();
        vie.bindFunctionToEntities("add", new I_EntityCallback() {

            public void execute(Entity entity) {

                editable(entity, vie);
                entity.addValueChangeHandler(new ValueChangeHandler<Entity>() {

                    public void onValueChange(ValueChangeEvent<Entity> event) {

                        save(event.getValue(), vie);
                    }
                });
            }
        });

        vie.load("rdfa", "body [about]", new I_EntityArrayCallback() {

            public void execute(JsArray<Entity> entities) {

                // noop
            }
        });
    }

    /**
     * Initialize.<p>
     */
    protected static native void init() /*-{
        $wnd.changedEntities = [];
        $wnd.saveButton = null;
    }-*/;

    /**
     * Makes the entity editable.<p>
     * 
     * @param entity the entity to make editable
     * @param v the vie instance
     */
    protected static native void editable(I_Entity entity, Vie v) /*-{

        $wnd.jQuery('[about="' + entity.getSubjectUri() + '"] [property]')
                .each(function() {
                    if (v.services.rdfa.getElementSubject(this) !== entity.id) {
                        return;
                    }
                    var editableElement = $wnd.jQuery(this);
                    var property = v.services.rdfa.getElementPredicate(this);
                    editableElement.attr('contenteditable', true);
                    editableElement.bind('keyup click change', function() {
                        var content = editableElement.html();
                        if (content !== entity.get(property)) {
                            var changedProps = {};
                            changedProps[property] = content;
                            entity.set(changedProps);
                        }
                    });
                })
    }-*/;

    /**
     * Makes the entity saveable.<p>
     * 
     * @param entity the entity to make saveable
     * @param v the vie instance
     */
    protected static native void save(I_Entity entity, Vie v) /*-{

        $wnd.console.log(entity.previousAttributes(), entity.attributes);
        if ($wnd.changedEntities.indexOf(entity) === -1) {
            $wnd.changedEntities.push(entity);
        }
        if ($wnd.saveButton) {
            return;
        }

        $wnd.saveButton = $wnd.jQuery('<button>Save</button>');
        $wnd.saveButton.click(function() {
            alert('We would save ' + $wnd.changedEntities.length
                    + ' changed entities');
            $wnd._.each($wnd.changedEntities, function(entity) {
                //entity.save();
            });
            $wnd.changedEntities = [];
        });
        $wnd.jQuery('body').append($wnd.saveButton);
    }-*/;

}