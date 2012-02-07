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

package com.alkacon.vie.client.example;

import com.alkacon.vie.client.widgets.HalloWidget;
import com.alkacon.vie.client.widgets.SimpleEditWidget;
import com.alkacon.vie.shared.I_Entity;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class VieEntryPoint implements EntryPoint {

    /**
     * Writes the given entity to the browsers log.<p>
     * 
     * Can only used in browsers that support a log.<p>
     * 
     * @param jsObject a js object
     */
    public static native void log(JavaScriptObject jsObject) /*-{

        if ($wnd.console) {
            $wnd.console.log(jsObject);
        }
    }-*/;

    /**
     * Writes the given entity to the browsers log.<p>
     * 
     * Can only used in browsers that support a log.<p>
     * 
     * @param entity the found entities
     */
    public static native void logEntity(I_Entity entity) /*-{

        if ($wnd.console) {
            $wnd.console.log(entity.as("JSON"));
        }
    }-*/;

    /**
     * This is the entry point method.<p>
     */
    public void onModuleLoad() {

        if (useHallo()) {
            HalloWidget.makeEditable();
        } else {
            SimpleEditWidget.makeEditable();
        }
    }

    /**
     * Returns <code>true</code> if we should use hallo.<p>
     * 
     * @return <code>true</code> if we should use hallo
     */
    private native boolean useHallo()/*-{

        if ($wnd.useHallo) {
            return $wnd.useHallo;
        }
        return false;
    }-*/;
}
