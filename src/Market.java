public class Market implements MarketBehaviour {
    private QueueBehaviour queueManager;

    // Внедрение зависимости через конструктор для соблюдения принципа DIP
    public Market(QueueBehaviour queueManager) {
        this.queueManager = queueManager;
    }

    @Override
    public void enterMarket(Person person) {
        System.out.println(person.getName() + " вошел в магазин.");
        queueManager.addToQueue(person);  // Добавляем человека в очередь при входе в магазин
    }

    @Override
    public void leaveMarket(Person person) {
        System.out.println(person.getName() + " вышел из магазина.");
        queueManager.removeFromQueue();  // Удаляем человека из очереди при выходе из магазина
    }

    // Метод обновления состояния магазина
    public void update() {
        if (!queueManager.isQueueEmpty()) {
            Person person = queueManager.nextInQueue();
            System.out.println("Обработка заказа для: " + person.getName());
            leaveMarket(person);  // После обработки заказа человек уходит из магазина
        } else {
            System.out.println("Очередь пуста, нет заказов для обработки.");
        }
    }
}