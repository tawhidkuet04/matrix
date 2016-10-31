/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixx;

/**
 *
 * @author Tawhid Joarder
 */
import java.util.Scanner;

public class Matrixx {
        static int[][] matrix1 = new int[5][5];     
	static int[][] matrix2 = new int[5][5];		
	static int[][] matrix3 = new int[5][5];	
	
	static Thread t1 = new Thread(new Runnable() {
		public void run() {
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
			 matrix3[0][j] += matrix1[0][i]*matrix2[i][j];
				}
			}
		}
	});
	
	static Thread t2 = new Thread(new Runnable() {
		public void run() {
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
			  matrix3[1][j] += matrix1[1][i]*matrix2[i][j];
				}
			}
		}
	});
	
	
	
	static Thread t3 = new Thread(new Runnable() {
		public void run() {
		for (int j = 0; j < 3; j++) {
		    for (int i = 0; i < 3; i++) {
			  matrix3[2][j] += matrix1[2][i]*matrix2[i][j];
				}
			}
		}
	});
	
	
	
    static void solve(){
    	t1.start();    //Thread 1
    	t2.start();    //Thread 2
    	t3.start();    // Thread 3
    }
 
	public static void main(String[] args) {
		
		
	        Scanner input = new Scanner(System.in);
		System.out.println("Enter First matrix : ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix1[i][j] = input.nextInt();
			}	
		}

		System.out.println("Enter Second  matrix  : ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix2[i][j] = input.nextInt();
			}
			
		}
		Matrixx.solve();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final Matrix : ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrix3[i][j] + " ");
			}
			System.out.println("");
		}
	}

}