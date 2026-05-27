package Ch07;

interface Remocon {
	
	void powerOn();		//추상 메서드
	void powerOff();	//추상 메서드
	
	int MAX_VOL = 100;	//public static final
	int MIN_VOL = 0;	//public static final
	void setVolumn(int vol);
}

interface Browser {
	void searchURL(String url);
}


class Tv implements Remocon {

	private int volumn;
	
	@Override
	public void powerOn() {
		System.out.println("Tv를 켭니다");
	}

	@Override
	public void powerOff() {
		System.out.println("Tv를 끕니다");
	}

	@Override
	public void setVolumn(int vol) {
		if(MAX_VOL < vol) {
			this.volumn = MAX_VOL;
		}
		else if(MIN_VOL > vol) {
			this.volumn = MIN_VOL;
		}else this.volumn = vol;
		System.out.println("TV 현재 볼륨 : " + this.volumn);
	}
	
}

class SmartTv extends Tv implements Browser{

	@Override
	public void searchURL(String url) {
		System.out.println(url + " 로 이동합니다.");
		
	}
	
}


class Radio implements Remocon  {

	private int volumn;
	
	@Override
	public void powerOn() {
		System.out.println("Radio를 켭니다");
	}

	@Override
	public void powerOff() {
		System.out.println("Radio를 끕니다");
	}

	@Override
	public void setVolumn(int vol) {
		if(MAX_VOL < vol) {
			this.volumn = MAX_VOL;
		}
		else if(MIN_VOL > vol) {
			this.volumn = MIN_VOL;
		}else this.volumn = vol;
		System.out.println("Radio 현재 볼륨 : " + this.volumn);
	}
	
}

public class C03InterfaceMain {
	
	public static void TurnOn(Remocon remocon) { // Remocon remocon = tv
												 // Remocon remocon = radio
		remocon.powerOn();
	}

	public static void TurnOff(Remocon remocon) {
		remocon.powerOff();
	}
	public static void ChangeVolumn(Remocon remocon, int vol) {
		remocon.setVolumn(vol);
	}
	
	public static void WebBrowser(Browser browser, String url) {
		browser.searchURL(url);
		
	}
	
	public static void main(String[] args) {
		
		Tv tv = new Tv();
		Radio radio = new Radio();
		SmartTv smartTv = new SmartTv();
		
		//ON
		TurnOn(tv);
		TurnOn(radio);
		TurnOn(smartTv);
		
		//VOLUMN
		ChangeVolumn(tv,50);
		ChangeVolumn(radio,200);
		ChangeVolumn(smartTv, 30);
		
		//Browser
		WebBrowser(smartTv, "https://exam_all");
		
		//OFF
		TurnOff(tv);
		TurnOff(radio);
		TurnOff(smartTv);
	}

}
