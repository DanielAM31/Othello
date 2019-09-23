import java.util.Arrays;

public class Tablero {
	
	private int[][] table;
	private Piece piece0;
	private Piece piece1;
	private Piece piece2;
	
	public Tablero(int table_lenght, Piece piece0, Piece piece1, Piece piece2) {
		
		this.piece0 = piece0;
		this.piece1 = piece1;
		this.piece2 = piece2;
		
		table = new int [table_lenght][table_lenght];
		for (int i = 0; i < table_lenght; i++) {
			table[0][i] = i;
			table[i][0] = i;
		}
		
		for (int i = 1; i < table_lenght; i++) {
			for (int j = 1; j < table.length; j++) {
				table[i][j] = this.piece0.gettypepiece();
			}
		}
		
		table[4][5] = this.piece1.gettypepiece();
		table[5][4] = this.piece1.gettypepiece();
		table[4][4] = this.piece2.gettypepiece();
		table[5][5] = this.piece2.gettypepiece();
	}
	
    //https://rstopup.com/como-puedo-copiar-una-matriz-de-2-dimensiones-en-java.html
	public int[][] gettable(){
		int[][] temp = Arrays.stream(this.table).map(row -> row.clone()).toArray(int[][]::new);
		return temp;
	}
	
	public int gettypiece(Piece piece) {
		if (piece.gettypepiece() == this.piece1.gettypepiece()) {
			return piece1.gettypepiece();
		}
		else {
			return piece2.gettypepiece();
		}
	}
	
	public int getcountpiece(Piece piece) {
		int countpieces = 0;
		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table.length; j++) {
				if (this.table[i][j] == piece.gettypepiece()) {
					countpieces++;
				}
			}
		}
		return countpieces;
	}
	
	public boolean getfreespace() {
		if(this.getcountpiece(piece0) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean anypiece(int x, int y) {
		return this.table[x][y] != piece0.gettypepiece();
	}
	
	public void prueba(int x, int y, Piece piece) {
		
	}
}
