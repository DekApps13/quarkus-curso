package quarkus;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/temperaturas")
public class TemperaturasResource {

	private TemperaturasService temperaturas;

	@Inject
	public TemperaturasResource(TemperaturasService temperaturas) {
		this.temperaturas = temperaturas;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Temperatura nueva(Temperatura temp) {
		temperaturas.addTemperatura(temp);
		return temp;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Temperatura> list() {	// Quarkus detecta que estamos devolviendo una Lista y automáticamente lo transforma a un Array de Json
		return temperaturas.obtenerTemperaturas();
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

	@GET
	@Path("/maxima")
	@Produces(MediaType.TEXT_PLAIN)
	public String maxima() {
		return Integer.toString(temperaturas.maxima());
	}
}
