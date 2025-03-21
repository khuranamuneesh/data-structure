public class TaskSchedulerCLL {
    public static void main(String[] args)
    {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask(1, "Task A", 2, "2024-03-25", null);
        scheduler.addTask(2, "Task B", 1, "2024-03-26", null);
        scheduler.addTask(3, "Task C", 3, "2024-03-27", 1);

        System.out.println("\nAll Tasks:");
        scheduler.displayTasks();

        System.out.println("\nCurrent Task:");
        scheduler.viewCurrentTask();

        System.out.println("\nMoving to Next Task:");
        scheduler.moveToNextTask();

        System.out.println("\nSearching for Priority 1 Tasks:");
        scheduler.searchTaskByPriority(1);

        System.out.println("\nRemoving Task 2:");
        scheduler.removeTask(2);

        System.out.println("\nAll Tasks After Removal:");
        scheduler.displayTasks();
    }
}
class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    public Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head;

    public void addTask(int id, String name, int priority, String dueDate, Integer position) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head; // Circular reference
            return;
        }
        if (position == null || position == 0) {  // Insert at beginning
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        } else {
            Task temp = head;
            int count = 0;
            while (temp.next != head && count < position - 1) {
                temp = temp.next;
                count++;
            }
            newTask.next = temp.next;
            temp.next = newTask;
        }
    }

    public void removeTask(int id) {
        if (head == null) return;
        Task temp = head, prev = null;
        do {
            if (temp.id == id) {
                if (prev != null) {
                    prev.next = temp.next;
                } else {
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                }
                System.out.println("Task removed: " + id);
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Task not found: " + id);
    }

    public void viewCurrentTask() {
        if (head != null) {
            System.out.println("Current Task - ID: " + head.id + ", Name: " + head.name + ", Priority: " + head.priority + ", Due Date: " + head.dueDate);
        } else {
            System.out.println("No tasks available.");
        }
    }

    public void moveToNextTask() {
        if (head != null) {
            head = head.next;
            viewCurrentTask();
        }
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTaskByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks found with priority: " + priority);
    }
}