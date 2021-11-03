package DS.Backtracking;

import java.util.Scanner;

public class nQueens {
	static int count=0;
	boolean isSafe(int[][] board,int row,int col,int size)
	{
		int i,j;
		i=row;
		j=col;
		while(j>=0) {
			if(board[i][j]==1)
				return false;
			j--;
		}
		i=row;
		j=col;
		while(i>=0 && j>=0) {
			if(board[i][j]==1) 
				return false;
			i--;j--;
		}
		i=row;
		j=col;
		while(i<size && j>=0)
		{
			if(board[i][j]==1)
				return false;
			i++;
			j--;
		}
		
		return true;
	}
	
	void print(int[][] board,int size)
	{
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	void findQueen(int[][] board,int col,int size)
	{
		if(col == size) {
			count+=1;
			print(board,size);
			System.out.println();
			return;
		}
		
		for(int row=0; row<size; row++)
		{
			if(isSafe(board,row,col,size))
			{
				board[row][col] = 1;
				findQueen(board,col+1,size);
				board[row][col] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		nQueens queen = new nQueens();
		queen.findQueen(board,0,n);
		System.out.println(count);
	}

}
