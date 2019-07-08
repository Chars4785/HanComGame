package AcidRain;

import javax.swing.JOptionPane;

public class WarningDialog extends JOptionPane {
	
	public void Warningdialog() {
		showMessageDialog(null, "모든 빈칸을 채워주십시오.");
	}

	public void PWdialog() {
		showMessageDialog(null, "비밀번호가 틀렸습니다.");
	}

	public void IDdialog() {
		showMessageDialog(null, "ID가 없습니다.");
	}
	
	public void Logindialog()
	{
		showMessageDialog(null, "ID와 비밀번호 둘 다 입력해주세요");
	}
	
	public void PWnotequaltdialog()
	{
		showMessageDialog(null, "비밀번호가 같지 않습니다.");
	}
	
	public void Welcomedialog(String name)
	{
		showMessageDialog(null, name+" 님 즐거운 하루 되세요!");
	}

}