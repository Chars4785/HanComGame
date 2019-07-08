package main.com.show;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.com.game.RainGame;

public class RainGameUIPanel extends GameUI implements ActionListener {

	static String backGround = "background1";
	int gameTime = 240;
	
	public RainGameUIPanel() {
		super(backGround);
		super.showUI(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			GameChooseUI.mainFrame.remove(super.mainUIPanel);
			new RainGame(gameTime);
		}

		if (e.getSource() == lowButton) {
			lowButton.setIcon(lowIconClick);
			midButton.setIcon(midIcon);
			highButton.setIcon(highIcon);
			gameTime = 240;
		}

		if (e.getSource() == midButton) {
			lowButton.setIcon(lowIcon);
			midButton.setIcon(midIconClick);			
			highButton.setIcon(highIcon);
			gameTime = 120;
		}

		if (e.getSource() == highButton) {
			lowButton.setIcon(lowIcon);
			midButton.setIcon(midIcon);
			highButton.setIcon(highIconClick);
			gameTime = 60;
		}

	}
}
