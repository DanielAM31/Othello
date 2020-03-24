import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class GraphicalInterface extends JFrame implements ActionListener {
	
	int filabotones;
	int cantidadbotones; 
	JButton matrizbotones[];
	JPanel panel;
	String Iconurl1 = "src/img/phone.png";
	String Iconurl2 = "src/img/gold.png";
	ImageIcon iconobtn1 = new ImageIcon(Iconurl1);
	ImageIcon iconobtn2 = new ImageIcon(Iconurl2);
	Icon icon1 = new JButton(this.iconobtn1).getIcon();
	
	public GraphicalInterface(int fila) {
		
		/*Creación de los Botones y el panel*/
		
		this.filabotones = fila;
		this.cantidadbotones = this.filabotones * this.filabotones;
		this.matrizbotones = new JButton[this.cantidadbotones];
		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(this.filabotones, this.filabotones));
		
		for(int i=0; i < this.cantidadbotones; i++) {
			this.matrizbotones[i] = new JButton(this.iconobtn1);
			this.matrizbotones[i].addActionListener(this);
			this.panel.add(this.matrizbotones[i]);
		}
				
		add(this.panel);
				
	}
	
	public void actionPerformed(ActionEvent c) {
		
		for(int i=0; i < this.cantidadbotones; i++) {
			if(c.getSource() == this.matrizbotones[i]) {
				Icon cadena = this.matrizbotones[i].getIcon();
				
				if(cadena == icon1) {
					
					this.matrizbotones[i].setIcon(this.iconobtn2);
				}
				else{
				
					this.matrizbotones[i].setIcon(this.iconobtn1);
				}
				try{Thread.sleep(100);}catch(InterruptedException ie){}
			}
		}
	}
}