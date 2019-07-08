package main.com.show;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import AcidRain.StartFrame;

public class GameChooseUI implements ActionListener {

	static final int BUTTON_SIZE = 200;
	public static JFrame mainFrame;
	public static int GAMESCORE = 0;
	public static int whatgame =0;

	JPanel controlPanel;
	JButton rainGameButton;
	JButton harvestingGameButton;

	public GameChooseUI() {
		mainFrame = new JFrame();
		
		rainGameButton = new JButton("Rain");
		harvestingGameButton = new JButton("Mine");
	}

	public void showUI() {
		
		controlPanel = new JPanel() {
		         public void paintComponent(Graphics g) {
		            ImageIcon mainicon = new ImageIcon("./img/ChooseGameUI_01.png");
		                        
		            g.drawImage(mainicon.getImage(), 0,0,560,400, null);
		            
		            setOpaque(false);
		            super.paintComponent(g);
		         }
		      };
		      controlPanel.setBounds(0, 1, 557, 359);
		      
		      
		mainFrame.setBounds(100, 100, 560, 400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);
		
		//rainGameButton.setBounds(101, 150, BUTTON_SIZE, BUTTON_SIZE);
		
		rainGameButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		rainGameButton.setBounds(182, 140, 100, 108);
		rainGameButton.setContentAreaFilled(false);
		rainGameButton.setBorderPainted(false);

		
		//harvestingGameButton.setBounds(451, 150, BUTTON_SIZE, BUTTON_SIZE);
		
		harvestingGameButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		harvestingGameButton.setContentAreaFilled(false);
		harvestingGameButton.setBorderPainted(false);
		harvestingGameButton.setBounds(298, 140, 100, 108);
		
		rainGameButton.addActionListener(this);		
		harvestingGameButton.addActionListener(this);
		
		
		controlPanel.setLayout(null);
		controlPanel.add(rainGameButton);
		controlPanel.add(harvestingGameButton);

		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		mainFrame.remove(controlPanel);

		if (e.getSource() == rainGameButton) {
			mainFrame.setBounds(100, 100, 800, 600);
			StartFrame.user.setWhichGame(1);
			new RainGameUIPanel();
		}

		if (e.getSource() == harvestingGameButton) {
			mainFrame.setBounds(100, 100, 800, 600);
			StartFrame.user.setWhichGame(2);
			new MineGameUIPanel();
		}

	}

}
