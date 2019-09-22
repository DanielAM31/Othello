import java.util.Arrays;

public class Tablero {
	
	private int[][] table;
	
	public Tablero(int table_lenght) {
		table = new int [table_lenght][table_lenght];
		for (int i = 0; i < table_lenght; i++) {
			table[0][i] = i;
			table[i][0] = i;
		}
		table[4][5] = 1;
		table[5][4] = 1;
		table[4][4] = 2;
		table[5][5] = 2;
	}
	
    //https://rstopup.com/como-puedo-copiar-una-matriz-de-2-dimensiones-en-java.html
	public int[][] gettable(){
		int[][] temp = Arrays.stream(this.table).map(row -> row.clone()).toArray(int[][]::new);
		return temp;
	}
	
	public int getcountpiece(int typepiece) {
		int countpieces = 0;
		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table.length; j++) {
				if (this.table[i][j] == typepiece) {
					countpieces++;
				}
			}
		}
		return countpieces;
	}
	
	public boolean getfreespace() {
		if(this.getcountpiece(0) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
}
