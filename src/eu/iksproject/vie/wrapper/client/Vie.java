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
 * The VIE wrapper class.<p>
 */
public class Vie implements I_Vie {

    /** The JS VIE Object. */
    private JavaScriptObject m_vie;

    /**
     * Default constructor.<p>
     */
    public Vie() {

        m_vie = createInstance();
    }

    /**
     * @see eu.iksproject.vie.wrapper.client.I_Vie#analyze(com.google.gwt.core.client.JavaScriptObject)
     */
    public I_Able analyze(JavaScriptObject options) {

        return new Able(I_Able.AbleType.analyzeable, m_vie, options);
    }

    /**
     * @see eu.iksproject.vie.wrapper.client.I_Vie#find(com.google.gwt.core.client.JavaScriptObject)
     */
    public I_Able find(JavaScriptObject options) {

        return new Able(I_Able.AbleType.analyzeable, m_vie, options);
    }

    /**
     * @see eu.iksproject.vie.wrapper.client.I_Vie#load(com.google.gwt.core.client.JavaScriptObject)
     */
    public I_Able load(JavaScriptObject options) {

        return new Able(I_Able.AbleType.loadable, m_vie, options);
    }

    /**
     * @see eu.iksproject.vie.wrapper.client.I_Vie#remove(com.google.gwt.core.client.JavaScriptObject)
     */
    public I_Able remove(JavaScriptObject options) {

        return new Able(I_Able.AbleType.analyzeable, m_vie, options);
    }

    /**
     * @see eu.iksproject.vie.wrapper.client.I_Vie#save(com.google.gwt.core.client.JavaScriptObject)
     */
    public I_Able save(JavaScriptObject options) {

        return new Able(I_Able.AbleType.analyzeable, m_vie, options);
    }

    /**
     * @see eu.iksproject.vie.wrapper.client.I_Vie#use(java.lang.String)
     */
    public native void use(String serviceName) /*-{

        var vie = this.@eu.iksproject.vie.wrapper.client.Vie::m_vie;
        vie.use(new vie.RdfaService());
    }-*/;

    /**
     * Creates a new JS VIE Object.<p>
     * 
     * @return the JS VIE object
     */
    private native JavaScriptObject createInstance() /*-{

        return new $wnd.VIE();
    }-*/;
}
