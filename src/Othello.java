public class Othello {
	
	public static void main (String[] args) {
		
		int table_length = 8;
		GraphicalInterface objTableroGrafico = new GraphicalInterface(table_length);
		objTableroGrafico.setBounds(0, 0, table_length * 50 + 10, table_length * 50 + 60);
		objTableroGrafico.setVisible(true);
		
		InterfaceClient objInterfaceClient = new InterfaceClient();	
		
		Piece piece0 = new Piece(0);
		Piece piece1 = new Piece(1);
		Piece piece2 = new Piece(2);
		
		Tablero objTablero = new Tablero(table_length, piece0, piece1, piece2);
		
		objInterfaceClient.showtable(objTablero, piece0, piece1, piece2);
		
		Player player1 = new Player(piece1);
		Player player2 = new Player(piece2);
		
		player1.setcountpieces(objTablero.getcountpiece(piece1));
		player2.setcountpieces(objTablero.getcountpiece(piece2));
		
		Test objTest = new Test();
		boolean testRun = objInterfaceClient.iwantruntest();
		
		int[] coords = {objTableroGrafico.isCol, objTableroGrafico.isRow};
		int coordsNoValid = 0;
		int possiblePlay = 0;
		String[] textPlayer = {"Jugador 1", "Jugador 2"};
		Piece[] pieceToMove = {piece1, piece2};
		int play = 0; // 0 es textPlayer y pieceToMove [0]. Mientras que 1 es textPlayer y pieceToMove [1]
		int allPieces0 = (table_length * table_length) - 4;
		
		// Run game and start move Player 1
		while (allPieces0 > 0) {
			for (int i = 1; i < table_length + 1; i++) {
				for (int j = 1; j < table_length + 1; j++) {
					possiblePlay += objTablero.doMove(i, j, pieceToMove[play], true);
				}
				if (possiblePlay > 0) {
					break;
				}
			}
			
			if (possiblePlay > 0)  {
				possiblePlay = 0;
				while (coordsNoValid == 0) {
					if (testRun == false) {
							coords[0] = objTableroGrafico.isCol;
							coords[1] = objTableroGrafico.isRow;					
					}
					else {
						coords = objTest.getonecoords();
						testRun = objTest.stilltest();
					}
					coordsNoValid = objTablero.doMove(coords[0], coords[1], pieceToMove[play], false);					
				}
				coordsNoValid = 0;
			}
			
			if (play == 0) {play = 1;}
			else {play = 0;}
			
			objInterfaceClient.showtable(objTablero, piece0, piece1, piece2);
			allPieces0 = objTablero.getcountpiece(piece0);
		}
		
		objInterfaceClient.showwin(textPlayer, pieceToMove, objTablero);
	}
	
}
