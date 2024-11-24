import java.util.*;
class SubSequence
{   public static int subsequence(String a,String b,int l1,int l2)
	{
		if(l1==0 || l2==0)
			return 0;
		else if(a.charAt(l1-1)==b.charAt(l2-1))
		{   
			return 1+subsequence(a,b,l1-1,l2-1);
		}
		else
		{
			return Math.max(subsequence(a,b,l1,l2-1),subsequence(a,b,l1-1,l2));
		}
	}
	public static void main(String[] args)
	{
	   Scanner sc=new Scanner(System.in);
	   String a=sc.next();
	   String b=sc.next();
	   int l1=a.length();
	   int l2=b.length();
	   System.out.println("Subsequence : "+subsequence(a,b,l1,l2));
	}
}