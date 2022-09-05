package com.company;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    public static void main(String args[]) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        /* schedule(ClassName::anyTask, delayInSeconds, TimeUnit.SECONDS)
           where anyTask() is the name of the method we want to execute and
           ClassName is the class containing the anyTask() method */

        System.out.println("test run gap");
        service.schedule(ScheduledExecutor::executeTask, 0, TimeUnit.SECONDS);
        service.schedule(ScheduledExecutor::executeTask, 15, TimeUnit.SECONDS);
        service.shutdown();
    }
    public static void executeTask(){
        System.out.println(" Task is running after 5 seconds");
    }
}
