package quarkus;

import java.util.Optional;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/saludar")
public class EcoResource {

	@GET
	public String saludar(@QueryParam("mensaje") String mensaje) {
		// Forma usando la API Optional
		return Optional.ofNullable(mensaje)
				.map(n -> "> " + n)
				.orElse("No se muy bien qué decir");
	}
	
	@GET
	@Path("/{nombre}")
	public String saludo(@PathParam("nombre") String nombre) {
		return "Hola, " + nombre;
	}
	
	@GET
	@Path("/{nombre}/mayusculas")
	public String gritar(@PathParam("nombre") String nombre) {
		return "HOLA, " + nombre.toUpperCase();
	}
	
	/*
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
	*/
}
