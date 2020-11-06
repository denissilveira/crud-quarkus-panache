package quarkus.panache.web.resource;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import quarkus.panache.entity.Product;
import quarkus.panache.repository.ProductRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductRepository productRepository;

    @GET
    public List<Product> findAll() {
        return productRepository.listAll();
    }

    @GET
    @Path("/page/{page}/size/{size}")
    public List<Product> findPage(@PathParam int page, @PathParam int size) {
        PanacheQuery<Product> produtoPanacheQuery = productRepository.findAll();
        return produtoPanacheQuery.page(Page.of(page, size)).list();
    }

    @POST
    @Transactional
    public Product save(@Valid Product product) {
        productRepository.persist(product);
        return product;

    }
}

