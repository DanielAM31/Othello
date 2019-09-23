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
		
//		table[3][3] = this.piece1.gettypepiece();
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
	
	public void prueba(int x, int y, Piece myPiece) {
//		int maxlenght = table.length - 1;
		int[] options = new int[8];;
		
		Piece rivalPiece = this.piece2;
		if (rivalPiece.gettypepiece() == myPiece.gettypepiece()) {
			rivalPiece = this.piece1;
		}
		
		int[] dataRule = this.ruleDir00(x, y);
		options[0] = this.countchanges(x,y,dataRule[0],dataRule[1],dataRule[2],rivalPiece,myPiece);
		
//		if(x != 1 && x != maxlenght && y != 1 && y != maxlenght) {
//			options = new int[8];
//			if(table[x-1][y-1] == pRival.gettypepiece()) {
//				System.out.print("0.0");
//			}
//			if(table[x][y-1] == pRival.gettypepiece()) {
//				System.out.print("1.0");
//			}
//		}
//		else if ( (x == 1 || x == maxlenght) && (y == 1 || y == maxlenght) ) {
//			options = new int[3];
//		}
//		else {
//			options = new int[5];
//		}
	}
	
	private int[] ruleDir00(int x, int y) {
		int[] array = {-1,-1, 0};
		int maxDiag00 = x - 1;
		int iterar = x - y;
		int maxIterations = maxDiag00 - iterar;
		if (iterar < 0) {maxIterations = maxDiag00;}
		array[2] = maxIterations;
		return array;
	}
	
	private int countchanges(int x, int y, int xdir, int ydir, int maxIterations, Piece rpiece, Piece mpiece) {
		int counts = 0;
		int index = 1;		
		System.out.println(maxIterations);
		while(index <= maxIterations){
			x = x + xdir;
			y = y + ydir;
			String temp = "for " + index + "("+ y +") ";
			System.out.print(temp);
			if(table[x][y] == rpiece.gettypepiece()) {
				++counts;
				System.out.println("si" + counts);
			}
			else if (table[x][y] == mpiece.gettypepiece()) {
				System.out.println("Mia " + counts);
				break;
			}
			else {
				counts = 0;
				System.out.println("roto " + counts);
				break;
			}
			index++;
		}
		return counts;
	}
	
	
}
