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
     * The success method.<p>
     * 
     * @param entity the found entities
     */
    protected native void logEntity(JavaScriptObject entity) /*-{

		$wnd.console.log(entity.as("JSON"));
    }-*/;

    /**
     * This is the entry point method.<p>
     */
    public void onModuleLoad() {

        Scheduler.get().scheduleDeferred(new ScheduledCommand() {

            /**
             * @see com.google.gwt.core.client.Scheduler.ScheduledCommand#execute()
             */
            public void execute() {

                Vie vie = Vie.getInstance();
                vie.load("rdfa", "[typeof][about]", new I_Callback() {

                    public void execute(JavaScriptObject[] entities) {

                        for (JavaScriptObject entity : entities) {
                            logEntity(entity);
                        }
                    }
                });
            }
        });
    }
}
