package Ch06;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C12GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;

	JTextField txt1;
	JTextArea area1;

	C12GUI(String title) {

		// Frame Setting
		super(title);
		setBounds(100, 100, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel Setting
		JPanel panel = new JPanel();
//		Color col = new Color(255,255,0);
//		panel.setBackground(col);
		panel.setLayout(null);

		// Component Setting
		area1 = new JTextArea();
//		area1.setBounds(10,90,210,300);
		JScrollPane scroll = new JScrollPane(area1);
		scroll.setBounds(10, 10, 200, 280);

		btn1 = new JButton("파일로저장");
		btn1.setBounds(230, 10, 120, 30);
		btn2 = new JButton("1:1 요청");
		btn2.setBounds(230, 50, 120, 30);
		btn3 = new JButton("대화기록보기");
		btn3.setBounds(230, 90, 120, 30);

		txt1 = new JTextField();
		txt1.setBounds(10, 300, 200, 30);
		btn4 = new JButton("입력");
		btn4.setBounds(230, 300, 120, 30);

		// Event 처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);

		txt1.addKeyListener(this);

		area1.addMouseListener(this);

		// Panel에 Component 추가
//		panel.add(area1);
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

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("버튼 클릭됨 : " + e.getSource());
		if (e.getSource() == btn1) {
			System.out.println("파일로 저장 버튼 클릭");

			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String contents = LocalDateTime.now().format(fmt).toString() + "\n";

			contents += area1.getText();

			// 파일탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일 저장 위치를 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			//
			File defaultDirPath = new File("C:\\IOTEST");
			if (defaultDirPath.exists())
				fileChooser.setCurrentDirectory(defaultDirPath);

			// 파일탐색기 활성화
			int selectedVal = fileChooser.showSaveDialog(null);

			if (selectedVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("저장 버튼 클릭");
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : " + selectedFile);

				// 확장자 추가
				String filePath = selectedFile.toString();
				if (!selectedFile.toString().endsWith(".txt")) {
					filePath += ".txt";
				}
				System.out.println("filePath : " + filePath);

				// 저장하기
				try (FileWriter file = new FileWriter("data.txt")) { // 파일을 열고 모두 사용되면 자동으로 닫아준다
					file.write(contents);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		} else if (e.getSource() == btn2) {
			System.out.println("1:1 요청 버튼 클릭");
		} else if (e.getSource() == btn3) {
			System.out.println("대화기록보기 버튼 클릭");

			// 파일탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("불러올 파일을 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setApproveButtonText("불러오기");

			//
			File defaultDirPath = new File("C:\\IOTEST");
			if (defaultDirPath.exists())
				fileChooser.setCurrentDirectory(defaultDirPath);

			// 파일탐색기 활성화
			int selectedVal = fileChooser.showSaveDialog(null);

			if (selectedVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("불러오기 버튼 클릭");

				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : " + selectedFile);

				Reader in = null;
				StringBuffer buffer = new StringBuffer();
				try {
					in = new FileReader(selectedFile);
					while (true) {
						int data = in.read();
						if (data == -1)
							break;
						buffer.append((char) data);
					}
					area1.setText(buffer.toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						in.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

		} else if (e.getSource() == btn4) {
			System.out.println("입력 버튼 클릭");
			String message = txt1.getText();
			area1.append(message + "\n");
			System.out.println("message : " + txt1.getText());
			txt1.setText("");
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// -
//		System.out.println("keyTyped...");
//		System.out.println("keyTyped..."+e.getKeyChar());
//		System.out.println("keyTyped..."+e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 누르는 동안
//		System.out.println("keyPressed..."+e.getKeyChar());
//		System.out.println("keyPressed..."+e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 뗏을 때
//		System.out.println("keyReleased...");
//		System.out.println("keyReleased..."+e.getKeyChar());
//		System.out.println("keyReleased..."+e.getKeyCode());

		if (e.getSource() == txt1) {
			if (e.getKeyChar() == 10) {
				String message = txt1.getText();
				area1.append(message + "\n");
				System.out.println("message : " + txt1.getText());
				txt1.setText("");
			}

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
//			System.out.println("mouseClicked..." + e);
			Point point = e.getPoint();
//			System.out.println("point : " + point);
			int offset = area1.viewToModel(point);
			System.out.println("offset : " + offset);
			int row = area1.getLineOfOffset(offset);
			System.out.println("row : " + row);
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
			System.out.printf("start : %d - end : %d\n", startOffset, endOffset);
			String str = area1.getText(startOffset, endOffset - startOffset);
			System.out.println("str : " + str);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

public class C12SwingEventMain {
	public static void main(String[] args) {
		new C12GUI("Chatting");
	}
}