package main.com.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.com.show.GameChooseUI;

public class RainGame implements KeyListener {
	public static Queue<JLabel> lifeMark = new LinkedList<JLabel>();

	static final int HEART_SIZE = 3;

	LinkedList<JLabel> words;
	LinkedList<Integer> randomMove;
	CheckTheGameEnd total_play_time; // 전체 플레이타임
	int gameTime;
	static ImageIcon icon, lifeIcon;
	JPanel rainPanel;
	JTextField inputText;
	Word word_creat;
	Rain rain;
	JLabel eachHeart;

	public RainGame(int gameTime) {
		this.gameTime = gameTime;

		words = new LinkedList<>();
		randomMove = new LinkedList<Integer>();
		word_creat = new Word();
		icon = new ImageIcon("img/background.png");
		lifeIcon = new ImageIcon("img/life3.png");
		inputText = new JTextField(2);

		total_play_time = new CheckTheGameEnd(this.gameTime, words);
		rain = new Rain(total_play_time, words, randomMove);

		rainPanel = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(icon.getImage(), 0, 0, null);

				setOpaque(false);
				super.paintComponent(g);
			}
		};

		inputText.addKeyListener(this);
		inputText.setBounds(357, 495, 95, 35);
		inputText.setOpaque(false);
		inputText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		inputText.setForeground(Color.white);

		total_play_time.playTime.setBounds(390, 0, 200, 50);
		total_play_time.playTime.setFont(new Font("Dialog", Font.BOLD, 30));
		total_play_time.playTime.setForeground(Color.white);

		rainPanel.add(inputText);
		rainPanel.add(total_play_time.playTime);
		rainPanel.setLayout(null);

		GameChooseUI.mainFrame.getContentPane().add(rainPanel, BorderLayout.CENTER);
		GameChooseUI.mainFrame.add(rainPanel);
		GameChooseUI.mainFrame.setVisible(true);

		makeHeartUI();
		setWordPosition();
		total_play_time.start();
		rain.start();

	}

	public void setWordPosition() {
		JLabel tempLabel;

		for (int i = 0; i < word_creat.words.size(); i++) {
			tempLabel = new JLabel(word_creat.words.get(i));

			tempLabel.setFont(new Font("Times", Font.BOLD, 12));
			tempLabel.setForeground(Color.WHITE);
			tempLabel.setBounds((int) (Math.random() * 700) + 50, -10, 150, 20);
			tempLabel.setVisible(true);

			words.add(tempLabel);
			randomMove.add((int) (Math.random() * 20) + 1);
			rainPanel.add(words.get(i));
		}
	}

	public void makeHeartUI() {
		JLabel eachHeart;

		for (int i = 0; i < HEART_SIZE; i++) {
			eachHeart = new JLabel(lifeIcon);
			eachHeart.setBounds((i * 80), 490, 80, 80);
			eachHeart.setOpaque(false);
			eachHeart.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			lifeMark.add(eachHeart);
			rainPanel.add(eachHeart);
		}

	}

	public void inputTextCompareWords() {
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getText().equals(inputText.getText())) {
				words.get(i).setVisible(false);
				GameChooseUI.GAMESCORE++;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_ENTER) {
			inputTextCompareWords();
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
