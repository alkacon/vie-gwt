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

package eu.iksproject.vie.wrapper.client;

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
public final class Entity extends JavaScriptObject implements HasValueChangeHandlers<Entity> {

    private HandlerManager m_handlerManager;

    /**
     * Constructor, for internal use only.<p>
     */
    protected Entity() {

    }

    /**
     * Adds this handler to the widget.
     *
     * @param <H> the type of handler to add
     * @param type the event type
     * @param handler the handler
     * @return {@link HandlerRegistration} used to remove the handler
     */
    public final <H extends EventHandler> HandlerRegistration addHandler(final H handler, GwtEvent.Type<H> type) {

        return ensureHandlers().addHandler(type, handler);
    }

    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Entity> handler) {

        return addHandler(handler, ValueChangeEvent.getType());
    }

    public void fireEvent(GwtEvent<?> event) {

        if (m_handlerManager != null) {
            m_handlerManager.fireEvent(event);
        }

    }

    /**
     * Returns an entity attribute.<p>
     * 
     * @param attributeName the attribute name
     * 
     * @return the attribute value
     */
    public native EntityCollection getCollectionAttribute(String attributeName) /*-{
        var result = this.get(attributeName);
        if (result.isCollection)
            return result;
        else
            throw Exception("Wrong attribute type");
    }-*/;

    /**
     * Returns an entity attribute.<p>
     * 
     * @param attributeName the attribute name
     * 
     * @return the attribute value
     */
    public native String getStringAttribute(String attributeName) /*-{
        var result = this.get(attributeName);
        if (result.isCollection)
            throw Exception("Wrong attribute type");
        return result;
    }-*/;

    /**
     * Returns the entity id/URI.<p>
     * 
     * @return the id/URI
     */
    public native String getUri() /*-{
        this.getSubjectUri();
    }-*/;

    /**
     * Returns if the entity has the given attribute.<p>
     * 
     * @param attributeName the attribute name
     * 
     * @return <code>true</code> if the entity has the given attribute
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
     * Removes the given attribute
     * 
     * @param attributeName the attribute name
     */
    public native void removeAttribute(String attributeName) /*-{
        this.unset(attributeName);
    }-*/;

    /**
     * Removes the attribute without triggering any change events.<p>
     * 
     * @param attributeName the attribute name
     */
    public native void removeAttributeSilent(String attributeName) /*-{
        this.unset(attributeName, {
            silent : true
        });
    }-*/;

    /**
     * Sets the given attribute.<p>
     * 
     * @param attributeName the attribute name
     * @param value the attribute value
     */
    public native void setAttribute(String attributeName, JavaScriptObject value) /*-{
        this.set(attributeName, value);
    }-*/;

    /**
     * Creates the {@link HandlerManager} used by this Widget. You can override
     * this method to create a custom {@link HandlerManager}.
     *
     * @return the {@link HandlerManager} you want to use
     */
    protected HandlerManager createHandlerManager() {

        return new HandlerManager(this);
    }

    /** 
     * Helper method for firing a 'value changed' event.<p>
     */
    protected void fireValueChangedEvent() {

        ValueChangeEvent.fire(this, this);
    }

    /**
     * Ensures the existence of the handler manager.
     *
     * @return the handler manager
     * */
    HandlerManager ensureHandlers() {

        if (m_handlerManager == null) {
            bindChange();
            m_handlerManager = createHandlerManager();
        }
        return m_handlerManager;
    }

    private native void bindChange()/*-{
        this
                .bind(
                        "change",
                        function() {
                            this.@eu.iksproject.vie.wrapper.client.Entity::fireValueChangedEvent()();
                        });
    }-*/;
}
