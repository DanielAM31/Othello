public class Othello {
	
	public static void main(String[] args) {
		int table_length = 9;
		Tablero objTablero = new Tablero(table_length);
		InterfaceClient objInterfaceClient= new InterfaceClient();
		objInterfaceClient.show(objTablero.table);
	}
	
}



