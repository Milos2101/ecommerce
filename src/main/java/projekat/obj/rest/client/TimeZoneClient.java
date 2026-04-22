package projekat.obj.rest.client;


import projekat.obj.model.TimeResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "timezone-api")
public interface TimeZoneClient {
    @GET
    @Path("/api/time/current/ip")
    TimeResponse getTimeByIp(@QueryParam("ipAddress") String ipAddress);
}
