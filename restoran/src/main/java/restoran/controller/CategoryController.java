package restoran.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import restoran.dto.CategoryDTO;
import restoran.model.Category;
import restoran.service.CategoryService;
@CrossOrigin("*")
@RestController
public class CategoryController {
	
	
	@Autowired
	CategoryService cS;
	
	
	
	@RequestMapping(value="api/categories", method=RequestMethod.GET)
	public ResponseEntity<List<CategoryDTO>> getAll(){
		
		List<Category> categories = cS.findAll();
		
		List<CategoryDTO> cateDtos = new ArrayList<>();
		
		
		for(Category c : categories) {
			cateDtos.add(new CategoryDTO(c));
		}
		return new ResponseEntity<>(cateDtos, HttpStatus.OK);
	}
	
	@RequestMapping(value="api/categories/{id}", method=RequestMethod.GET)
	public ResponseEntity<CategoryDTO> getOne(@PathVariable Long id){
		Optional<Category> category = cS.findOne(id);
		
		if(!category.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new CategoryDTO(category.get()), HttpStatus.OK);
	}
	
	@RequestMapping(value="api/categories", method=RequestMethod.POST)
	public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO cateDTO){
		Category cate = new Category();
		
		cate.setId(cateDTO.getId());
		cate.setName(cateDTO.getName());
		
		Category toSave = cS.save(cate);
		
		return new ResponseEntity<>(new CategoryDTO(toSave), HttpStatus.CREATED);
	}

}
