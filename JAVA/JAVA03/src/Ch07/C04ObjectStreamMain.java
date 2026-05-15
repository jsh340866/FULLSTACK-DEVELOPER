package Ch07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

class Board implements Serializable {	//Serializable 중요 // 직렬화
	
	
	private static final long serialVersionUID = 1L; //serialVersionUID = 1 중요 //클래스가 수정 되어도 UID로 찾을 수 있음
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date date;		//java.util.Date

	//디폴트생성자
	public Board() {
		super();
	}
	
	//모든인자생성자
	public Board(int bno, String title, String content, String writer, Date date) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}
	
	//getter and setter
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	//toString 재정의
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", date="
				+ date + "]";
	}
	
	
}

public class C04ObjectStreamMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		Board board1 = new Board(1,"제목1","내용1","작성자1",new Date());
//		Board board2 = new Board(2,"제목2","내용2","작성자2",new Date());
//		Board board3 = new Board(3,"제목3","내용3","작성자3",new Date());
//		
//		FileOutputStream out = new FileOutputStream("C:\\IOTEST\\board.db");
//		ObjectOutputStream oout = new ObjectOutputStream(out);
//		oout.writeObject(board1);
//		oout.writeObject(board2);
//		oout.writeObject(board3);
//		oout.flush();
//		oout.close();
//		out.close();
		
		FileInputStream in = new FileInputStream("C:\\IOTEST\\board.db");
		ObjectInputStream oin = new ObjectInputStream(in);
		
		Object obj = oin.readObject();
		Board down = (Board)obj;
		System.out.println(down);
		
		Object obj2 = oin.readObject();
		Board down2 = (Board)obj2;
		System.out.println(down);
		
		Object obj3 = oin.readObject();
		Board down3 = (Board)obj3;
		System.out.println(down);
		
		// 더이상 읽어올 OBJECT가 없으면 java.io.EOFException 예외발생(예외처리 후 RuntimeError해결)
		Object obj4 = oin.readObject();
		
		oin.close();
		in.close();
		
		
		
	}
}
