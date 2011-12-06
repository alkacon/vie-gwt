
package eu.iksproject.vie.wrapper.server;

import eu.iksproject.vie.wrapper.client.I_VieService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class VieServiceImpl extends RemoteServiceServlet implements I_VieService {

    /**
     * @see eu.iksproject.vie.wrapper.client.I_VieService#vieServer(java.lang.String)
     */
    public String vieServer(String input) throws IllegalArgumentException {

        return null;
    }
}
