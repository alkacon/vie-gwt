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

import com.alkacon.vie.shared.I_Type;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The VIE wrapper singleton.<p>
 */
public final class Vie extends JavaScriptObject implements I_Vie {

    /** The singleton Vie instance. */
    private static Vie m_instance;

    /**
     * Protected constructor, needed for sub classes of GWT-JavaScriptObjects.<p>
     */
    protected Vie() {

        // noop
    }

    /**
     * Returns the vie instance.<p>
     * 
     * @return the vie instance
     */
    public static Vie getInstance() {

        if (m_instance == null) {
            m_instance = createInstance();
        }
        return m_instance;
    }

    /**
     * Removes pointy brackets from beginning and end of the given string.<p>
     * 
     * @param value the value to manipulate
     * 
     * @return the bracket less string
     */
    public static String removePointyBrackets(String value) {

        if ((value.indexOf("<") == 0) && (value.indexOf(">") == (value.length() - 1))) {
            value = value.substring(1, value.length() - 1);
        }
        return value;
    }

    /**
     * Creates a new JS VIE object instance.<p>
     * 
     * @return the JS VIE object
     */
    private static native Vie createInstance() /*-{

        return new $wnd.VIE();
    }-*/;

    /**
     * Binds a given callback to the entities of vie.<p>
     * 
     * @param functionName the name of the function
     * @param callback the function that should be executed
     */
    public native void bindFunctionToEntities(String functionName, I_EntityCallback callback)/*-{

        this.entities
                .bind(
                        functionName,
                        function(entity) {
                            callback.@com.alkacon.vie.client.I_EntityCallback::execute(Lcom/alkacon/vie/client/Entity;)(entity);
                        });
    }-*/;

    /**
     * Creates a new entity registering it within VIE.<p>
     * 
     * @param entityId the entity id
     * @param entityType the entity type
     * 
     * @return the new entity
     */
    public native I_Entity createEntity(String entityId, String entityType) /*-{
        var entityType = this.types.get(entityType);
        var entityInstance;
        if (entityType != null) {
            // if the type is available, use it to create the new instance
            entityInstance = entityType.instance({
                '@subject' : entityId
            });
        } else {
            throw Error('Type has not been registered yet.');
        }
        return this.entities.addOrUpdate(entityInstance);
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Vie#createType(java.lang.String)
     */
    public native I_Type createType(String id) /*-{
        var type = new this.Type(id);

        // all type inherit from owl:Thing
        type.inherit("owl:Thing");
        this.types.add(type);
        return type;
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Vie#getAttributeElements(com.google.gwt.user.client.Element)
     */
    public List<Element> getAttributeElements(Element context) {

        return select("[property]", context);
    }

    /**
     * @see com.alkacon.vie.client.I_Vie#getAttributeElements(com.alkacon.vie.client.I_Entity, java.lang.String, com.google.gwt.user.client.Element)
     */
    public List<Element> getAttributeElements(I_Entity entity, String attributeName, Element context) {

        return getAttributeElements(entity.getId(), attributeName, context);
    }

    /**
     * @see com.alkacon.vie.client.I_Vie#getAttributeElements(java.lang.String, java.lang.String, com.google.gwt.user.client.Element)
     */
    public List<Element> getAttributeElements(String entityId, String attributeName, Element context) {

        return select(
            "[about='"
                + Vie.removePointyBrackets(entityId)
                + "'] [property='"
                + Vie.removePointyBrackets(attributeName)
                + "']",
            context);
    }

    /**
     * Returns the element subject.<p>
     * 
     * @param element the DOM element
     * 
     * @return the elements subject
     */
    public native String getElementPredicate(Element element) /*-{

        return this.services.rdfa.getElementPredicate(element);
    }-*/;

    /**
     * Returns the element subject.<p>
     * 
     * @param element the DOM element
     * 
     * @return the elements subject
     */
    public native String getElementSubject(Element element) /*-{

        return this.services.rdfa.getElementSubject(element);
    }-*/;

    /**
     * Returns the entities of vie.<p>
     * 
     * @return the entities
     */
    public native I_EntityCollection getEntities() /*-{

        return this.entities;
    }-*/;

    /**
     * Returns the entity with the given id.<p>
     * 
     * @param entityId the entity id
     * 
     * @return the entity
     */
    public native I_Entity getEntity(String entityId) /*-{

        return this.entities.get(entityId);
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Vie#getType(java.lang.String)
     */
    public native I_Type getType(String id) /*-{

        return this.types.get(id);
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Vie#load(java.lang.String, java.lang.String, com.alkacon.vie.client.I_EntityArrayCallback)
     */
    public void load(String service, String selector, I_EntityArrayCallback callback) {

        loadInternal(service, selector, callback);
    }

    /**
     * Returns a list of elements matching the given CSS selector.<p>
     * 
     * @param selector the selector
     * @param context the context element, if <code>null</code> the body element is used as context
     * 
     * @return the element list
     */
    public List<Element> select(String selector, Element context) {

        JsArray<Element> results = JavaScriptObject.createArray().cast();
        if (context == null) {
            context = RootPanel.getBodyElement();
        }
        results = select(selector, context, results);
        List<Element> elements = new ArrayList<Element>();
        for (int i = 0; i < results.length(); i++) {
            elements.add(results.get(i));
        }
        return elements;
    }

    /**
     * Sets VIE to use the RDFA service.<p>
     */
    public native void useRdfaService() /*-{
        this.use(new this.RdfaService());
    }-*/;

    /**
     * Executes the load function on the VIE instance.<p>
     * 
     * @param service the name of the service to use
     * @param selector the jQuery selector to specify the HTML-Elements inside the DOM to search for entities
     * @param callback the callback that is executed on success
     * 
     * @see com.alkacon.vie.client.I_Vie#load(java.lang.String, java.lang.String, com.alkacon.vie.client.I_EntityArrayCallback)
     */
    private native void loadInternal(String service, String selector, I_EntityArrayCallback callback) /*-{

        var vie = @com.alkacon.vie.client.Vie::m_instance;
        var call = function(entities) {
            callback.@com.alkacon.vie.client.I_EntityArrayCallback::execute(Lcom/google/gwt/core/client/JsArray;)(entities);
        }
        vie.load({
            element : $wnd.jQuery(selector)
        }).using(service).execute().success(call);
    }-*/;

    /**
     * Returns an array of elements matching the given CSS selector.<p>
     * 
     * @param selector the selector
     * @param context the context element, if <code>null</code> the body element is used as context
     * @param results the array to add the matching elements to
     * 
     * @return the element array
     */
    private native JsArray<Element> select(String selector, Element context, JsArray<Element> results) /*-{

        this.jQuery(selector, context).each(function() {
            results.push(this);
        });
        return results;
    }-*/;
}
