
public class InterfaceClient {
	public void show(int[][] table) {
		for(int x=0; x<table.length; x++) {
			if (x == 1) {
				for (int i = 0; i <= table.length; i++) {
					System.out.print("-");					
				}
				System.out.println("");
			}
			
			for (int y=0; y<table.length; y++) {
				if (y == 1) {
					System.out.print("|");					
				}
				System.out.print(table[x][y]);
			}
			System.out.println("");
		}
	}
}
