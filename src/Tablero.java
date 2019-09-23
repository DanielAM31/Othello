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
//		table[6][6] = this.piece1.gettypepiece();
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
		int maxlength = this.table.length - 1;
		int[] options = new int[8];;
		
		Piece rivalPiece = this.piece2;
		if (rivalPiece.gettypepiece() == myPiece.gettypepiece()) {
			rivalPiece = this.piece1;
		}
		
		int[] dataRule = this.ruleDir0(x, y);
		options[0] = this.countchanges(x,y,dataRule[0],dataRule[1],dataRule[2],rivalPiece,myPiece);
				
		dataRule = this.ruleDir1(y);
		options[1] = this.countchanges(x,y,dataRule[0],dataRule[1],dataRule[2],rivalPiece,myPiece);
		
		dataRule = this.ruleDir3(x, maxlength);
		options[3] = this.countchanges(x,y,dataRule[0],dataRule[1],dataRule[2],rivalPiece,myPiece);
		
		dataRule = this.ruleDir4(x, y, maxlength);
		options[4] = this.countchanges(x,y,dataRule[0],dataRule[1],dataRule[2],rivalPiece,myPiece);
		
		dataRule = this.ruleDir5(y, maxlength);
		options[5] = this.countchanges(x,y,dataRule[0],dataRule[1],dataRule[2],rivalPiece,myPiece);
		
		dataRule = this.ruleDir7(x);
		options[7] = this.countchanges(x,y,dataRule[0],dataRule[1],dataRule[2],rivalPiece,myPiece);
		
	}
	
	private int[] ruleDir0(int x, int y) {
		int[] array = {-1,-1, 0};
		int maxDiag = x - 1;
		int ruleChange = x - y;
		int maxIterations = maxDiag - ruleChange;
		if (ruleChange < 0) {maxIterations = maxDiag;}
		array[2] = maxIterations;
		return array;
	}
	
	private int[] ruleDir1(int y) {
		int[] array = {0,-1, y - 1};
		return array;
	}
	
//	private int[] ruleDir2(int x, int y, int maxlength) {
//		int[] array = {+1,-1, 0};
//		int maxDiag = maxlength - x;
//		int ruleChange = x - y;
//		int maxIterations = maxDiag;
//		if (ruleChange < 0) {maxIterations = maxDiag + ruleChange;}
//		array[2] = maxIterations;
//		return array;
//	}
	
	private int[] ruleDir3(int x, int maxlength) {
		int[] array = {+1,0, maxlength - x};
		return array;
	}
	
	private int[] ruleDir4(int x, int y, int maxlength) {
		int[] array = {+1,+1, 0};
		int maxDiag = maxlength - x;
		int ruleChange = x - y;
		int maxIterations = maxDiag;
		if (ruleChange < 0) {maxIterations = maxDiag + ruleChange;}
		array[2] = maxIterations;
		return array;
	}
	
	private int[] ruleDir5(int y, int maxlength) {
		int[] array = {0,+1, maxlength - y};
		return array;
	}
	
//	private int[] ruleDir6(int x, int y, int maxlength) {
//		int[] array = { -1, +1, 0 };
//		int maxDiag = maxlength - x;
//		int ruleChange = x - y;
//		int maxIterations = maxDiag;
//		if (ruleChange < 0) {
//			maxIterations = maxDiag + ruleChange;
//		}
//		array[2] = maxIterations;
//		return array;
//	}
	
	private int[] ruleDir7(int x) {
		int[] array = {-1,0, x - 1};
		return array;
	}
	
	private int countchanges(int x, int y, int xdir, int ydir, int maxIterations, Piece rpiece, Piece mpiece) {
		int counts = 0;
		int index = 1;		
		System.out.println(maxIterations);
		while(index <= maxIterations){
			x = x + xdir;
			y = y + ydir;
			String temp = "for " + index;
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
