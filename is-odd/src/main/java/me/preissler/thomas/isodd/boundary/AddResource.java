package me.preissler.thomas.isodd.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class AddResource {

  @GET
  @Path("/{number}")
  public boolean isOdd(@PathParam("number") long number) {
    boolean isOdd = false;

    // by intention, the algorithm is cpu-intensive to create some delay by using larger numbers
    for (long i = 0; i < Math.abs(number); i++) {
      isOdd = !isOdd;
    }

    return isOdd;
  }
}
