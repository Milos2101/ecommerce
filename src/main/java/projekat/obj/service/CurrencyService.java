package projekat.obj.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import projekat.obj.exception.UsersException;
import projekat.obj.model.CurrencyResponse;
import projekat.obj.model.User;
import projekat.obj.rest.client.CurrencyClient;

@ApplicationScoped
public class CurrencyService {

    @Inject
    @RestClient
    CurrencyClient currencyClient;

    @Inject
    private UsersService usersService;

    @Transactional
    public Response getExchangeRates(String from, String to, double value, Long userId) {
        try {
            User user = usersService.getUserById(userId);
            if (user == null) {
                throw new UsersException("Korisnik saD " + userId + " nije!");
            }

            CurrencyResponse currencyResponse = currencyClient.getRates(from, to);
            double convertedValue = value * currencyResponse.getRateDouble();

            currencyResponse.setValue(value);
            currencyResponse.setConvertedValue(convertedValue);
            currencyResponse.setUser(user);

            user.getCurrencyResponses().add(currencyResponse);
            usersService.updateUser(user);

            return Response.ok(currencyResponse).build();
        } catch (UsersException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("ne valja: " + e.getMessage())
                    .build();
        }
    }
}
