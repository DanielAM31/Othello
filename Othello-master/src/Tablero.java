import java.util.Arrays;

public class Tablero {
	
	private int[][] table;
	private Piece piece0;
	private Piece piece1;
	private Piece piece2;
	
	public Tablero (int table_length, Piece piece0, Piece piece1, Piece piece2) {
		
		this.piece0 = piece0;
		this.piece1 = piece1;
		this.piece2 = piece2;
		table = new int [table_length + 2][table_length + 2];
			
		for (int i = 1; i < table.length - 1; i++) {
			for (int j = 1; j < table.length - 1; j++) {
				table[i][j] = this.piece0.gettypepiece();
			}
		}
		
		table[4][5] = this.piece1.gettypepiece();
		table[5][4] = this.piece1.gettypepiece();
		table[4][4] = this.piece2.gettypepiece();
		table[5][5] = this.piece2.gettypepiece();
	}
	
    //https://rstopup.com/como-puedo-copiar-una-matriz-de-2-dimensiones-en-java.html
	public int[][] gettable (){
		int[][] temp = Arrays.stream(this.table).map(row -> row.clone()).toArray(int[][]::new);
		return temp;
	}
	
	public int getcountpiece (Piece piece) {
		int countpieces = 0;
		for (int i = 1; i < table.length - 1; i++) {
			for (int j = 1; j < table.length - 1; j++) {
				if (this.table[i][j] == piece.gettypepiece()) {
					countpieces++;
				}
			}
		}
		return countpieces;
	}
	
	public boolean getfreespace () {
		if (this.getcountpiece(piece0) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean anypiece (int x, int y) {
		return this.table[x][y] != piece0.gettypepiece();
	}
	
	public int doMove (int x, int y, Piece myPiece, boolean simulate) {
		if (this.anypiece(x, y)) {
			return 0;
		}
		
		int maxlength = this.table.length - 2;
		int[] options = new int[8];
		int[][] dataRule = new int[8][3];
		
		Piece rivalPiece = this.piece2;
		if (rivalPiece.gettypepiece() == myPiece.gettypepiece()) {
			rivalPiece = this.piece1;
		}
		
		dataRule[0] = this.ruleDir0(x, y);
		options[0] = this.countchanges(x,y,dataRule[0][0],dataRule[0][1],dataRule[0][2],rivalPiece,myPiece);
				
		dataRule[1] = this.ruleDir1(y);
		options[1] = this.countchanges(x,y,dataRule[1][0],dataRule[1][1],dataRule[1][2],rivalPiece,myPiece);
		
		dataRule[2] = this.ruleDir2(x, y, maxlength);
		options[2] = this.countchanges(x,y,dataRule[2][0],dataRule[2][1],dataRule[2][2],rivalPiece,myPiece);
		
		dataRule[3] = this.ruleDir3(x, maxlength);
		options[3] = this.countchanges(x,y,dataRule[3][0],dataRule[3][1],dataRule[3][2],rivalPiece,myPiece);
		
		dataRule[4] = this.ruleDir4(x, y, maxlength);
		options[4] = this.countchanges(x,y,dataRule[4][0],dataRule[4][1],dataRule[4][2],rivalPiece,myPiece);
		
		dataRule[5] = this.ruleDir5(y, maxlength);
		options[5] = this.countchanges(x,y,dataRule[5][0],dataRule[5][1],dataRule[5][2],rivalPiece,myPiece);
		
		dataRule[6] = this.ruleDir6(x, y, maxlength);
		options[6] = this.countchanges(x,y,dataRule[6][0],dataRule[6][1],dataRule[6][2],rivalPiece,myPiece);
		
		dataRule[7] = this.ruleDir7(x);
		options[7] = this.countchanges(x,y,dataRule[7][0],dataRule[7][1],dataRule[7][2],rivalPiece,myPiece);
		
		int possible = 0;
		for (int i = 0; i < options.length; i++) {
			if (options[i] > 0) {
				possible++;
			}
		}
		
		if (possible == 0) {
			return 0;
		}
		
		if (!simulate) {
			for (int i = 0; i < 8; i++) {
				if (options[i] > 0) {
					this.doChanges(x, y, dataRule[i][0], dataRule[i][1], options[i], myPiece);								
				}
			}			
		}
		return possible;
	}
	
	private int[] ruleDir0 (int x, int y) {
		int[] array = {-1,-1, 0};
		int maxDiag = x - 1;
		int ruleChange = x - y;
		int maxIterations = maxDiag - ruleChange;
		if (ruleChange < 0) {maxIterations = maxDiag;}
		array[2] = maxIterations;
		return array;
	}
	
	private int[] ruleDir1 (int y) {
		int[] array = {0,-1, y - 1};
		return array;
	}
	
	private int[] ruleDir2 (int x, int y, int maxlength) {
		int[] array = {+1,-1, 0};
		int maxDiag = maxlength - x;
		int ruleChange = y - 1;
		int maxIterations = maxDiag;
		if (ruleChange < maxDiag) {maxIterations = ruleChange;}
		array[2] = maxIterations;
		return array;
	}
	
	private int[] ruleDir3 (int x, int maxlength) {
		int[] array = {+1,0, maxlength - x};
		return array;
	}
	
	private int[] ruleDir4 (int x, int y, int maxlength) {
		int[] array = {+1,+1, 0};
		int maxDiag = maxlength - x;
		int ruleChange = x - y;
		int maxIterations = maxDiag;
		if (ruleChange < 0) {maxIterations = maxDiag + ruleChange;}
		array[2] = maxIterations;
		return array;
	}
	
	private int[] ruleDir5 (int y, int maxlength) {
		int[] array = {0,+1, maxlength - y};
		return array;
	}
	
	private int[] ruleDir6 (int x, int y, int maxlength) {
		int[] array = { -1, +1, 0 };
		int maxDiag = x - 1;
		int ruleChange = maxlength - y;
		int maxIterations = maxDiag;
		if (ruleChange < maxDiag) { maxIterations = ruleChange;	}
		array[2] = maxIterations;
		return array;
	}
	
	private int[] ruleDir7 (int x) {
		int[] array = {-1,0, x - 1};
		return array;
	}
	
	private int countchanges (int x, int y, int xdir, int ydir, int maxIterations, Piece rpiece, Piece mpiece) {
		int counts = 0;
		int index = 1;
		while (index <= maxIterations + 1) {
			x = x + xdir;
			y = y + ydir;
			if (table[x][y] == rpiece.gettypepiece()) {
				++counts;
			}
			else if (table[x][y] == mpiece.gettypepiece()) {
				break;
			}
			else {
				counts = 0;
				break;
			}
			index++;
		}
		return counts;
	}
	
	private void doChanges (int x, int y, int xi, int yi, int maxMove, Piece mPiece) {
		for (int i = 0; i <= maxMove; i++) {
			this.table[x + (xi * i)][y + (yi * i)] = mPiece.gettypepiece();
		}
	}
	
}
