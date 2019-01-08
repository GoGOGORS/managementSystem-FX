package application.main;

public class Vitamin {

	private String id;
	private String name;
	private String price;
	private String weight;
	private String component;
	private String source;
	private String apply;
	private String type;
	private String praise;
	private String commonly;
	private String negative;
	
	public String getId() {
		return id;
	}
	public void setId(int id) {
		this.id = String.valueOf(id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getApply() {
		return apply;
	}
	public void setApply(String apply) {
		this.apply = apply;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPraise() {
		return praise;
	}
	public void setPraise(String praise) {
		this.praise = praise;
	}
	public String getCommonly() {
		return commonly;
	}
	public void setCommonly(String commonly) {
		this.commonly = commonly;
	}
	public String getNegative() {
		return negative;
	}
	public void setNegative(String negative) {
		this.negative = negative;
	}
	
	@Override
	public String toString() {
		return "DaVitamin [id=" + id + ", name=" + name + ", price=" + price + ", weight=" + weight + ", component="
				+ component + ", source=" + source + ", apply=" + apply + ", type=" + type + ", praise=" + praise
				+ ", commonly=" + commonly + ", negative=" + negative + "]";
	}
	
	
}
