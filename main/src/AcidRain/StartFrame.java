package AcidRain;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.com.show.GameChooseUI;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class StartFrame extends JFrame implements ActionListener {
   
   public static USER user = new USER();
      
   StartFrame SF;
   Signup SU = new Signup();
   private JPanel Mainpanel;
   private JButton Login, Newmember;
   private JLabel Gamename, name, id, pw;
   private JTextField idtext;
   private JPasswordField pwtext;
   
   
   
   String stid, stpw;

   GameChooseUI chosseUI = new GameChooseUI();

   public StartFrame() {

      setTitle("Sonagi");
      setSize(538, 546);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      
      
      Mainpanel = new JPanel() {
         public void paintComponent(Graphics g) {
            ImageIcon mainicon = new ImageIcon("./img/handheld.png");
            g.drawImage(mainicon.getImage(), 0, 0, null);
            
            
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      setContentPane(Mainpanel);
      
      Login = new JButton("");
      Login.setBounds(139, 403, 70, 73);
      
      Login.setBackground(UIManager.getColor("CheckBox.highlight"));
      Login.setContentAreaFilled(false);
      Login.setBorderPainted(false);
      Login.setIcon(new ImageIcon("./img/enter.png"));
      
      Newmember = new JButton("N");
      Newmember.setBounds(284, 403, 100, 73);
      ImageIcon signupicon = new ImageIcon("./img/newm.png");
      Newmember.setContentAreaFilled(false);
      Newmember.setBorderPainted(false);
      Newmember.setIcon(signupicon);
      Gamename = new JLabel("MiniGame");
      Gamename.setBounds(175, 35, 162, 73);
      Gamename.setHorizontalAlignment(SwingConstants.CENTER);
      id = new JLabel("ID");
      id.setBounds(175, 118, 100, 20);
      pw = new JLabel("PW");
      pw.setBounds(175, 141, 100, 20);

      idtext = new JTextField();
      idtext.setBounds(203, 118, 134, 20);
      pwtext = new JPasswordField();
      pwtext.setBounds(203, 144, 134, 20);

      idtext.setText("");
      pwtext.setText("");
      pwtext.setEchoChar('*');

      Gamename.setFont(new Font("Tahoma", Font.PLAIN, 30));
      id.setFont(new Font("±¼¸²", Font.BOLD, 15));
      pw.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      Mainpanel.setLayout(null);

      Mainpanel.add(Login);
      Mainpanel.add(Newmember);

      Mainpanel.add(Gamename);
      Mainpanel.add(id);
      Mainpanel.add(pw);

      Mainpanel.add(idtext);
      Mainpanel.add(pwtext);

      Login.addActionListener(this);
      Newmember.addActionListener(this);
      setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      
      if (e.getActionCommand() == "") {

         stid = idtext.getText();
         stpw = pwtext.getText();

         WarningDialog wd = new WarningDialog();

         DataBase database = new DataBase();

         if (stid.length() == 0 || stpw.length() == 0) {
            wd.Logindialog();
         }

         else {
            if (database.Loginselect(stid, stpw) == 1) {
               dispose();
               
               user.setUSER_ID(stid);
               
               chosseUI.showUI();
               // GF.setVisible(true);
            }

            else if (database.Loginselect(stid, stpw) == -1) {
               wd.PWdialog();
               idtext.setText("");
               pwtext.setText("");
            }

            else {
               wd.IDdialog();
               idtext.setText("");
               pwtext.setText("");
            }
         }

      }

      else if (e.getActionCommand() == "N") {
         SU.setVisible(true);
      }
   }
}