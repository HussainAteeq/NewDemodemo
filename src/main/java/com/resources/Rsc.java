package com.resources;


import com.google.gson.Gson;
import com.google.gson.JsonObject;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/hello-world")
public class Rsc {


    @GET
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("/JSON")

    public Object getSt()
    {
        JsonObject ob = new JsonObject();
        ob.addProperty("CONNECTION",true);
        ob.addProperty("MESSAGE","I'am a JSON message");
        return Response.ok(ob.toString()).build();
    }

    @POST
    @Path("/PostTest")
    public Response post(String payload) throws Exception
    {
        try {
            final Student obj = new Gson().fromJson(payload, Student.class);
            System.out.println(obj.toString());
            //return Response.noContent().build();
            if (obj.getName() == null || obj.getRoll_No() == null || obj.getCity() == null) {
                throw new Exception();
            }
        }catch (Exception e)
            {
                return Response.status(400).entity("Error").build();
            }
        return Response.ok(200).build();
    }

    @POST
    @Path("/Logininfo")
    public Response login(@QueryParam("StID") String Id, @QueryParam("password") String pass)
    {

        Student obj = new Student();
        if (Id.equals(obj.StID) && pass.equals(obj.password)) {
            System.out.println("Success");
            return Response.status(200).entity("success").build();
        }

        else {
            System.out.println("Error");
            return Response.status(401).entity("error").build();
        }
    }


    @PUT
    @Path("/JSON")
//    @Produces("")
    public Response putJSON(@QueryParam("name") String name)
    {
        Student obj = new Student();

            obj.setName(name);
        return Response.ok(obj.toString()).build();
    }

}