
public class Othello {

	public static void main(String[] args) {
		// Initial table
		int TAB_LENGTH = 9;
		int[][] tablero = new int[TAB_LENGTH][TAB_LENGTH];
		for (int i = 0; i < TAB_LENGTH; i++) {
			tablero[0][i] = i;
			tablero[i][0] = i;
		}
		
		// show table in console
		for(int x=0; x<TAB_LENGTH; x++) {
			if (x == 1) {
				for (int i = 0; i <= TAB_LENGTH; i++) {
					System.out.print("-");					
				}
				System.out.println("");
			}
			
			for (int y=0; y<TAB_LENGTH; y++) {
				if (y == 1) {
					System.out.print("|");					
				}
				
				System.out.print(tablero[x][y]);
			}
			System.out.println("");
		}
	}

}
