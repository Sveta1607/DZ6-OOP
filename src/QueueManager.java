import java.util.LinkedList;
import java.util.Queue;

public class QueueManager implements QueueBehaviour {
    private Queue<Person> queue;

    public QueueManager() {
        this.queue = new LinkedList<>();
    }

    @Override
    public void addToQueue(Person person) {
        queue.add(person);
        System.out.println(person.getName() + " добавлен в очередь.");
    }

    @Override
    public void removeFromQueue() {
        Person person = queue.poll();
        if (person != null) {
            System.out.println(person.getName() + " удален из очереди.");
        }
    }

    @Override
    public Person nextInQueue() {
        return queue.peek();
    }

    @Override
    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }
}