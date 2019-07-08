package main.com.game;

import java.util.LinkedList;

import javax.swing.JLabel;

import main.com.show.GameChooseUI;
import main.com.show.ResultView;

public class CheckTheGameEnd extends Thread {
	public static int gamePlayTime = 0;
	public LinkedList<JLabel> words;
	public JLabel playTime;
	int wordCount;

	public CheckTheGameEnd(int gameTime, LinkedList<JLabel> words) {
		this.words = words;
		gamePlayTime = gameTime;
		playTime = new JLabel(Integer.toString(gamePlayTime));
	}

	public void run() {
		try {
			checkTheEnd();
		} catch (InterruptedException e) {
			e.printStackTrace();
			new ResultView(GameChooseUI.GAMESCORE, words.size());
		}
	}

	public void checkTheEnd() throws InterruptedException {

		while ((gamePlayTime > 0 && words.size() > 0) &&  checkTheWordVisible()) {
			Thread.sleep(1000);
			playTime.setText(gamePlayTime + "");
			gamePlayTime--;
		}

		throw new InterruptedException();
	}

	public boolean checkTheWordVisible() {
		//단어가 다 살아지면 끝나는 
		int count = 0;
		for(JLabel each : words) {
			if(!each.isVisible()) {
				count++;
			}
		}
		
		return count == words.size() ? false : true; 
		
	}
}
