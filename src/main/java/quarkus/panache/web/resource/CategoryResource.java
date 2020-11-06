package quarkus.panache.web.resource;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import quarkus.panache.entity.Category;
import quarkus.panache.repository.CategoryRepository;
import quarkus.panache.service.CategoryService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    private final CategoryRepository categoryRepository;

    private final CategoryService categoryService;

    public CategoryResource(CategoryRepository categoryRepository, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @GET
    public List<Category> findAll() {
        return categoryRepository.listAll();
    }

    @GET
    @Path("/page/{page}/size/{size}")
    public List<Category> findPage(@PathParam int page, @PathParam int size) {
        PanacheQuery<Category> categoriaPanacheQuery = categoryRepository.findAll();
        return categoriaPanacheQuery.page(Page.of(page, size)).list();
    }

    @GET
    @Path("/name/{name}")
    public List<Category> findByNome(@PathParam String name) {
        return categoryRepository.findByNameLike(name);
    }

    @POST
    @Transactional
    public Category save(Category categoria) {
        categoryService.save(categoria);
        return categoria;

    }
}

