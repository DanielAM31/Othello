
public class Player {
	
	private int typepiece;
	private int countpieces;
	private boolean token;
	
	public Player(int piece) {
		this.typepiece = piece;
	}
	
	public int gettypepiece() {
		return this.typepiece;
	}
	
	public int getcountpieces() {
		return this.countpieces;
	}
	
	public void setcountpieces(int countpieces) {
		this.countpieces = countpieces;
	}
	
	public boolean gettoken() {
		return this.token;
	}
	
	public void settoken(boolean token) {
		this.token = token;
	}
}
