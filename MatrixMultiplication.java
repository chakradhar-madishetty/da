import java.util.*;
class MatrixMultiplication
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter array size: ");
		int n=sc.nextInt();
		if(n%2==0)
		{
		int a[][]=new int[n][n];
		int b[][]=new int[n][n];
		System.out.println("Enter matrix-A elements");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter matrix-B elements");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				b[i][j]=sc.nextInt();
			}
		}
		int c[][]=matrixMultiplication(a,b);
		System.out.println("Elements after matrix multiplication");
		for(int x[]:c)
		{
			for(int z:x)
			{
				System.out.print(z+" ");
			}
			System.out.println();
		}
		}
		else
		{
			System.out.println("Divide and Conquer not possible");
		}
	}
	public static int[][] matrixMultiplication(int A[][],int B[][])
	{   int n=A.length;
	    int Result[][]=new int[n][n];
		if(n==2)
		{
			int C00=A[0][0]*B[0][0]+A[0][1]*B[1][0];
			int C01=A[0][0]*B[0][1]+A[0][1]*B[1][1];
			int C10=A[1][0]*B[0][0]+A[1][1]*B[1][0];
			int C11=A[1][0]*B[0][1]+A[1][1]*B[1][1];
			int C[][]=new int[][]{{C00,C01},{C10,C11}};
			return C;
		}
		else
		{
			int a00[][]=new int[n/2][n/2];
			int a01[][]=new int[n/2][n/2];
			int a10[][]=new int[n/2][n/2];
			int a11[][]=new int[n/2][n/2];
			int b00[][]=new int[n/2][n/2];
			int b01[][]=new int[n/2][n/2];
			int b10[][]=new int[n/2][n/2];
			int b11[][]=new int[n/2][n/2];
			
			splitMatrix(A,a00,0,0);
			splitMatrix(A,a01,0,n/2);
			splitMatrix(A,a10,n/2,0);
			splitMatrix(A,a11,n/2,n/2);
			splitMatrix(B,b00,0,0);
			splitMatrix(B,b01,0,n/2);
			splitMatrix(B,b10,n/2,0);
			splitMatrix(B,b11,n/2,n/2);
			
			int c00[][]=addition(matrixMultiplication(a00,b00),matrixMultiplication(a01,b01));
			int c01[][]=addition(matrixMultiplication(a00,b01),matrixMultiplication(a01,b11));
			int c10[][]=addition(matrixMultiplication(a01,b00),matrixMultiplication(a11,b10));
			int c11[][]=addition(matrixMultiplication(a10,b01),matrixMultiplication(a11,b11));
			
			joinMatrix(Result,c00,0,0);
			joinMatrix(Result,c01,0,n/2);
			joinMatrix(Result,c10,n/2,0);
			joinMatrix(Result,c11,n/2,n/2);
			
			return Result;
		}
		
	}
	public static void splitMatrix(int parent[][],int child[][],int row,int col)
	{
		for(int i=0;i<child.length;i++)
		{
			for(int j=0;j<child.length;j++)
			{
				child[i][j]=parent[i+row][j+col];
			}
		}
		
	}
	public static int[][] addition(int A[][],int B[][])
	{   
	    int result[][]=new int[A.length][B.length];
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<B.length;j++)
			{
				result[i][j]=A[i][j]+B[i][j];
			}
		}
		return result;
	}
	public static void joinMatrix(int parent[][],int child[][],int row,int col)
	{
		for(int i=0;i<child.length;i++)
		{
			for(int j=0;j<child.length;j++)
			{
				parent[i+row][j+col]=child[i][j];
			}
		}
		
	}
}