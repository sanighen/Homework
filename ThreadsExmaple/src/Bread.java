import java.util.Random;

public class Bread {

	private String name;
	private Integer weight;
	private Integer id;

	/*
	 * конструктор, который в качестве параметров принимает название хлеба и его
	 * айди, а также присваивает весу случайное число от 400 до 450, чтобы хлеб
	 * всегда имел разное значение веса и не вписывать его вручную
	 */
	public Bread(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
		this.weight = new Random().nextInt(50) + 400;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Bread    (" + id + ")    [name=" + name + ", weight=" + weight + "g]";
	}
}