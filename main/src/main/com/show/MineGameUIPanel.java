package main.com.show;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.com.game.MineGame;

public class MineGameUIPanel extends GameUI implements ActionListener {

	static String backGround = "mine" ;
	int gameTime = 120;
	
	public MineGameUIPanel() {
		super(backGround);
		super.showUI(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			GameChooseUI.mainFrame.remove(super.mainUIPanel);
			new MineGame(gameTime);
		}

		if (e.getSource() == lowButton) {
			lowButton.setIcon(lowIconClick);
			midButton.setIcon(midIcon);
			highButton.setIcon(highIcon);
			gameTime = 120;
		}

		if (e.getSource() == midButton) {
			lowButton.setIcon(lowIcon);
			midButton.setIcon(midIconClick);			
			highButton.setIcon(highIcon);
			gameTime = 60;
		}

		if (e.getSource() == highButton) {
			lowButton.setIcon(lowIcon);
			midButton.setIcon(midIcon);
			highButton.setIcon(highIconClick);
			gameTime = 30;
		}

	}
}
