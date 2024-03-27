package quarkus;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/magazine")
@Transactional
public class MagazineResource {

    @GET
    public List<Magazine> index() {
        return Magazine.listAll();
    }

    @POST
    public Magazine insert(Magazine insertedMagazine) {
        insertedMagazine.persist();
        return insertedMagazine;
    }
}
