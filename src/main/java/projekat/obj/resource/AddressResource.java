package projekat.obj.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import projekat.obj.model.Address;
import projekat.obj.service.AddressService;

import java.util.List;

@Path("/address")
public class AddressResource {

    @Inject
    private AddressService addressService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addAddress")
    public String addAddress(Address address){
        addressService.addAddress(address);
        return "hi milos";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllAddress")
    public Response getAllAddress() {
        List<Address> address = addressService.getAllAddress();
        return Response.ok().entity(address).build();
    }
}
