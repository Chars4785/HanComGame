package AcidRain;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.CardLayout;

public class Signup extends JFrame implements ActionListener {

	JPanel signuppanel;
	JLabel t;
	String User_ID;
	String User_name;
	String User_PW;
	String PW_Correct;
	private JTextField textField;
	private JPasswordField textField_1, textField_3;
	private JTextField textField_2;

	public Signup() {
		setTitle("signup");
		setBounds(500, 300, 300, 300);
		
		signuppanel = new JPanel() {
	          public void paintComponent(Graphics g) {
	             ImageIcon mainicon = new ImageIcon("./img/signupbackground.png");
	             g.drawImage(mainicon.getImage(), 0, 0, null);
	             
	             
	             setOpaque(false);
	             super.paintComponent(g);
	          }
	       };
		setContentPane(signuppanel);
		signuppanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(50, 40, 57, 15);
		signuppanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PW");
		lblNewLabel_2.setBounds(50, 80, 57, 15);
		signuppanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC774\uB984");
		lblNewLabel_3.setBounds(50, 160, 57, 15);
		signuppanel.add(lblNewLabel_3);

		JLabel lblPw = new JLabel("PW\uD655\uC778");
		lblPw.setBounds(50, 120, 57, 15);
		signuppanel.add(lblPw);

		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.setBounds(93, 199, 97, 23);
		signuppanel.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(156, 37, 116, 21);
		signuppanel.add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField();
		textField_1.setBounds(156, 77, 116, 21);
		textField_1.setEchoChar('*');
		signuppanel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(156, 157, 116, 21);
		signuppanel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JPasswordField();
		textField_3.setColumns(10);
		textField_3.setBounds(156, 117, 116, 21);
		textField_3.setEchoChar('*');
		signuppanel.add(textField_3);

		btnNewButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		WarningDialog WD = new WarningDialog();

		if (e.getActionCommand() == "회원가입") {
			User_ID = textField.getText();
			User_PW = textField_1.getText();
			User_name = textField_2.getText();
			PW_Correct = textField_3.getText();

			if (User_ID.length() == 0) {
				WD.Warningdialog();
			}

			else if (User_PW.length() == 0) {
				WD.Warningdialog();
			}

			else if (User_name.length() == 0) {
				WD.Warningdialog();
			}

			else if (!User_PW.equals(PW_Correct)) {
				WD.PWnotequaltdialog();
			}

			else {

				DataBase database = new DataBase();

				if (database.UserInsert(User_ID, User_PW, User_name) == 1) {
					database.ScoreInsert(User_ID);
				}

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				this.setVisible(false);
			}

		}

	}

}
