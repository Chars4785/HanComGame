package main.com.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.com.show.GameChooseUI;

public class MineGame implements KeyListener {

	LinkedList<JLabel> words;
	CheckTheGameEnd total_play_time; // 전체 플레이타임

	JPanel minePanel;
	JTextField inputText; // 입력용
	int gameTime;

	Word word_create; // 단어들을 가지고올 때 사용
	ImageIcon icon;

	public MineGame(int gameTime) {
		this.gameTime = gameTime;
		
		words = new LinkedList<JLabel>();
		word_create = new Word();
		inputText = new JTextField(2);
		icon = new ImageIcon("img/backgroundMine.png");

		total_play_time = new CheckTheGameEnd(this.gameTime, this.words);
		
		minePanel = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(icon.getImage(), 0, 0, null);

				setOpaque(false);
				super.paintComponent(g);
			}
		};

		inputText.addKeyListener(this);
		inputText.setBounds(360, 490, 90, 30);
		inputText.setOpaque(false);
		inputText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		inputText.setForeground(Color.WHITE);

		for (int i = 0; i < word_create.words.size(); i++) {
			JLabel tmp = new JLabel(word_create.words.get(i));

			tmp.setFont(new Font("굴림", Font.BOLD, 12));
			tmp.setForeground(Color.WHITE);

			// 단어 9,18,27 갯수가 들어오는데 각각 위치 선정
			if (i <= 9) {
				tmp.setBounds(i + 200, i * 40 + 50, 80, 20);
			}
			if (9 < i && i <= 18) {
				tmp.setBounds(i + 350, (i % 9) * 40 + 50, 80, 20);
			}
			if (18 < i) {
				tmp.setBounds(i + 500, (i % 9) * 40 + 50, 80, 20);
			}

			words.add(tmp);
			minePanel.add(words.get(i));
		}
		
		total_play_time.playTime.setBounds(390, 0, 200, 50);
		total_play_time.playTime.setFont(new Font("Dialog", Font.BOLD, 30));

		minePanel.add(total_play_time.playTime);
		minePanel.add(inputText);
		minePanel.setLayout(null);

		GameChooseUI.mainFrame.getContentPane().add(minePanel, BorderLayout.CENTER);
		GameChooseUI.mainFrame.add(minePanel);
		GameChooseUI.mainFrame.setVisible(true);

		total_play_time.start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String noSpaceInputText = "";

		if (e.getKeyCode() == e.VK_ENTER) {
			noSpaceInputText = inputText.getText().trim();

			for (int i = 0; i < words.size(); i++) {

				if (noSpaceInputText.equals(words.get(i).getText())) {
					words.get(i).setVisible(false);
					words.remove(i);
					GameChooseUI.GAMESCORE++;
				}
			}

			inputText.setText("");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
