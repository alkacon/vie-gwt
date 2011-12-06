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

/**
 * The able interface.<p>
 */
public interface I_Able {

    /** A enum for the possible types. */
    enum AbleType {

        /** Able type. */
        analyzeable,

        /** Able type. */
        findable,

        /** Able type. */
        loadable,

        /** Able type. */
        removeable,

        /** Able type. */
        savable
    }

    /**
     * Delegator.<p>
     * 
     * @return the reference on itself
     */
    I_Able execute();

    /**
     * Delegator.<p>
     * 
     * @return the reference on itself
     */
    I_Able success();

    /**
     * Delegator.<p>
     * 
     * @param service the names of the services to execute on
     * 
     * @return the reference on itself
     */
    I_Able using(String service);

}