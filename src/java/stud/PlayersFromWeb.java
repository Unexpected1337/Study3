/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stud;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import model.Player;

@Path("PlayersFromWeb")
public class PlayersFromWeb {

    static Map<Integer, Player> players = new HashMap<>();

    @Context
    private UriInfo context;

    public PlayersFromWeb() {

    }

    @GET
    @Produces("application/json")
    public String getJson() throws MalformedURLException, IOException {

        URL url = new URL("http://footballpool.dataaccess.eu/data/info.wso/AllPlayerNames/JSON/debug?bSelected=");
        URLConnection con = url.openConnection();
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        System.out.println(jsonStr);
        scan.close();
        return jsonStr;

    }
 @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
 

}
