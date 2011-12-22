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
import com.google.gwt.dom.client.Element;

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
     * Creates a new JS VIE object instance.<p>
     * 
     * @return the JS VIE object
     */
    private static final native Vie createInstance() /*-{

		var v = new $wnd.VIE();
		v.use(new v.RdfaService());
		return v;
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
     * Returns the entities of vie
     * 
     * @return the entities
     */
    public native EntityCollection getEntities() /*-{

		return this.entities;
    }-*/;

    /**
     * Returns the element subject.<p>
     * 
     * @param element the DOM element
     * 
     * @return the elements subject
     */
    public final native String getElementSubject(Element element) /*-{

		return this.services.rdfa.getElementSubject(element);
    }-*/;

    /**
     * Returns the element subject.<p>
     * 
     * @param element the DOM element
     * 
     * @return the elements subject
     */
    public final native String getElementPredicate(Element element) /*-{

		return this.services.rdfa.getElementPredicate(element);
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Vie#load(java.lang.String, java.lang.String, com.alkacon.vie.client.I_EntityArrayCallback)
     */
    public final void load(String service, String selector, I_EntityArrayCallback callback) {

        loadInternal(service, selector, callback);
    }

    /**
     * Executes the load function on the VIE instance.<p>
     * 
     * @param service the name of the service to use
     * @param selector the jQuery selector to specify the HTML-Elements inside the DOM to search for entities
     * @param callback the callback that is executed on success
     * 
     * @see com.alkacon.vie.client.I_Vie#load(java.lang.String, java.lang.String, com.alkacon.vie.client.I_EntityArrayCallback)
     */
    private final native void loadInternal(String service, String selector, I_EntityArrayCallback callback) /*-{

		var vie = @com.alkacon.vie.client.Vie::m_instance;
		var call = function(entities) {
			callback.@com.alkacon.vie.client.I_EntityArrayCallback::execute(Lcom/google/gwt/core/client/JsArray;)(entities);
		}
		vie.load({
			element : $wnd.jQuery(selector)
		}).using(service).execute().success(call);
    }-*/;
}
