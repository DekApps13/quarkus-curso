package quarkus;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

// Puedes poner @Transactional a nivel de clase para indicar a Quarkus que todos los métodos de esta clase hacen
// consultas a la DDBB.
// O también, si existen consultas simultáneas en la DDBB, poder asugurar que no haya Inconsistencias.
@Transactional
@Path("/books")
public class BookResource {

    @Inject
    private BookRepository repo;

    @GET
    public List<Book> index() {
        return repo.listAll();
    }

    // Puedes poner @Transactional a nivel de Endpoint para aislar el Endpoint que hace consultas a la DDBB.
    @POST
    public Book insert(Book insertedBook) {
        repo.persist(insertedBook);
        return insertedBook;
    }

}
