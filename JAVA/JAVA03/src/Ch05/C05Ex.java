package Ch05;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class Chat extends JFrame {

	Chat(String title) {
		// Frame Setting
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel Setting
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// Component Setting
		JTextArea area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		scroll.setBounds(20,20,300,350);
		JButton btn1 = new JButton("파일로 저장");
		btn1.setBounds(330,20,135,50);
		JButton btn2 = new JButton("1 : 1 요청");
		btn2.setBounds(330,80,135,50);
		JButton btn3 = new JButton("대화기록보기");
		btn3.setBounds(330,140,135,50);
		JTextField txt1 = new JTextField();
		txt1.setBounds(20,385,300,50);
		JButton btn4 = new JButton("입력");
		btn4.setBounds(330,385,135,50);
		

		// Panel에 Component 추가
		panel.add(scroll);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(txt1);
		panel.add(btn4);
		// Frame에 Panel 추가
		add(panel);
		setVisible(true);
	}
}

public class C05Ex {

	public static void main(String[] args) {

		new Chat("Chatting Server");

	}

}
