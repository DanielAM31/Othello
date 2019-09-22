
public class Othello {
	
	public static void main(String[] args) {
		
		int table_length = 9;
		
		InterfaceClient objInterfaceClient = new InterfaceClient();	
		
		Tablero objTablero = new Tablero(table_length);
		
		objInterfaceClient.showtable(objTablero.gettable());
		
		Player player1 = new Player(2);
		Player player2 = new Player(1);
		
		 do {
			
			player1.setcountpieces(objTablero.getcountpiece(player1.gettypepiece()));
			player2.setcountpieces(objTablero.getcountpiece(player2.gettypepiece()));
			
			player1.settoken(true);
			player2.settoken(false);
			
			int[] coords = objInterfaceClient.entercoordines("Player 1");
					
		} while(objTablero.getcountpiece(1) < 1);
		
	}
}



