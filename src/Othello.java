
public class Othello {
	
	public static void main(String[] args) {
		
		int table_length = 9;
		
		InterfaceClient objInterfaceClient = new InterfaceClient();	
		
		Piece piece0 = new Piece(0);
		Piece piece1 = new Piece(1);
		Piece piece2 = new Piece(2);
		
		Tablero objTablero = new Tablero(table_length, piece0, piece1, piece2);
		
		objInterfaceClient.showtable(objTablero, piece0, piece1, piece2);
		
		Player player1 = new Player(piece1);
		Player player2 = new Player(piece2);
		
		do {
			player1.setcountpieces(objTablero.getcountpiece(piece1));
			player2.setcountpieces(objTablero.getcountpiece(piece2));
			
			player1.settoken(true);
			player2.settoken(false);
			
			int[] coords = new int [2];
			int coordNoValid = 0;
			do {
				coords = objInterfaceClient.entercoordines("Player 1", table_length - 1);
				coordNoValid = objTablero.doMove(coords[0], coords[1], piece1);
			} while(coordNoValid == 0);
			
			
			
		} while(objTablero.getcountpiece(piece1) < 1); // cambiar a piecezero

	}
}



