package restoran.dto;

import restoran.model.Menu;

public class MenuDTO {
	
	private Long id;
	
	private String name;
	
	private CategoryDTO category;
	
	private double price;
	
	
	
	public MenuDTO() {
		
	}
	
	


	public MenuDTO(Long id, String name, CategoryDTO category, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	public MenuDTO(Menu menu) {
		this.id = menu.getId();
		this.name= menu.getName();
		this.price= menu.getPrice();
		this.category= new CategoryDTO(menu.getCategory());
	}




	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public CategoryDTO getCategory() {
		return category;
	}



	public void setCategory(CategoryDTO category) {
		this.category = category;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}




	@Override
	public String toString() {
		return "MenuDTO [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
	}
	
	
	
	
}
