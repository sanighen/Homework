package entities;

public class Category {

	private long id;
	private String name;
	private long parent_category_id;

	public Category(long id, String name, long parent_category_id) {
		this.id = id;
		this.name = name;
		this.parent_category_id = parent_category_id;
	}

	public Category() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getParent_category_id() {
		return parent_category_id;
	}

	public void setParent_category_id(long parent_category_id) {
		this.parent_category_id = parent_category_id;
	}

	@Override
	public String toString() {
		return "CategoryRepository [id=" + id + ", name=" + name + ", parent_category_id=" + parent_category_id + "]";
	}

}
