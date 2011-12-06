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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class VieEntryPoint implements EntryPoint {

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.<p>
     */
    private final I_VieServiceAsync vieService = GWT.create(I_VieService.class);

    /**
     * Exports the onSuccess method.<p>
     */
    public static native void exportStaticMethod() /*-{
        $wnd.onSuccess = $entry(@eu.iksproject.vie.wrapper.client.VieEntryPoint::onSuccess(Lcom/google/gwt/core/client/JavaScriptObject;));
    }-*/;

    /**
     * The success method.<p>
     * 
     * @param entities the found entities
     */
    public static native void onSuccess(JavaScriptObject entities) /*-{

		for ( var i = 0; i < entities.length; i++) {
			var entity = entities[i];
			// $wnd.console.log(entity.as("JSON"));
		}
    }-*/;

    /**
     * Creates a vie instance.<p>
     * 
     * @return a vie instance
     */
    public Vie getInstance() {

        return new Vie();
    }

    /**
     * This is the entry point method.<p>
     */
    public void onModuleLoad() {

        Scheduler.get().scheduleDeferred(new ScheduledCommand() {

            /**
             * @see com.google.gwt.core.client.Scheduler.ScheduledCommand#execute()
             */
            public void execute() {

                exportStaticMethod();
                Vie vie = new Vie();
                vie.use(null);
                vie.load(selectElement("[typeof][about]")).using("rdfa").execute().success();
            }
        });
    }

    /**
     * Returns a JS object selected by jquery.<p>
     * 
     * @param jQuerySelector the selector to use
     * 
     * @return the element
     */
    protected native JavaScriptObject selectElement(String jQuerySelector) /*-{

		return {
			element : $wnd.jQuery(jQuerySelector)
		};
    }-*/;
}
