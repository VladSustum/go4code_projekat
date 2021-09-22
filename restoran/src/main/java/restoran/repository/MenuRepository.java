package restoran.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restoran.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
	
	



	

	public List<Menu> findByNameContains(String name);

}
