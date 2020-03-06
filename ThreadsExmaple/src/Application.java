public class Application {

	public static void main(String[] args) {

		/*
		 * Грубо говоря, вся программа это создание хлеба Provider'ом
		 * и покупка и употребление хлеба Consumer'ом.
		 * После запуска программа будет работать до принудительной
		 * остановки консоли (Terminate)
		 */

		BreadProvider provider = new BreadProvider();
		BreadConsumer consumerA = new BreadConsumer("John", provider);
		BreadConsumer consumerB = new BreadConsumer("Marry", provider);

		// Запускаем потоки
		provider.start();
		consumerA.start();
		consumerB.start();

	}

}