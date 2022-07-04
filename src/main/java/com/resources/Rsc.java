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
    public Response postJSON(String payload) throws Exception
    {
        final Student emp=new Gson().fromJson(payload,Student.class);
        System.out.println(emp.toString());
        //return Response.noContent().build();
        return Response.ok(emp.toString()).build();
    }

    @PUT
    @Path("/JSON")
//    @Produces("")
    public Response putJSON(@QueryParam("name") String name)
    {
        //@PathParam("id") String id;
        Student obj = new Student("Hussain", "BITF19A523", "LHR");
        obj.setName(name);
        return Response.ok(obj.toString()).build();
    }




}