package AcidRain;

public class USER {
	
	private String USER_ID;
	private String USER_NAME;
	private int WHICHGAME;
	private int SCORE;
	
	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public void setUSER_NAME(String USER_NAME) {
		this.USER_NAME = USER_NAME;
	}

	public String getUSER_ID() {
		return this.USER_ID;
	}
	
	public String getUSER_NAME() {
		return this.USER_NAME;
	}
	
	public void setWhichGame(int game) {
		this.WHICHGAME = game;
	}
	
	public void setScore(int score) {
		this.SCORE=score;
	}
	
	public int getWhichGame()
	{
		return this.WHICHGAME;
	}

}
