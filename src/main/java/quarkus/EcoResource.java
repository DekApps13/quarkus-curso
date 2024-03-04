package quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/saludar")
public class EcoResource {

	@GET
	public String saludar() {
		return "Hola";
	}
	
	@GET
	@Path("/dias")
	public String dias() {
		return "Hola, muy buenos dias";
	}
	
	@GET
	@Path("/tardes")
	public String tardes() {
		return "Hola, muy buenas tardes";
	}
	
	@GET @Path("/noches")
	public String noches() {
		return "Hola, muy buenas noches";
	}
}
