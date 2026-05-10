package projekat.obj.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import projekat.obj.exception.UsersException;
import projekat.obj.model.MultipartBody;
import projekat.obj.model.Orders;
import projekat.obj.model.User;
import projekat.obj.service.UsersService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Path("/user")
public class UsersResource {

    @Inject
    private UsersService usersService;

    @POST
    @RolesAllowed("admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addUser")
    public Response addUser(User user){
        try {
            usersService.addUser(user);
        }catch (UsersException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
   @Path("/getAllUsers")
    public Response getAllUsers(){
    List<User> users = null;
    try{
        users = usersService.getAllUsers();
    }catch (UsersException e){
       return Response.status(Response.Status.NO_CONTENT).entity(e.getMessage()).build();
    }
    return Response.ok().entity(users).build();
  }

  @GET
    @Path("/getUserByName")
    @Produces (MediaType.APPLICATION_JSON)
    public Response getUserByName(@QueryParam("name")String name){
        List <User> users = usersService.getUserByName(name);
                return Response.ok().entity(users).build();
  }

  @GET
    @Path("/getOrdersByUserId")
  @Produces(MediaType.APPLICATION_JSON)
    public Response getOrdersByUserId(@QueryParam("id") Long id){
        List <Orders> orders = usersService.getOrdersByUserId(id);
        return Response.ok().entity(orders).build();
  }

  @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/addUserImage")
    public Response addImageToUser(MultipartBody multipartBody){

        try {
            Files.copy(multipartBody.file.uploadedFile(), java.nio.file.Path.of("C:\\Users\\PC\\OneDrive\\Desktop\\imagesProject", multipartBody.file.fileName()), StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
                return Response.serverError().build();

      }
        return Response.ok().build();
  }

}
