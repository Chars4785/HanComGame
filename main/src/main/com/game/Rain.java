package main.com.game;

import java.util.LinkedList;

import javax.swing.JLabel;

public class Rain extends Thread {

	CheckTheGameEnd playTime;
	LinkedList<JLabel> words;
	LinkedList<Integer> randomMove;

	public Rain(CheckTheGameEnd total_play_time, LinkedList<JLabel> words, LinkedList<Integer> randomMove) {
		playTime = total_play_time;
		this.words = words;
		this.randomMove = randomMove;
	}

	public void moveWord() {
		try {

			for (int i = 0; i < words.size(); i++) {
				words.get(i).setLocation(words.get(i).getX(), words.get(i).getY() + randomMove.get(i));
				wordcheckTheDeadLine(i);
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void wordcheckTheDeadLine(int index) {
		if (words.get(index).getY() > 480 && words.get(index).isVisible()) {
			words.get(index).setVisible(false);

			if (RainGame.lifeMark.isEmpty()) {
				
				playTime.interrupt();
			}
			RainGame.lifeMark.poll().setVisible(false);
		}
	}
	

	public void run() {
		while (CheckTheGameEnd.gamePlayTime > 0) {
			moveWord();
		}
	}


}
