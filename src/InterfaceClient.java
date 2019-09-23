import javax.swing.JOptionPane;

public class InterfaceClient {
	
	public void showtable(Tablero tablero, Piece p0, Piece p1, Piece p2) {
		int[][] table = tablero.gettable();
		for(int x=0; x<table.length; x++) {
			if (x == 1) {
				for (int i = 0; i <= table.length; i++) {
					System.out.print("--");					
				}
				System.out.println("");
			}
			
			for (int y=0; y<table.length; y++) {
				if (y == 1) {
					System.out.print("|");					
				}
				if (table[x][y] == p0.gettypepiece()) {
					System.out.print("  ");
				}			
				else if (table[x][y] == p1.gettypepiece() && x>=1 && y>=1) {
					System.out.print("+ ");
				}	
				else if (table[x][y] == p2.gettypepiece() && x>=1 && y>=1) {
					System.out.print("o ");
				}	
				else {
					System.out.print(table[x][y]+ " ");
				}
			}
			System.out.println("");
		}
	}

	public int[] entercoordines(String textplayer, int maxlenght){
		int[] coord = {0, 0};
		while ((coord[0] == 0 || coord[1] == 0) || (coord[0] > maxlenght || coord[1] > maxlenght)) {
			coord[0] = Integer.parseInt(JOptionPane.showInputDialog(textplayer + ":\nIngresa x"));
			coord[1] = Integer.parseInt(JOptionPane.showInputDialog(textplayer + ":\nIngresa y"));
		}
		return coord;
	}
}

