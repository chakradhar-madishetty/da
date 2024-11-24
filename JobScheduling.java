import java.util.*;
class JobScheduling
{   public static void jobscheduling(int deadlines[],int profits[],int jobs)
    {
		int i, j, maxProfit = 0;
        int jobSequence[] = new int[jobs];
        for (i = 0; i < jobs; i++) 
		{
            jobSequence[i] = -1;
        }
        for (i = 0; i < jobs; i++)
			{
            for (j = deadlines[i] - 1; j >= 0; j--) 
			{
                if (jobSequence[j] == -1) 
				{
                    jobSequence[j] = i;
                    maxProfit += profits[i];
                    break;
                }
            }
        }

        System.out.println("Following is the sequence of jobs:");
        for (i = 0; i < jobs; i++) 
		{
            if (jobSequence[i] != -1) 
			{
                System.out.print(jobSequence[i] + " ");
            }
        }
        System.out.println("\nMaximum profit is " + maxProfit);
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no of Jobs: ");
		int jobs=sc.nextInt();
		int temp;
		int profits[]=new int[jobs];
		int deadlines[]=new int[jobs];
		
		System.out.println("Enter profits of "+jobs+" jobs");
		for(int i=0;i<jobs;i++)
		{
			profits[i]=sc.nextInt();
		}
		System.out.println("Enter deadlines of "+jobs+" jobs");
		for(int i=0;i<jobs;i++)
		{
			deadlines[i]=sc.nextInt();
		}
		
		for(int i=0;i<jobs;i++)
		{
			for(int j=i+1;j<jobs;j++)
			{
				if(profits[i]<profits[j])
				{
					temp=profits[i];
					profits[i]=profits[j];
					profits[j]=temp;
					
					temp=deadlines[i];
					deadlines[i]=deadlines[j];
					deadlines[j]=temp;
					
					
				}
			}
		}
		jobscheduling(deadlines,profits,jobs);
	}
}