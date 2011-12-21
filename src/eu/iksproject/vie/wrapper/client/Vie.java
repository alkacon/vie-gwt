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

/**
 * The VIE wrapper singelton.<p>
 */
public class Vie extends JavaScriptObject implements I_Vie {

    /** The instance this class vie. */
    private static Vie m_instance;

    /**
     * Hide the constructor.<p>
     */
    protected Vie() {

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
     * Creates a new JS VIE Object.<p>
     * 
     * @return the JS VIE object
     */
    private static final native Vie createInstance() /*-{

		var v = new $wnd.VIE();
		v.use(new v.RdfaService());
		return v;
    }-*/;

    /**
     * @see eu.iksproject.vie.wrapper.client.I_Vie#load(java.lang.String, java.lang.String, eu.iksproject.vie.wrapper.client.I_Callback)
     */
    public final void load(String service, String selector, I_Callback callback) {

        loadInternal(service, selector, callback);
    }

    /**
     * 
     * @param service
     * @param selector
     * @param callback
     */
    private final native void loadInternal(String service, String selector, I_Callback callback) /*-{

		$wnd.console.log(service);
		$wnd.console.log(selector);
		if (callback) {
			$wnd.console.log("callback is there");
		}

		var vie = @eu.iksproject.vie.wrapper.client.Vie::m_instance;
		if (vie) {
			$wnd.console.log("vie is there");
		}

		var selection = $wnd.jQuery(selector);
		if (selection) {
			$wnd.console.log(selection);
		}

		var load = vie.load(selection);
		if (load) {
			$wnd.console.log("load", load);
		}

		var from = load.from(service);
		if (from) {
			$wnd.console.log("from", from);
		}

		var execute = from.execute();
		if (execute) {
			$wnd.console.log("execute", execute);
		}

		function typeOf(obj) {
			if (typeof (obj) == 'object') {
				if (obj.length) {
					return 'array';
				} else {
					return 'object';
				}
			} else {
				return typeof (obj);
			}
		}
		var call = function(entities) {
			$wnd.console.log(entities);
			$wnd.console.log(typeOf(entities));
			for (entity in entities) {
				$wnd.console.log(entity);
			}
			// callback.@eu.iksproject.vie.wrapper.client.I_Callback::execute([Lcom/google/gwt/core/client/JavaScriptObject;)(entities);
		}
		if (typeof call === 'function') {
			$wnd.console.log("call function", call);
			// call();
		}
		if (typeof execute.success === 'function') {
			$wnd.console.log("success function", execute.success);
		}

		execute.success(call);

    }-*/;
}
