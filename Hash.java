import java.util.Scanner;

public class Hash {
	public static void main(String[] args) {
	
		char[][] matrix = new char [3][3];
		char active = 'X'; //player that starts the game
		int round = 1;
		boolean validplay = false;
		int x = 0;
		int y = 0;
		
		while (Victory(matrix, active)==false && round < 10){
			
			validplay = false;
			while(validplay == false){
				
				System.out.println("\nit's player "+ active + "'s turn!\n");
				Scanner scan = new Scanner(System.in);
				System.out.println("Insert line (1, 2 or 3)");
				x = scan.nextInt()-1;
				System.out.println("Insert column (1, 2 or 3)"); //more user friendly than 0, 1 or 2
				y = scan.nextInt()-1;

				if (x>2 || x<0 || y>2 || y<0 || matrix[x][y] == 'X' || matrix[x][y] == 'O'){
					System.out.println("Not valid, play again");	
				} else {
					validplay = true;
				}
			}
			
			matrix [x][y] = active;
			
			if(Victory(matrix, active)==true){
				break;
			} else if (active == 'X'){
				active = 'O';
			} else {
				active = 'X';
			}

			PrintMatrix(matrix);
			round += 1;	
		}
		
		if (Victory(matrix, active)==false){
			System.out.println("\nNobody won :(");
		} else {	
			PrintMatrix(matrix);
			System.out.println("******************************"); 
			System.out.println("******The player " + active + " won!!******");
			System.out.println("******************************");
		}
	}

	public static void PrintMatrix(char[][] matrix){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print("|" + matrix[i][j] + "|");
			}
			System.out.print("\n");
		}
	}

	public static boolean Victory(char[][] matrix, char player){
		boolean check;
			if(matrix[0][0]==player && matrix[1][0]==player && matrix[2][0]==player){
				check =  true;	
			} else if (matrix[0][1]==player && matrix[1][1]==player && matrix[2][1]==player){
				check = true;
			} else if (matrix[0][2]==player && matrix[1][2]==player && matrix[2][2]==player){
				check = true;
			} else if (matrix[0][0]==player && matrix[0][1]==player && matrix[0][2]==player){
				check = true;
			} else if (matrix[1][0]==player && matrix[1][1]==player && matrix[1][2]==player){
				check = true;
			} else if (matrix[2][0]==player && matrix[2][1]==player && matrix[2][2]==player){
				check = true;
			} else if (matrix[0][0]==player && matrix[1][1]==player && matrix[2][2]==player){
				check = true;
			} else if (matrix[0][2]==player && matrix[1][1]==player && matrix[2][0]==player){
				check = true;
			} else {
				check = false;
			}
	return check;
	}
}