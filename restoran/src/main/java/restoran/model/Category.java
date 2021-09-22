package restoran.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@OneToMany(mappedBy="category", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Menu> menus;
	
	
	public Category() {
		
	}
	
	
	
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}



	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", menus=" + menus + "]";
	}
	
	
	
	
	

}
