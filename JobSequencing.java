import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Job {
    int id;     
    int deadline; 
    int profit; 

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    public static void jobSequencing(Job[] jobs, int n) {
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j2.profit - j1.profit; 
            }
        });

        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        int[] result = new int[maxDeadline];
        Arrays.fill(result, -1);

        int totalProfit = 0;

        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
                if (result[j] == -1) {
                    result[j] = job.id;  
                    totalProfit += job.profit;  
                    break;
                }
            }
        }

        System.out.println("Job sequence for maximum profit:");
        for (int i = 0; i < result.length; i++) {
            if (result[i] != -1) {
                System.out.print("Job " + result[i] + " ");
            }
        }
        System.out.println("\nTotal profit: " + totalProfit);
    }

    public static Job[] inputJobs(Scanner sc, int n) {
        Job[] jobs = new Job[n];
        System.out.println("Enter job ID, deadline, and profit for each job:");
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }
        return jobs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of jobs: ");
        int n = sc.nextInt();

        Job[] jobs = inputJobs(sc, n);

        jobSequencing(jobs, n);

        sc.close();
    }
}