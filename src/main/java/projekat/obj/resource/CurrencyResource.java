package projekat.obj.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import projekat.obj.service.CurrencyService;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class CurrencyResource {

    @Inject
    CurrencyService currencyService;

    @GET
    @RolesAllowed("admin")
    @Path("/currencyConversion")
    public Response currencyConversion(@QueryParam("from") String from, @QueryParam("to") String to, @QueryParam("value") double value, @QueryParam("userId") Long userId) {
        return currencyService.getExchangeRates(from, to, value, userId);
    }
}
