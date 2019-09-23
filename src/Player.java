public class Player {
	
	private Piece piece;
	private int countpieces;
	//	private boolean token; // For the Future
	
	public Player (Piece piece) {
		this.piece = piece;
	}
	
	public int gettypepiece () {
		return this.piece.gettypepiece();
	}
	
	public int getcountpieces () {
		return this.countpieces;
	}
	
	public void setcountpieces (int countpieces) {
		this.countpieces = countpieces;
	}
	
	//For the Future
	//	public boolean gettoken () {
	//		return this.token;
	//	}
		
	//	public void settoken (boolean token) {
	//		this.token = token;
	//	}
}
