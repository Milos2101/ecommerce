package projekat.obj.rest.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "ip-api")
public interface IpClient {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String getPublicIp();
}
