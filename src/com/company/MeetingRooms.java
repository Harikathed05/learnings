package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MeetingRooms {

    private HashMap<String, Integer> roomsSchedule = new HashMap<>();
    private void minimumRooms(int minTime, int maxTime) {
        Iterator roomsIterator = roomsSchedule.entrySet().iterator();
        while (roomsIterator.hasNext()) {
            Map.Entry roomSch =  (Map.Entry) roomsIterator.next();
            if (checkTimeConflicts(roomSch.getKey().toString(), minTime, maxTime)) {
                roomsSchedule.replace(roomSch.getKey().toString(), Integer.parseInt(roomSch.getValue().toString()) + 1);
            } else {
                roomsSchedule.put(String.format(minTime + "_" + maxTime), 1);
                break;
            }
        }
    }

    private boolean checkTimeConflicts(String timeRange, int min, int max) {
        int [] startAndEnd = Arrays.stream(timeRange.split("_")).mapToInt(Integer::parseInt).toArray();
            if ((startAndEnd[1] > min) && (startAndEnd[0] < min) && (startAndEnd[0] < max) && (startAndEnd[1] > max)) {
                    System.out.println("startAndEnd[1] " + startAndEnd[1] + " min " + min);
                    System.out.println("roomsSchedule.get(timeRange) " + roomsSchedule.get(timeRange) + " timeRange " + timeRange);
                    return true;
                }
        return false;
    }

    public static void main(String[] args) {
        MeetingRooms meetingRooms = new MeetingRooms();
        int minRooms = 0;
        int [][] a = {  {1, 18},
                {18, 23},
                {15, 29},
                {4, 15},
                {2, 11},
                {5, 13} };
      //  System.out.println("a[0][0] " +a[0][0] + " " + "a[0][1] " + a[0][1] );
        //Arrays.sort(a);
        meetingRooms.roomsSchedule.put(String.format(a[0][0] + "_" + a[0][1]), 1);
        for(int i = 1; i < a.length; i++) {
            System.out.println("a[i][0] " +a[i][0] + " " + "a[i][1] " + a[i][1] );
                meetingRooms.minimumRooms(a[i][0], a[i][1]);
        }
       for(int c : meetingRooms.roomsSchedule.values()) {
           if(minRooms < c) {
               minRooms = c;
           }
       }
       System.out.println("The min rooms " + minRooms);
    }
}
