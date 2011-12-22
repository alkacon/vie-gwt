
package com.alkacon.vie.server;

import com.alkacon.vie.client.I_VieService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class VieServiceImpl extends RemoteServiceServlet implements I_VieService {

    /**
     * @see com.alkacon.vie.client.I_VieService#vieServer(java.lang.String)
     */
    public String vieServer(String input) throws IllegalArgumentException {

        return null;
    }
}
