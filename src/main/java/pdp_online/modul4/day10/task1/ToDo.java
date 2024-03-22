package pdp_online.modul4.day10.task1;

import java.time.LocalDate;
import java.time.LocalTime;

public class ToDo {
    private String task;
    private LocalDate date;
    private LocalTime time;

    public ToDo() {
    }

    public ToDo(String task, LocalDate date, LocalTime time) {
        this.task = task;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "%s \n assigned for ->  %tF %tT \n".formatted(task, date, time);
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
