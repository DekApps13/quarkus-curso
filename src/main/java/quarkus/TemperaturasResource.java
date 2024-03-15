package quarkus;

import java.util.List;
import java.util.NoSuchElementException;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
    public Response maxima() {
        if (temperaturas.isEmpty()) {
            return Response.status(404)
                    .entity("No hay temperaturas")
                    .build();
        } else {
            int temperaturaMax = temperaturas.maxima();
            return Response.ok(Integer.toString(temperaturaMax))
					.header("X-Institucion", "IMHPA")
                    .build();
        }
        /*return Response.status(404)
                .language("es-ES")
                .header("X-Response", "Hola")
                .entity(temperaturas)
                .build();

         */
    }

	@GET
	@Path("{ciudad}")
	@Produces(MediaType.APPLICATION_JSON)
	public Temperatura sacar(@PathParam("ciudad") String ciudad) {
		return temperaturas.sacarTemperatura(ciudad)
				.orElseThrow(() -> new NoSuchElementException("No hay registros para la ciudad: " + ciudad));
	}

    /*
    Forma por defecto donde Quarkus automáticamente serializa la respuesta para devolver un JSON o TEXT_PLAIN
    y donde no se puede cambiar el código de estado
	@GET
	@Path("/maxima")
	@Produces(MediaType.TEXT_PLAIN)
	public String maxima() {
		return Integer.toString(temperaturas.maxima());
	}
     */
}
