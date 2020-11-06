package quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import quarkus.panache.entity.Product;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

}
