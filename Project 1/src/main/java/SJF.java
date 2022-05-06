/**
 * Non-preemptive SJF (Shortest-Job First) scheduling algorithm.
 *
 */

import java.util.*;

public class SJF implements Algorithm
{
    private final Queue<Process> readyQueue;

    private final Queue<Process> processToSchedule;

    private final int totalNumProcesses;

    public SJF(List<Process> allProcessList){
        readyQueue = new LinkedList<>();
        processToSchedule = new LinkedList<>();
        totalNumProcesses = allProcessList.size();
        for (Process p: allProcessList){
            processToSchedule.add(p);
        }

    }
    public void schedule(){
        System.out.println("Shortest-Job-First-Non-Preemptive Version Scheduling \n");

        int totalWaitingTime = 0;

        Process currentProcess;

        Process p = processToSchedule.remove();
        if (CPU.getCurrentTime() < p.getArrivalTime()){
            CPU.advanceTimeTo(p.getArrivalTime());
        }
        readyQueue.add(p);

        while (!readyQueue.isEmpty()){
            currentProcess = pickNextProcess();

            int wTime = 0;
            if (CPU.getCurrentTime() > currentProcess.getArrivalTime()){
                wTime = CPU.getCurrentTime() - currentProcess.getArrivalTime();
            }

            totalWaitingTime += wTime;

            CPU.run(currentProcess, currentProcess.getCPUBurstTime());
        }
    }

}
