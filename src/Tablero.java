
public class Tablero {
	public int[][] table;
	
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
}
