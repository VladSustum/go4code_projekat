package restoran.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restoran.dto.MenuDTO;
import restoran.dto.MenuPageDTO;
import restoran.model.Category;
import restoran.model.Menu;
import restoran.service.MenuService;
@CrossOrigin("*")
@RestController
public class MenuController {
	
	@Autowired
	MenuService menuS;
	
	
	@RequestMapping(value="api/menus", method=RequestMethod.GET, params= {"page", "size"})
	public ResponseEntity<MenuPageDTO> getAll(Pageable pageable){
		Page<Menu> menus = menuS.findAll(pageable);
		
		MenuPageDTO menuDTO =  new MenuPageDTO(dtoFromMenu(menus.getContent()), menus.isLast());
		
		return new ResponseEntity<>(menuDTO,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="api/menus", method=RequestMethod.GET)
		public ResponseEntity<List<MenuDTO>> getAll(@RequestParam(required = false, defaultValue = "") String name){
		if(name.isEmpty()) {
			List<Menu> menus = menuS.findAll();
			ArrayList<MenuDTO> dtos = new ArrayList<>();
			for(Menu m : menus) {
				dtos.add(new MenuDTO(m));
			}
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		}
		List<Menu> menu = menuS.findByName(name);
		if(menu == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(dtoFromMenu(menu), HttpStatus.OK);
	}
	
	@RequestMapping(value="api/menus/{id}", method=RequestMethod.GET)
	public ResponseEntity<MenuDTO> getOne(@PathVariable Long id){
		Optional<Menu> menu = menuS.findOne(id);
		
		if(!menu.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		MenuDTO menuDto = new MenuDTO(menu.get());
		return new ResponseEntity<>(menuDto,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/menus" ,method=RequestMethod.POST)
	public ResponseEntity<MenuDTO> create(@RequestBody MenuDTO menuDTO){
		
		Menu menu = new Menu();
		menu.setId(menuDTO.getId());
		menu.setName(menuDTO.getName());
		menu.setPrice(menuDTO.getPrice());
		menu.setCategory(new Category(menuDTO.getCategory().getId(), null));
		
		Menu saved = menuS.save(menu);
		
		return new ResponseEntity<>(new MenuDTO(saved), HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="api/menus/{id}", method=RequestMethod.PUT)
	public ResponseEntity<MenuDTO> update(@PathVariable Long id, @RequestBody MenuDTO menuDTO){
		
		Optional<Menu> menuOp = menuS.findOne(id);
		
		if(!menuOp.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Menu menu = menuOp.get();
		menu.setId(id);
		menu.setName(menuDTO.getName());
		menu.setPrice(menuDTO.getPrice());
		menu.setCategory(new Category(menuDTO.getCategory().getId(), null));
		
		 Menu saveMenu = menuS.save(menu);
		
		return new ResponseEntity<>(new MenuDTO(saveMenu), HttpStatus.CREATED);
		
	}
	@RequestMapping(value="api/menus/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Optional<Menu> toDelete = menuS.findOne(id);
		
		if(!toDelete.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		menuS.delete(toDelete.get());
		
		return new ResponseEntity<>(HttpStatus.OK);
		
		
	}
	
	
	
	  private List<MenuDTO> dtoFromMenu(List<Menu> menus) {
	    	ArrayList<MenuDTO> dtos = new ArrayList<>();
	        for (Menu menu: menus) {
	        	dtos.add(new MenuDTO(menu));
	        }
	        
	        return dtos;
	    }
	
	
	

}
