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
 * The gwt impl of able.<p>
 */
public class Able implements I_Able {

    /** The native JavaScript object representing an Able implementation. */
    private JavaScriptObject m_ableJS;

    /**
     * Public constructor.<p>
     * 
     * @param type the type of this able
     * @param vieJS the vie
     * @param optionsJS the options
     */
    public Able(AbleType type, JavaScriptObject vieJS, JavaScriptObject optionsJS) {

        m_ableJS = null;
        switch (type) {
            case analyzeable:
                analyze(vieJS, optionsJS);
                break;
            case findable:
                find(vieJS, optionsJS);
                break;
            case loadable:
                load(vieJS, optionsJS);
                break;
            case removeable:
                remove(vieJS, optionsJS);
                break;
            case savable:
                save(vieJS, optionsJS);
                break;
            default:
                break;
        }
    }

    /**
     * @see eu.iksproject.vie.wrapper.client.I_Able#execute()
     */
    public native I_Able execute() /*-{

		var able = this.@eu.iksproject.vie.wrapper.client.Able::m_ableJS;
		this.@eu.iksproject.vie.wrapper.client.Able::m_ableJS = able.execute();
		return this;
    }-*/;

    /**
     * @see eu.iksproject.vie.wrapper.client.I_Able#success()
     */
    public native I_Able success() /*-{

		var able = this.@eu.iksproject.vie.wrapper.client.Able::m_ableJS;
		able.success(function(entities) {
			$wnd.onSuccess(entities)
		});
		return this;
    }-*/;

    /**
     * @see eu.iksproject.vie.wrapper.client.I_Able#using(java.lang.String)
     */
    public native I_Able using(String service) /*-{

		var able = this.@eu.iksproject.vie.wrapper.client.Able::m_ableJS;
		this.@eu.iksproject.vie.wrapper.client.Able::m_ableJS = able
				.using(service);
		return this;
    }-*/;

    /**
     * Analyze.<p>
     * 
     * @param vieJS the vie instance
     * @param optionsJS the options
     * 
     * @return the able JS
     */
    private native JavaScriptObject analyze(JavaScriptObject vieJS, JavaScriptObject optionsJS) /*-{

		this.@eu.iksproject.vie.wrapper.client.Able::m_ableJS = vieJS
				.analyze(optionsJS);
    }-*/;

    /**
     * Find.<p>
     * 
     * @param vieJS the vie instance
     * @param optionsJS the options
     */
    private native void find(JavaScriptObject vieJS, JavaScriptObject optionsJS) /*-{

		this.@eu.iksproject.vie.wrapper.client.Able::m_ableJS = vieJS
				.find(optionsJS);
    }-*/;

    /**
     * Load.<p>
     * 
     * @param vieJS the vie instance
     * @param optionsJS the options
     */
    private native void load(JavaScriptObject vieJS, JavaScriptObject optionsJS) /*-{

		this.@eu.iksproject.vie.wrapper.client.Able::m_ableJS = vieJS
				.load(optionsJS);
    }-*/;

    /**
     * Remove.<p>
     * 
     * @param vieJS the vie instance
     * @param optionsJS the options
     */
    private native void remove(JavaScriptObject vieJS, JavaScriptObject optionsJS) /*-{

		this.@eu.iksproject.vie.wrapper.client.Able::m_ableJS = vieJS
				.remove(optionsJS);
    }-*/;

    /**
     * Save.<p>
     * 
     * @param vieJS the vie instance
     * @param optionsJS the options
     */
    private native void save(JavaScriptObject vieJS, JavaScriptObject optionsJS) /*-{

		this.@eu.iksproject.vie.wrapper.client.Able::m_ableJS = vieJS
				.save(optionsJS);
    }-*/;
}
