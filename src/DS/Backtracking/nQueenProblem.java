package DS.Backtracking;

import java.util.Scanner;

public class nQueenProblem {
	
	boolean isSafe(int[][] board,int n,int row,int col) 
	{
		int i,j;
		for(i=row; i>=0; i--)
		{
			if(board[i][col]==1)
				return false;
		}
		
		for(i=0; i<col; i++) 
		{
			if(board[row][i]==1)
				return false;
		}
		
		for(i=row,j=col;i>=0 && j>=0;i--,j--)
		{
			if(board[i][j]==1) 
				return false;
		}
		
		for(i=row,j=col;i<n && j>=0;i++,j--)
		{
			if(board[i][j]==1)
				return false;
		}
		return true;
	}
	
	boolean nQueen(int[][] board,int n,int row) 
	{
		if(row == n)  {
			print(board,n);
			return true;
		}
		
		for(int col=0; col<n; col++) 
		{
			if(isSafe(board,n,row,col)) {
				board[row][col]=1;
				if(nQueen(board,n,row+1)) return true;
				board[row][col]=0;
			}
		}
		
		return false;
	}
	
	void print(int[][] board,int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Enter size of chess board..");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		nQueenProblem start = new nQueenProblem();
		start.nQueen(board,n,0);	

	}
}
