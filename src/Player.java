
public class Player {
	
	private Piece piece;
	private int countpieces;
	private boolean token;
	
	public Player(Piece piece) {
		this.piece = piece;
	}
	
	public int gettypepiece() {
		return this.piece.gettypepiece();
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
