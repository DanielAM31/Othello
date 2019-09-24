import javax.swing.JOptionPane;

public class InterfaceClient {
	
	public void showtable (Tablero tablero, Piece p0, Piece p1, Piece p2) {
		int[][] table = tablero.gettable();
		
		System.out.println("");
		for (int y=0; y<table.length; y++) {
			if (y == 1) {
				for (int i = 0; i <= table.length; i++) {
					System.out.print("--");					
				}
				System.out.println("");
			}			
			for (int x=0; x<table.length; x++) {
				if (x == 1) {
					System.out.print("|");					
				}
				if (y == 0 && x < table.length - 1) {
					System.out.print(x + " ");
				}
				else if (x == 0 && y < table.length - 1) {
					System.out.print(y + " ");
				} 
				else if (table[x][y] == p0.gettypepiece()) {
					System.out.print("  ");
				}			
				else if (table[x][y] == p1.gettypepiece() && x>=1 && y>=1) {
					System.out.print("+ ");
				}	
				else if (table[x][y] == p2.gettypepiece() && x>=1 && y>=1) {
					System.out.print("o ");
				}
			}
			System.out.println("");
		}
	}

	public int[] entercoordines(String textplayer, int maxlenght){
		int[] coord = {0, 0};
		while ((coord[0] < 1 || coord[1] < 1) || (coord[0] > maxlenght || coord[1] > maxlenght)) {
			coord[0] = Integer.parseInt(JOptionPane.showInputDialog(textplayer + "\ninput X: "));
			coord[1] = Integer.parseInt(JOptionPane.showInputDialog(textplayer + "\ninput Y: "));
		}
		return coord;
	}
	
	public boolean iwantruntest () {
		int yesno = JOptionPane.showConfirmDialog(null, "Quiere correr una Prueba - por defecto NO");
		return (yesno == 0) ? true : false; // if and else en modo una sola línea
	}
	
	public void showwin (String[] texts, Piece[] pieces, Tablero table) {
		int countPieces1 = table.getcountpiece(pieces[0]);
		int countPieces2 = table.getcountpiece(pieces[1]);
		
		if (countPieces1 > countPieces2) {
			JOptionPane.showMessageDialog(null, 
					"Gana " + texts[0] +".\n"+ countPieces1 + " Fichas\n("+ pieces[0].gettypepiece() +")");
		}
		else if (countPieces1 < countPieces2) {
			JOptionPane.showMessageDialog(null, 
					"Gana " + texts[1] +".\n"+ countPieces2 + " Fichas\n("+ pieces[1].gettypepiece() +")");
		}
		else {
			JOptionPane.showMessageDialog(null, "Empate");
		}
		JOptionPane.showMessageDialog(null, "E N D   G A M E");
	}

}


