import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class GraphicalInterface extends JFrame implements ActionListener {
	
	int filabotones;
	int cantidadbotones; 
	JButton matrizbotones[];
	JPanel panel;
	String Iconurl1 = "src/img/circle_black.png";
	String Iconurl2 = "src/img/circle_white.png";
	ImageIcon iconobtn1 = new ImageIcon(Iconurl1);
	ImageIcon iconobtn2 = new ImageIcon(Iconurl2);
	Icon icon1 = new JButton(this.iconobtn1).getIcon();
	
	int isRow = 4, isCol = 4;
	
	public GraphicalInterface(int fila) {
		/*Creación de los Botones y el panel*/
		this.filabotones = fila;
		this.cantidadbotones = this.filabotones * this.filabotones;
		this.matrizbotones = new JButton[this.cantidadbotones];
		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(this.filabotones, this.filabotones));
		
		for(int i=0; i < this.cantidadbotones; i++) {
			this.matrizbotones[i] = new JButton();
			this.matrizbotones[i].addActionListener(this);
			this.panel.add(this.matrizbotones[i]);
		}

		add(this.panel);
	}
	
	public void actionPerformed(ActionEvent eventClick) {
		for(int i=0; i < this.cantidadbotones; i++) {
			if(eventClick.getSource() == this.matrizbotones[i]) {			
				this.isRow = (i / this.filabotones) + 1;
				this.isCol = (i % this.filabotones) + 1;		
				try{Thread.sleep(100);}catch(InterruptedException ie){}
			}
		}
	}
	
	public void setLabelPlayer(String text) {
		Border border = BorderFactory.createTitledBorder(text);
		this.panel.setBorder(border);
	}
	
	public void changeIcons(int[][] table, int table_length) {
		for (int x = 1; x < table_length + 1; x++) {
			for (int y = 1; y < table_length + 1; y++) {
				if(table[x][y] == 1) {
					this.matrizbotones[((y - 1) * table_length + x) - 1].setIcon(this.iconobtn1);
				}
				else if(table[x][y] == 2) {
					this.matrizbotones[((y - 1) * table_length + x) - 1].setIcon(this.iconobtn2);
				}
			}
		}

		
	}
}