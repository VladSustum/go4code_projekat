package restoran.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Menu {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@ManyToOne(fetch=FetchType.EAGER)
	private Category category;
	@Column
	private double price;
	
	public Menu() {
		
	}
	
	
	public Menu(Long id, String name, Category category, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	




	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
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
	

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
	

}
