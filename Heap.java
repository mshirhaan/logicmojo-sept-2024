import java.util.ArrayList;
import java.util.List;

class Task {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}

public class MinHeap {
    List<Task> tasks = new ArrayList<>();

    public void insert(String name, int priority) {
        Task task = new Task(name, priority);
        tasks.add(task);
        bubbleUp(tasks.size() - 1);
    }

    public void bubbleUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (parentIndex >= 0 && tasks.get(index).priority < tasks.get(parentIndex).priority) {
            Task temp = tasks.get(index);
            tasks.set(index, tasks.get(parentIndex));
            tasks.set(parentIndex, temp);
            bubbleUp(parentIndex);
        }
    }

    public Task extractMin() {
        Task min = tasks.get(0);
        tasks.set(0, tasks.get(tasks.size() - 1));
        tasks.remove(tasks.size() - 1);
        bubbleDown(0);
        return min;
    }

    public void bubbleDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int minIndex = index;
        if (leftChildIndex < tasks.size() && tasks.get(leftChildIndex).priority < tasks.get(minIndex).priority) {
            minIndex = leftChildIndex;
        }
        if (rightChildIndex < tasks.size() && tasks.get(rightChildIndex).priority < tasks.get(minIndex).priority) {
            minIndex = rightChildIndex;
        }
        if (minIndex != index) {
            Task temp = tasks.get(index);
            tasks.set(index, tasks.get(minIndex));
            tasks.set(minIndex, temp);
            bubbleDown(minIndex);
        }
    }

}
