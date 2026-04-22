package projekat.obj.resource;

import projekat.obj.rest.client.IpClient;
import projekat.obj.rest.client.TimeZoneClient;
import projekat.obj.rest.client.TimeZoneClient;
import projekat.obj.model.User;
import projekat.obj.model.TimeResponse;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import projekat.obj.model.User;

@Path("/timezone")
public class TimeZoneResource {

    @Inject
    @RestClient
    IpClient ipClient;

    @Inject
    @RestClient
    TimeZoneClient timeZoneClient;

    @Inject
    EntityManager em;

    @GET
    @Path("/current")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCurrentTimeZone() {
        String ip = ipClient.getPublicIp();
        System.out.println("ip adresa je: " + ip);
        TimeResponse timeResponse = timeZoneClient.getTimeByIp(ip);
        System.out.println(timeResponse);
        return Response.ok().entity(timeResponse).build();
    }

    @GET
    @Path("/getTimezoneByIP")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getTimezoneByIP(@QueryParam("userId") Long userId) {

        User user = em.find(User.class, userId);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User nije pronadjen").build();
        }

        String ip = ipClient.getPublicIp();
        System.out.println("ip: " + ip);

        TimeResponse timeResponse = timeZoneClient.getTimeByIp(ip);

        timeResponse.setUser(user);
        em.persist(timeResponse);
        System.out.println(timeResponse);
        return Response.ok().entity(timeResponse).build();
    }
}