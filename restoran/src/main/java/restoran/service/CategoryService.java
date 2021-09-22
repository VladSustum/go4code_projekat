package restoran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import restoran.model.Category;
import restoran.repository.CategoryRepository;

@Component
public class CategoryService {
	
	
	@Autowired
	CategoryRepository cR;
	
	
	public List<Category> findAll(){
		return cR.findAll();
	}
	
	public Page<Category> findAll(Pageable page){
		return cR.findAll(page);
	}
	
	public Optional<Category> findOne(Long id){
		return cR.findById(id);
	}
	
	public Category save(Category category) {
		return cR.save(category);
	}
	
	

}
