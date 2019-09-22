
public class Tablero {
	public int[][] table;
	
	public Tablero(int table_lenght) {
		table = new int [table_lenght][table_lenght];
		for (int i = 0; i < table_lenght; i++) {
			table[0][i] = i;
			table[i][0] = i;
		}
	}
}
