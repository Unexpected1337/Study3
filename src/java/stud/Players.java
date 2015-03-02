/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stud;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import model.Player;

@Path("")
public class Players {

    static Map<Integer, Player> players = new HashMap<>();

    @Context
    private UriInfo context;

    public Players() {
        players.put(1, new Player(1, "James Rodríguez", "Columbia"));
        players.put(2, new Player(2, "Thomas Mueller", "Germany"));
        players.put(3, new Player(3, "Messi", "Italy"));
        players.put(4, new Player(4, "Neymar", "Spain"));
        players.put(5, new Player(5, "Van Persie", "Dutchland"));

    }

    @GET
    @Produces("application/json")
    @Path("AllPlayerNames")
    public String getAll() {
        Gson gson = new Gson();
        java.lang.reflect.Type type = new TypeToken<Collection<Player>>() {
        }.getType();
        String json = gson.toJson(players.values(), type);
        return json;
    }

    @GET
    @Produces("application/json")
    @Path("player/{id}")
    public String getCustomer(@PathParam("id") int id) {
        Player p = players.get(id);
        Gson gson = new Gson();
        if (p == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);

        }
        String play = gson.toJson(p);
        return play;
    }

   
}
