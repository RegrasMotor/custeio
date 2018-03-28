package com.prosegur.rulesEngine.services.restService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public interface VersionService {
	
    @GET
    @Path("/")
    @Produces("text/plain")
    String getVersion();
}
