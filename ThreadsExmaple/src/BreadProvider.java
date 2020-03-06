import java.util.ArrayList;

public class BreadProvider extends Thread {
	// ArrayList необходим, чтобы хранить в нём до 10 значений
	private ArrayList<Bread> breads; // storage can hold up to 10 breads
	private Integer breads_sold; // how many bread were sold
	private Integer bread_id;

	// Конструктор без параметров, который изначально присваивает количеству
	// проданного хлеба и айди хлеба ноль
	public BreadProvider() {
		super();
		breads = new ArrayList<>();
		this.breads_sold = 0;
		this.bread_id = 0;
	}

	// переопределеяем метод из класса Thread
	@Override
	public void run() {
		// Пока хранилище хлеба не переполнено до 10 - создаем новый хлеб
		// В совокупности с классом BreadConsumer данный цикл будет работать вечно
		while (true) {
			if (breads.size() < 10) {
				produceOneBread();
			}
			// данный try делает задержку при выводе в консоль в 0,1 секунду
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Данный метод private для того, чтобы ТОЛЬКО Provider мог создавать новый хлеб
	 * Делается это для того, чтобы какой-нибудь недоброжелательный Consumer не смог
	 * испечь сам хлеб ( чтобы не узнал секреты фабрики :) )
	 */
	private void produceOneBread() {
		// Создаем экземпляр класса Bread с параметрами White, а также bread_id,
		// который каждый раз при вывозве метода будет увеличиваться на единицу
		Bread fresh_bread = new Bread("White", ++bread_id);
		// Для красоты выводим как фабрика хлеба печет новый хлеб
		// this вызывает метод toString (ведь да?)
		System.out.println(this + " PRODUCING > " + fresh_bread);
		// Добавляем в массив свежеиспеченный белый хлеб с увеличенным на единицу айди
		breads.add(fresh_bread);
	}

	/*
	 * Метод "продает" хлеб. Пока хранилище хлеба (breads) не пустое происходит
	 * наращивание на единицу количество проданного хлеба (bread_sold) А также если
	 * хлеб был продан, то освобождаем первый элемент хранилища (массива) Если
	 * массив не содержит элемент, то возвращать нечего
	 */
	public Bread sellOneBread() {
		if (breads.size() > 0) {
			breads_sold++;
			return breads.remove(0); // sell starting with the oldest
		} else {
			return null; // nothing to sell yet
		}
	}

	@Override
	public String toString() {
		return "BreadProvider (sold: " + breads_sold + " left: " + breads.size() + ")";
	}

}