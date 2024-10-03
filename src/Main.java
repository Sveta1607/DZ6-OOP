public class Main {
    public static void main(String[] args) {
        // Создаем менеджера очереди
        QueueBehaviour queueManager = new QueueManager();

        // Создаем магазин с менеджером очереди
        Market market = new Market(queueManager);

        // Создаем несколько человек
        Person person1 = new Person("Мария");
        Person person2 = new Person("Евгений");
        Person person3 = new Person("Денис");

        // Люди заходят в магазин
        market.enterMarket(person1);
        market.enterMarket(person2);
        market.enterMarket(person3);

        // Обновляем состояние магазина (обрабатываем очередь)
        market.update();  // Обрабатывает первый заказ
        market.update();  // Обрабатывает второй заказ
        market.update();  // Обрабатывает третий заказ
        market.update();  // Очередь пуста
    }
}