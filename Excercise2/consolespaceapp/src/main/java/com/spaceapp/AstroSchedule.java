package com.spaceapp;

import java.util.UUID;

public class AstroSchedule {
    private String Id, description, startTime, endTime, prioritylevel;
    private int done;
    private int[][] timeSlot;

    // Constructor without 'Id' as a parameter
    public AstroSchedule(String description, String startTime, String endTime, String prioritylevel) {
        this.Id = setId();
        this.description = setDescription(description);
        this.startTime = startTime; // Directly assign first
        this.endTime = endTime;     // Directly assign first
        this.startTime = setStartTime(startTime);  // Now validate and set properly
        this.endTime = setEndTime(endTime);        // Now validate and set properly
        this.prioritylevel = setprioritylevel(prioritylevel);
        this.timeSlot = setTimeSlot(startTime, endTime);
        this.done = setDone(0); // 0 means task is not done
    }

    // This sets the timeSlot based on startTime and endTime
    public int[][] setTimeSlot(String startTime, String endTime) {
        int startTime_hrs = Integer.parseInt(startTime.substring(0, 2));
        int startTime_min = Integer.parseInt(startTime.substring(3, 5));

        int endTime_hrs = Integer.parseInt(endTime.substring(0, 2));
        int endTime_min = Integer.parseInt(endTime.substring(3, 5));

        return new int[][]{{startTime_hrs * 60 + startTime_min, endTime_hrs * 60 + endTime_min}};
    }

    public int[][] getTimeSlot() {
        return timeSlot;
    }

    // Automatically generating a UUID for each task
    public String setId() {
        this.Id = UUID.randomUUID().toString();
        return this.Id;
    }

    public String getId() {
        return Id;
    }

    // Setting the description
    public String setDescription(String description) {
        this.description = description;
        return this.description;
    }

    // Getting the description (standard getter)
    public String getDescription() {
        return description;
    }

    public String setStartTime(String startTime) {
        int starthrs = Integer.parseInt(startTime.substring(0, 2));
        int startmin = Integer.parseInt(startTime.substring(3, 5));
        if (starthrs < 0 || starthrs > 23 || startmin < 0 || startmin > 59 || startTime.charAt(2) != ':') {
            throw new IllegalArgumentException("Invalid time format for start time");
        }
        return startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String setEndTime(String endTime) {
        int endhrs = Integer.parseInt(endTime.substring(0, 2));
        int endmin = Integer.parseInt(endTime.substring(3, 5));
        if (endhrs < 0 || endhrs > 23 || endmin < 0 || endmin > 59 || endTime.charAt(2) != ':') {
            throw new IllegalArgumentException("Invalid time format for end time");
        }
        return endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    // Setting priority level of the task (High, Medium, Low)
    public String setprioritylevel(String prioritylevel) {
        if (!prioritylevel.equals("High") && !prioritylevel.equals("Medium") && !prioritylevel.equals("Low")) {
            throw new IllegalArgumentException("Invalid priority level. Choose only from High, Medium, Low.");
        }
        this.prioritylevel = prioritylevel;
        return this.prioritylevel;
    }

    public String getPriorityLevel() {
        return prioritylevel;
    }

    // Setting the done status
    public int setDone(int done) {
        if (done != 0 && done != 1) {
            throw new IllegalArgumentException("Invalid value for done. Choose only from 0 (not done) or 1 (done).");
        }
        this.done = done;
        return this.done;
    }

    public int getDone() {
        return done;
    }
}