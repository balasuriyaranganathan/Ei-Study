package com.spaceapp;

import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Taskslist {
    private List<AstroSchedule> task;

    public Taskslist(List<AstroSchedule> task) {
        this.task = task;
    }

    public void addTask(AstroSchedule newtask) {
        // check if task with same name already exists that gives just warning if time does not conflict
        throwSameNameWarning(newtask, this.task);
        // check if there is any time conflict with respect to other tasks (if any) break and throw error
        if (checkTaskConflict(this.task, newtask) == 1) {
            throw new IllegalArgumentException("Time conflict with other tasks");
        }
        else{
            this.task.add(newtask);
            System.out.println("Task added successfully");
        }
    }

    public void removeTask(AstroSchedule task) {
        // a nice easter egg lol !!
        if (task.getDone() == 1) {
            this.task.remove(task);
            System.out.println("Congrats! You have completed the task " + task.getDescription());
        } else {
            if (task.getDone() == 0) {
                System.out.println("Do you want to mark it as done? (Y/N)");
                try (Scanner sc = new Scanner(System.in)) {
                    String choice = sc.nextLine();
                    if (choice == "Y" || choice == "y") {
                        System.out.println("Removing the task " + task.getDescription()+" do the task next time atleast!");
                        this.task.remove(task);
                    } else {
                        System.out.println("Good .. keep it up!! you can do the taskk!!");
                    }
                }
            }
        }
    }

    public void viewTask(){
        // Filter and sort tasks by start time
        List<AstroSchedule> filteredAndSortedTasks = this.task.stream()
            .sorted(Comparator.comparingInt(t -> t.getTimeSlot()[0][0])) // Sort by start time in minutes
            .collect(Collectors.toList());

        // Print sorted tasks
        for (AstroSchedule t : filteredAndSortedTasks) {
            System.out.println("Task: " + t.getDescription() + 
                               ", Start Time: " + t.getStartTime() + 
                               ", End Time: " + t.getEndTime() + 
                               ", Priority: " + t.getPriorityLevel());
        }
    }

    // extra thing asked in code ig
    public void viewTaskByPriorityLevel(String prioritylevel) {
        // Filter and sort tasks by start time
        List<AstroSchedule> filteredAndSortedTasks = this.task.stream()
            .filter(t -> t.getPriorityLevel().equals(prioritylevel)) // Filter by priority level
            .sorted(Comparator.comparingInt(t -> t.getTimeSlot()[0][0])) // Sort by start time in minutes
            .collect(Collectors.toList());

        // Print sorted tasks
        for (AstroSchedule t : filteredAndSortedTasks) {
            System.out.println("Task: " + t.getDescription() + 
                               ", Start Time: " + t.getStartTime() + 
                               ", End Time: " + t.getEndTime() + 
                               ", Priority: " + t.getPriorityLevel());
        }
    }

    // method says user that a task name with this name exist or if same task is given then it will throw error
    private void throwSameNameWarning(AstroSchedule task, List<AstroSchedule> tasks) {
        if (tasks.stream().anyMatch(t -> t.getDescription().equals(task.getDescription()))) {
            System.out.println("Task with same name already exists");
        }
    }

    // private method because no use outside the class
    private static int checkTaskConflict(List<AstroSchedule> tasks, AstroSchedule newtask){
        // check if there is any time conflict with respect to other tasks (if any) break and throw error
        if (tasks.stream().anyMatch(t -> t.getTimeSlot()[0][0] <= newtask.getTimeSlot()[0][0] && t.getTimeSlot()[0][1] >= newtask.getTimeSlot()[0][0])) {
            return 1;
        }
        else{
            return 0;
        }
    }
}
