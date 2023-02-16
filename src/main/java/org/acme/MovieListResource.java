package org.acme;

import org.acme.dto.Movies;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/movies")
public class MovieListResource {
    List<String> list = new ArrayList<>();
    Map<Object, Object> movies = new HashMap<>();

    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> moviesList() {
        list.add("Lost in Translation");
        list.add("White Christmas ");
        list.add("Cloud Atlas");
        list.add("Under the Tuscan Sun");
        list.add("Before sunrise");
        list.add("Robin Hood: Prince of Thieves");
        return list;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response movies() {
        movies.put("1", "Lost in Translation");
        movies.put("2", "White Christmas ");
        movies.put("3", "Cloud Atlas");
        movies.put("4", "Under the Tuscan Sun");
        movies.put("5", "Summertime");
        return Response.ok(movies).build();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMovie(Movies newMovie) {
        movies.put(newMovie.getId(), newMovie.getTitle());
        return Response.ok(movies).build();
    }

}
