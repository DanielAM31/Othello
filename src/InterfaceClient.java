import javax.swing.JOptionPane;

public class InterfaceClient {
	
	public void showtable(int[][] table) {
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
				if (table[x][y] == 0) {
					System.out.print("  ");
				}			
				else if (table[x][y] == 1 && x>=1 && y>=1) {
					System.out.print("+ ");
				}	
				else if (table[x][y] == 2 && x>=1 && y>=1) {
					System.out.print("o ");
				}	
				else {
					System.out.print(table[x][y]+ " ");
				}
			}
			System.out.println("");
		}
	}

	public int[] entercoordines(String textplayer){
		int[] coord = {0, 0};
		coord[0] = Integer.parseInt(JOptionPane.showInputDialog(textplayer + ":\nIngresa x"));
		coord[1] = Integer.parseInt(JOptionPane.showInputDialog(textplayer + ":\nIngresa y"));
		return coord;
	}
}
