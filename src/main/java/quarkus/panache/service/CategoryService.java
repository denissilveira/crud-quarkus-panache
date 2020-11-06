package quarkus.panache.service;

import quarkus.panache.entity.Category;
import quarkus.panache.repository.CategoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;

@ApplicationScoped
public class CategoryService {

    @Inject
    CategoryRepository categoryRepository;

    public void save(@Valid Category category) {
        categoryRepository.persist(category);
    }

}
