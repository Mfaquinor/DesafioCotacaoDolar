package com.cateno.clients;

import com.cateno.forms.DollarQuoteForm;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/versao/v1/odata")
@RegisterRestClient(configKey = "api.dollar")
public interface DollarQuoteRestClient {

    @GET
    @Path("/CotacaoDolarDia(dataCotacao=@dataCotacao)")
    @Produces(MediaType.APPLICATION_JSON)
    DollarQuoteForm getDollarQuoteByDate(@QueryParam("@dataCotacao") String date);
}
