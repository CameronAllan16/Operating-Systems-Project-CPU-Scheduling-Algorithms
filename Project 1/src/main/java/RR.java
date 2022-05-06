/**
 * RR (Round Robin) scheduling algorithm.
 *
 */
 
import java.util.*;

public class RR implements Algorithm
{

    private final Queue<Process> readyQueue;

    private final Queue<Process> processesToSchedule;

    private final int totalNumProcesses;

    public RR(List<Process> allProcessList) {
        readyQueue = new LinkedList<>();
        processesToSchedule = new LinkedList<>();
        totalNumProcesses = allProcessList.size();
        for(Process p: allProcessList){
            processesToSchedule.add(p);
        }
    }

    public void schedule(){
        System.out.println("Round-Robin Scheduling \n");

        int totalWaitingTime = 0;

        Process currentProcess;
        /**
         * add first process
         */
        Process p = processesToSchedule.remove();
        if (CPU.getCurrentTime() < p.getArrivalTime()) {
            CPU.advanceTimeTo(p.getArrivalTime());
        }
        readyQueue.add(p);

        while (!readyQueue.isEmpty()) {

        }

    }
}

