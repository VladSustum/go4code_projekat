package restoran.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import restoran.model.Menu;
import restoran.repository.MenuRepository;

@Component
public class MenuService {
	
	
	@Autowired
	MenuRepository mR;
	
	
	public List<Menu> findAll(){
		return mR.findAll();
	}
	
	public Page<Menu> findAll(Pageable page){
		return mR.findAll(page);
	}
	
	public Optional<Menu> findOne(Long id){
		return mR.findById(id);
	}
	
	public Menu save(Menu menu) {
		return mR.save(menu);
	}
	
	
	public void delete(Menu menu) {
		mR.delete(menu);
	}
	
	public List<Menu> findByName(String name) {
		return mR.findByNameContains(name);
	}

}
