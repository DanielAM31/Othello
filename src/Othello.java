public class Othello {
	
	public static void main(String[] args) {
		
		int table_length = 9;
		
		InterfaceClient objInterfaceClient = new InterfaceClient();	
		
		Tablero objTablero = new Tablero(table_length);
		
		objInterfaceClient.show(objTablero.gettable());
		
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		
	}
	
}



