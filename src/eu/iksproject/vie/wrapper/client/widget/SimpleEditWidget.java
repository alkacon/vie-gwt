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

package eu.iksproject.vie.wrapper.client.widget;

import eu.iksproject.vie.wrapper.client.Entity;
import eu.iksproject.vie.wrapper.client.I_EntityArrayCallback;
import eu.iksproject.vie.wrapper.client.I_EntityCallback;
import eu.iksproject.vie.wrapper.client.Vie;

import com.google.gwt.core.client.JsArray;

/**
 * 
 */
public class SimpleEditWidget {

    /**
     * Hide.<p>
     */
    private SimpleEditWidget() {

    }

    public static void makeEditable() {

        init();
        final Vie vie = Vie.getInstance();
        vie.bindAddEntities("add", new I_EntityCallback() {

            public void execute(Entity entity) {

                editable(entity, vie);

            }
        });
        vie.bindAddEntities("change", new I_EntityCallback() {

            public void execute(Entity entity) {

                saveButton(entity, vie);

            }
        });
        vie.load("rdfa", "body [about]", new I_EntityArrayCallback() {

            public void execute(JsArray<Entity> entities) {

                // noop
            }
        });

    }

    protected static final native void init() /*-{
		$wnd.changedEntities = [];
		$wnd.saveButton = null;
    }-*/;

    /**
     * Makes the page editable.<p>
     * 
     * @param entity 
     */
    protected static final native void editable(Entity entity, Vie v) /*-{

		$wnd.jQuery('[about="' + entity.getSubjectUri() + '"] [property]')
				.each(function() {
					if (v.services.rdfa.getElementSubject(this) !== entity.id) {
						return;
					}
					var editableElement = $wnd.jQuery(this);
					var property = v.services.rdfa.getElementPredicate(this);
					// To use Hallo, replace next line with:
					// editableElement.hallo();
					// Note: you'll also want to configure Hallo to include some plugins
					editableElement.attr('contenteditable', true);
					// To use Hallo, replace next 2 lines with:
					// editableElement.bind('hallomodified', function(event, data) {
					//   var content = data.content;   
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

    protected static final native void saveButton(Entity entity, Vie v) /*-{

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