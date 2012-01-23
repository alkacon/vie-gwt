/*
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) Alkacon Software GmbH (http://www.alkacon.com)
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

package com.alkacon.vie.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * The entity wrapper.<p>
 */
public final class Entity extends JavaScriptObject implements HasValueChangeHandlers<I_Entity>, I_Entity {

    /** Flag indicating that id's should always be wrapped in '<>' brackets. */
    private static boolean USE_BRACKET_WRAPPED_IDS;

    /**
     * Constructor, for internal use only.<p>
     */
    protected Entity() {

    }

    /**
     * Sets the use bracket wrapped id's flag.<p>
     * 
     * @param useBrackets <code>true</code> to use bracket wrapped id's
     */
    public static void setUseBracketWrappetIds(boolean useBrackets) {

        USE_BRACKET_WRAPPED_IDS = useBrackets;
    }

    /**
     * Helper method for firing a 'value changed' event.<p>
     *
     * @param entity the entity that changed
     */
    private static void fireValueChangedEvent(Entity entity) {

        ValueChangeEvent.fire(entity, entity);
    }

    /**
     * Adds this handler to the widget.
     *
     * @param <H> the type of handler to add
     * @param type the event type
     * @param handler the handler
     * 
     * @return {@link HandlerRegistration} used to remove the handler
     */
    public <H extends EventHandler> HandlerRegistration addHandler(final H handler, GwtEvent.Type<H> type) {

        return ensureHandlers().addHandler(type, handler);
    }

    /**
     * @see com.google.gwt.event.logical.shared.HasValueChangeHandlers#addValueChangeHandler(com.google.gwt.event.logical.shared.ValueChangeHandler)
     */
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<I_Entity> handler) {

        return addHandler(handler, ValueChangeEvent.getType());
    }

    /**
     * @see com.google.gwt.event.shared.HasHandlers#fireEvent(com.google.gwt.event.shared.GwtEvent)
     */
    public void fireEvent(GwtEvent<?> event) {

        if (getHandlerManager() != null) {
            getHandlerManager().fireEvent(event);
        }

    }

    /**
     * @see com.alkacon.vie.client.I_Entity#getCollectionAttribute(java.lang.String)
     */
    public native I_EntityCollection getCollectionAttribute(String attributeName) /*-{

        var result = this.get(attributeName);
        if (result.isCollection)
            return result;
        else
            throw Exception("Wrong attribute type");
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Entity#getId()
     */
    public native String getId() /*-{
        var subject = this.getSubject();
        if (!@com.alkacon.vie.client.Entity::USE_BRACKET_WRAPPED_IDS) {
            if (subject.indexOf('<') == 0) {
                subject = subject.substr(1);
            }
            if (subject.lastIndexOf('>') == subject.length - 1) {
                subject = subject.substring(0, subject.length - 1);
            }
        }
        return subject;
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Entity#getStringAttribute(java.lang.String)
     */
    public native String getStringAttribute(String attributeName) /*-{

        var result = this.get(attributeName);
        if (result.isCollection)
            throw Exception("Wrong attribute type");
        return result;
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Entity#hasAttribute(java.lang.String)
     */
    public native boolean hasAttribute(String attributeName) /*-{

        return this.has(attributeName);
    }-*/;

    /**
     * Returns if the entity has the given type.<p>
     *
     * @param type the type
     *
     * @return <code>true</code> if the entity has the given type
     */
    public native boolean hasType(String type) /*-{

        return this.hasType(type);
    }-*/;

    /**
     * Removes the given attribute.<p>
     *
     * @param attributeName the attribute name
     */
    public native void removeAttribute(String attributeName) /*-{

        this.unset(attributeName);
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Entity#removeAttributeSilent(java.lang.String)
     */
    public native void removeAttributeSilent(String attributeName) /*-{

        this.unset(attributeName, {
            silent : true
        });
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Entity#setAttribute(java.lang.String, com.google.gwt.core.client.JavaScriptObject)
     */
    public native void setAttribute(String attributeName, JavaScriptObject value) /*-{

        this.set(attributeName, value);
    }-*/;

    /**
     * Binds the {@link #com.alkacon.vie.client.Entity.fireValueChangedEvent(Entity)} method 
     * to the native change function and sets the handler manager for this instance.<p>
     *
     * @param handlerManager the handler manager to use
     */
    private native void bindChange(HandlerManager handlerManager)/*-{

        this.handlerManager = handlerManager;
        var self = this;
        this
                .bind(
                        "change",
                        function() {
                            @com.alkacon.vie.client.Entity::fireValueChangedEvent(Lcom/alkacon/vie/client/Entity;)(self);
                        });
    }-*/;

    /**
     * Ensures the existence of the handler manager.
     *
     * @return the handler manager
     * */
    private HandlerManager ensureHandlers() {

        if (getHandlerManager() == null) {
            bindChange(new HandlerManager(this));
        }
        return getHandlerManager();
    }

    /**
     * Returns the handler manager.<p>
     *
     * @return the handler manager
     */
    private native HandlerManager getHandlerManager()/*-{

        return this.handlerManager;
    }-*/;
}
