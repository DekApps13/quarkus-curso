package quarkus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/temperaturas")
public class TemperaturasResource {
	
	private List<Temperatura> valores = new ArrayList<>();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Temperatura nueva(Temperatura temp) {
		valores.add(temp);
		return temp;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Temperatura> list() {	// Quarkus detecta que estamos devolviendo una Lista y automáticamente lo transforma a un Array de Json
		return Collections.unmodifiableList(valores);
	}
	
	@GET
	@Path("/m1")
	public Temperatura medicion() {		// Quarkus por defecto produce 'application/json' en los EndPoints
		return new Temperatura("Arraiján", 16, 36);
	}
	
	@GET
	@Path("/m2")
	@Produces(MediaType.APPLICATION_JSON) // MediaType.APPLICATION_JSON invoca la constante 'application/json' 
	public Temperatura medicion2() {
		return new Temperatura("La Chorrera", 14, 37);
	}
}
