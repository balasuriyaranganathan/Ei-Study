package com.spaceapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<AstroSchedule> taskList = new ArrayList<>();
        Taskslist tasksManager = new Taskslist(taskList);

        while (true) {
            System.out.println("\nAstro Task Scheduler");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks by Priority Level");
            System.out.println("4. View Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add a new task
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    
                    System.out.print("Enter start time (HH:MM): ");
                    String startTime = scanner.nextLine();
                    
                    System.out.print("Enter end time (HH:MM): ");
                    String endTime = scanner.nextLine();
                    
                    System.out.print("Enter priority level (High, Medium, Low): ");
                    String priorityLevel = scanner.nextLine();

                    try {
                        AstroSchedule newTask = new AstroSchedule(description, startTime, endTime, priorityLevel);
                        tasksManager.addTask(newTask);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter task description to remove: ");
                    String taskToRemove = scanner.nextLine();

                    AstroSchedule task = taskList.stream()
                        .filter(t -> t.getDescription().equals(taskToRemove))
                        .findFirst()
                        .orElse(null);

                    if (task != null) {
                        tasksManager.removeTask(task);
                    } else {
                        System.out.println("Task not found!");
                    }
                    break;

                case 3:
                    // View tasks by priority level
                    System.out.print("View Tasks By priority levels");
                    tasksManager.viewTask();
                    break;
                
                case 4:
                    // view task
                    tasksManager.viewTask();

                case 5:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
