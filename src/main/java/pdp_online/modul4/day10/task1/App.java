package pdp_online.modul4.day10.task1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;


public class App {
    private static final ToDoService service = new ToDoService();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                LocalDate curDate = LocalDate.now();
                LocalTime curTime = LocalTime.now();
                for (ToDo todo : Database.todoList) {
                    if (curDate.getMonth() == todo.getDate().getMonth() &&
                            curDate.getDayOfMonth() == todo.getDate().getDayOfMonth() &&
                            curTime.getHour() == todo.getTime().getHour() &&
                            curTime.getMinute() == todo.getTime().getMinute()) {
                        System.err.println("Task due: " + todo);
                    } else {
                        System.out.println("wrong");
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        taskChecker();
        loop:
        while (true) {
            System.out.println("""
                    1) add task
                    2) show tasks
                    3) delete task
                    4) update task
                    5) exit""");
            int choice = Util.IN_INT.nextInt();
            switch (choice) {
                case 1 -> {
                    addTask();
                    System.out.println("added successfully");
                }
                case 2 -> {
                    service.getToDoList();
                    Util.IN_INT.nextLine();
                }
                case 3 -> {
                    service.getToDoList();
                    System.out.println("enter task number: ");
                    int number = Util.IN_INT.nextInt();
                    service.delete(number);
                    System.out.println("deleted");
                }
                case 4 -> {
                    System.out.println("""
                            1) update task's text
                            2) update task's date
                            3) update task's time""");
                    choice = Util.IN_INT.nextInt();
                    service.getToDoList();
                    updateBasedOnChoice(choice);
                }
                case 5 -> {
                    break loop;
                }
            }
        }
    }

    private static void updateBasedOnChoice(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println("enter task number: ");
                choice = Util.IN_INT.nextInt();
                System.out.println("enter task description: ");
                String description = Util.IN_STR.nextLine();
                service.update(description, choice);
            }
            case 2 -> {
                System.out.println("enter task number: ");
                choice = Util.IN_INT.nextInt();
                LocalDate localDateFromString = getLocalDateFromString();
                service.update(localDateFromString, choice);

            }
            case 3 -> {
                System.out.println("enter task number: ");
                choice = Util.IN_INT.nextInt();
                LocalTime localTimeFromString = getLocalTimeFromString();
                service.update(localTimeFromString, choice);
            }
            default -> {
                System.out.println("choose right 1, 2 or 3");
            }
        }
    }

    public static void addTask() {
        System.out.println("please enter task : ");
        String task = Util.IN_STR.nextLine();
        LocalDate localDate = getLocalDateFromString();

        LocalTime localTime = getLocalTimeFromString();

        ToDo newTodo = new ToDo();
        newTodo.setTask(task);
        newTodo.setDate(localDate);
        newTodo.setTime(localTime);
        service.save(newTodo);
    }

    private static LocalDate getLocalDateFromString() {
        System.out.println("Enter task end date int this format[dd/MM/yyyy] : ");
        String date = Util.IN_STR.nextLine();

        DateTimeFormatter[] formatters = {
                DateTimeFormatter.ofPattern("d/MM/yyyy"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy")
        };

        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDate.parse(date, formatter);
            } catch (Exception ignored) {
            }
        }
        throw new IllegalArgumentException("Invalid date format");
    }

    private static LocalTime getLocalTimeFromString() {
        System.out.println("please enter task end time in this format[hh:mm] in 24 hour format : ");
        String time = Util.IN_STR.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(time, formatter);
        return localTime;
    }

    public static void taskChecker() {
        CompletableFuture.runAsync(
                () -> {
                    while (true) {
                        LocalDate curDate = LocalDate.now();
                        LocalTime curTime = LocalTime.now();
                        for (ToDo todo : Database.todoList) {
                            if (curDate.getMonth().getValue() == todo.getDate().getMonth().getValue() &&
                                    curDate.getDayOfMonth() == todo.getDate().getDayOfMonth() &&
                                    curTime.getHour() == todo.getTime().getHour() &&
                                    curTime.getMinute() == todo.getTime().getMinute()) {
                                Logger logger = Logger.getLogger("todo");
                                String message = todo.toString();
                                logger.info(message);
                            }
                        }
                        try {
                            Thread.sleep(1000 * 60);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

    }
}
