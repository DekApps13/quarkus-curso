package quarkus;

import java.util.ArrayList;
import java.util.Arrays;
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
	public Temperatura nueva(Temperatura temp) {
		valores.add(temp);
		return temp;
	}

	@GET
	public List<Temperatura> list() {	// Quarkus detecta que estamos devolviendo un List y lo transforma a un Array de Json
		return Arrays.asList(
				new Temperatura("La Mesa", 23, 35),
				new Temperatura("Colón", 22, 39),
				new Temperatura("Boquete", 6, 27),
				new Temperatura("Chame", 17, 35)
				);
	}
	
	@GET
	@Path("/m1")
	public Temperatura medicion() {		// Por defecto produce 'application/json'
		return new Temperatura("Arraiján", 16, 36);
	}
	
	@GET
	@Path("/m2")
	@Produces(MediaType.APPLICATION_JSON) // MediaType.APPLICATION_JSON invoca la constante 'application/json' 
	public Temperatura medicion2() {
		return new Temperatura("La Chorrera", 14, 37);
	}
}
