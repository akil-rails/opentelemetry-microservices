package me.preissler.thomas.iseven.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import me.preissler.thomas.iseven.control.IsOddApi;

@Path("/")
public class IsEvenResource {

  @RestClient
  IsOddApi isOddApi;

  @GET
  @Path("/{number}")
  public boolean multiply(@PathParam("number") String number) {
    return !isOddApi.isOdd(number);
  }
}
