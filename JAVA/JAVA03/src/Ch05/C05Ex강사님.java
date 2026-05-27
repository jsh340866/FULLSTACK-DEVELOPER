package Ch05;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C05GUI extends JFrame
{
	C05GUI(String title){
		
		//Frame Setting
		super(title);
		setBounds(100,100,400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		//Panel Setting
		JPanel panel = new JPanel();
//		Color col = new Color(255,255,0);
//		panel.setBackground(col);
		panel.setLayout(null);
		
		
		//Component Setting
		JTextArea area1 = new JTextArea(); 
//		area1.setBounds(10,90,210,300);
		JScrollPane scroll = new JScrollPane(area1);
		scroll.setBounds(10,10,200,280);
		
		JButton btn1 = new JButton("파일로저장");
		btn1.setBounds(230,10,120,30);
		JButton btn2 = new JButton("1:1 요청");
		btn2.setBounds(230,50,120,30);
		JButton btn3 = new JButton("대화기록보기");
		btn3.setBounds(230,90,120,30);
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,300,200,30);
		JButton btn4 = new JButton("입력");
		btn4.setBounds(230,300,120,30);
		
		//Panel에 Component 추가
//		panel.add(area1);
		panel.add(scroll);
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		
		panel.add(txt1);
		panel.add(btn4);

		
		//Frame에 Panel 추가 
		add(panel);	
		
		setVisible(true);
		
	}
	
}
public class C05Ex강사님 {
	public static void main(String[] args) {
		new C05GUI("Chatting");
	}
}
