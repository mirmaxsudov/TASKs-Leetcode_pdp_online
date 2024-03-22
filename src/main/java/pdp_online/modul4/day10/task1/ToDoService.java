package pdp_online.modul4.day10.task1;

import java.time.LocalDate;
import java.time.LocalTime;


public class ToDoService {

    public void save(ToDo toDo) {
        Database.todoList.add(toDo);
    }

    public void getToDoList() {
        if (!Database.todoList.isEmpty())
            for (int i = 0; i < Database.todoList.size(); i++) {
                System.out.println((i + 1) + ". " + Database.todoList.get(i));
            }
    }

    public void delete(int i) {
        if (i < 1 || i >= Database.todoList.size()) {
            System.out.println("Please choose correct number of todo");
            return;
        }
        Database.todoList.remove(i - 1);
    }

    public void update(String task, int i) {
        Database.todoList.get(i - 1).setTask(task);
    }

    public void update(LocalTime time, int i) {
        Database.todoList.get(i - 1).setTime(time);
    }

    public void update(LocalDate date, int i) {
        Database.todoList.get(i - 1).setDate(date);
    }

    public void update(ToDo toDo, int i) {
        delete(i);
        save(toDo);
    }
}
