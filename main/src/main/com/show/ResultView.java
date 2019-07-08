package main.com.show;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import AcidRain.DataBase;
import AcidRain.StartFrame;

public class ResultView implements ActionListener {

   JFrame frame;
   JPanel panel, panel_1;
   JButton endButton, reStartButton, btnNewButton, button;
   JLabel lblNewLabel, scoreLabel, nameLabel;
   private JLabel lblNewLabel_1;
   int score, wordCount;
   private JTable table;
   Vector<Vector<String>> vc = new Vector<Vector<String>>();

   Vector<String> userColumn = new Vector<String>();
   Vector<String> userRow = new Vector<String>();
   DefaultTableModel model = new DefaultTableModel();
   private JTable table_1;

   DataBase database = new DataBase();
   
   public ResultView(int score, int wordCount)  {
      

     

      this.score = score;
      this.wordCount = wordCount;
      
      frame = new JFrame();
      frame.setBackground(Color.black); //
      panel = new JPanel();
      panel_1 = new JPanel();
      panel_1.setForeground(Color.BLACK);
      lblNewLabel = new JLabel();
      endButton = new JButton("END");
      endButton.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 12));
      endButton.setForeground(Color.WHITE);
      endButton.setBackground(Color.DARK_GRAY);
      reStartButton = new JButton("RESTART");
      reStartButton.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 12));
      reStartButton.setBackground(Color.DARK_GRAY);
      reStartButton.setForeground(Color.WHITE);
      lblNewLabel_1 = new JLabel("GAME RESULT");
      lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 20));
      lblNewLabel_1.setForeground(Color.WHITE);
      scoreLabel = new JLabel();
      scoreLabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 12));
      scoreLabel.setForeground(Color.WHITE);
      nameLabel = new JLabel(StartFrame.user.getUSER_ID());
      nameLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD | Font.ITALIC, 12));
      nameLabel.setForeground(Color.WHITE);

      frame.setBounds(100, 100, 500, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel, BorderLayout.CENTER);
      panel.setLayout(null);

      panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
      panel_1.setBounds(12, 10, 460, 242);
      panel_1.setBackground(Color.BLACK);//
      panel.add(panel_1);
      panel_1.setLayout(null);

      endButton.setBounds(297, 151, 100, 57);
      endButton.addActionListener(this);
     
      panel_1.add(endButton);

      reStartButton.setBounds(297, 35, 100, 57);
      reStartButton.addActionListener(this);
      panel_1.add(reStartButton);

      lblNewLabel_1.setBounds(163, 10, 138, 24);
      panel_1.add(lblNewLabel_1);

      JPanel panel_2 = new JPanel();
      panel_2.setBackground(Color.BLACK);
      panel_2.setForeground(Color.WHITE);
      panel_2.setBounds(60, 35, 178, 173);
      panel_1.add(panel_2);
      panel_2.setLayout(null);

//      JLabel namein = new JLabel("\uC774\uB984");
      JLabel namein = new JLabel("NAME");
      namein.setForeground(Color.WHITE);
      namein.setBounds(23, 35, 57, 15);
      namein.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 12));//
      
      panel_2.add(namein);

//      JLabel scorein = new JLabel("\uC810\uC218");
      JLabel scorein = new JLabel("RESULT");
      scorein.setForeground(Color.WHITE);
      scorein.setBounds(23, 66, 57, 15);
      scorein.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 12));//
      panel_2.add(scorein);

      nameLabel.setBounds(78, 35, 57, 15);
      panel_2.add(nameLabel);

      score = checkTheFinishedGame(score);

      scoreLabel.setText(Integer.toString(score));
      scoreLabel.setBounds(78, 67, 57, 15);
      panel_2.add(scoreLabel);
      
      database.InsertScore(StartFrame.user.getUSER_ID(), Integer.toString(score), StartFrame.user.getWhichGame());

      String[][] ColumnName = { { "ID", "NAME", "RAINSCR", "MINESCR", "TotalSCR" }, };
      String[] Name = { "ID", "NAME", "RAINSCR", "MINESCR", "TotalSCR" };

      model = new DefaultTableModel(ColumnName, Name);
      
      table = new JTable();
      table.setFont(new Font("¸¼Àº °íµñ", Font.BOLD | Font.ITALIC, 12));
      
      vc = database.View();
      for(int i=0;i<vc.size();i++)
         model.addRow(vc.get(i));
      
      table.setModel(model);
      panel.add(table);
      table.setBounds(12, 278, 460, 174);
      table.setVisible(true);
      
      frame.getContentPane().add(panel);
      frame.setVisible(true);
      GameChooseUI.mainFrame.setVisible(false);
   }

   public int checkTheFinishedGame(int score) {
      return wordCount > 0 ? 0 : score;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == endButton) {
         System.exit(0);
      }

      if (e.getSource() == reStartButton) {
         GameChooseUI.mainFrame.dispose();
         GameChooseUI.GAMESCORE = 0;
         new GameChooseUI().showUI();

      }
   }

}