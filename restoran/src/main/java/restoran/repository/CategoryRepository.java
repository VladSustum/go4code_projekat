package restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restoran.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findOneById(Long id);

}
