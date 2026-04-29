package projekat.obj.rest.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import projekat.obj.model.CurrencyResponse;

@RegisterRestClient(configKey = "currency-api")
@Path("/api/rates")
public interface CurrencyClient {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    CurrencyResponse getRates(@QueryParam("from") String from, @QueryParam("to") String to);
}

