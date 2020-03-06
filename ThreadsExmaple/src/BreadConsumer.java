public class BreadConsumer extends Thread {

	private String name;
	private Integer total_breads; // how many bread was consumed
	private Bread bread_reserve; // has only one bread as reserve
	private BreadProvider provider;

	/*
	 * Обычный конструктор, у которого в качестве параметра имя покупателя и
	 * название фабрики (экземпляр класса BreadProvider), а также изначально
	 * покупателю присвоено ноль к значению количества съеденного хлеба
	 */
	public BreadConsumer(String name, BreadProvider provider) {
		super();
		this.name = name;
		this.provider = provider;
		this.total_breads = 0;
	}

	/*
	 * Метод делает так, чтобы у каждого консюмера был в "запасе" хотя бы один хлеб,
	 * но не более одного. Если у консюмера есть хлеб, то сразу его "съедает" (обнуляет запас хлеба)
	 * Если у консюмера нет хлеба - метод ничего не делает
	 * this вызывает метод toString
	 */
	public void consumeOneBread() {
		if (bread_reserve != null) {
			total_breads++;
			System.out.println(this + " CONSUMING < " + bread_reserve);
			bread_reserve = null;
		}
	}

	/*
	 * Создается экземпляр класса Bread, которому присваивается другой экземпляр
	 * класса BreadProvider, из которого вызывается метод sellOneBread()
	 * 
	 * SOS! HELP! дальше не могу понять что делает метод и что делает этот код 
	 * Bread fresh_bread = provider.sellOneBread();
	 */
	public void buyOneBread() {
		Bread fresh_bread = provider.sellOneBread();
		if (fresh_bread != null) {
			System.out.println(this + " BUYING < " + fresh_bread);
			bread_reserve = fresh_bread;
		}
	}

	/*
	 * Переопределение метода из класса Thread Метод циклически проверяет есть ли у
	 * консюмера в "запасе" хотя бы один хлеб Если нет, то вызывается метод покупки
	 * хлеба, после чего консюмер съедает его
	 */
	@Override
	public void run() {
		while (true) {
			if (bread_reserve == null) { // if there is no bread
				buyOneBread();
			}
			consumeOneBread();
			// Задержка вывода в консоль на 0,5 секунд
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "           BreadConsumer (total: " + total_breads + ") [name=" + name + "]";
	}

}