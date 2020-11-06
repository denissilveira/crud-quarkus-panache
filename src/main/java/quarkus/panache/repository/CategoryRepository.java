package quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import quarkus.panache.entity.Category;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {

    public List<Category> findByNameLike(String name){
        return find("UPPER(name) LIKE CONCAT('%',:name,'%')", Parameters.with("name", name.toUpperCase())).list();
    }
}
