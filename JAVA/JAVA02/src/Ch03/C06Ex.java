package Ch03;

import java.util.Arrays;
import java.util.Scanner;

class Student {
	int kor;
	int eng;
	int math;

	@Override

	public String toString() {
		return "Student [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}

	public Student(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Student() {
		super();
	}

	double Avg() {
		return (double) (kor + eng + math) / 3;
	}

	int sum() {
		return (kor + eng + math);
	}

}

public class C06Ex {

	public static void main(String[] args) {
		// 5개의 정수값을 입력받아 int형 배열에 저장하고
		// 최댓값, 최솟값, 전체합을 출력합니다.
//		Scanner sc = new Scanner(System.in);
//		int arr[] = new int[5]; 
////		arr[0] = sc.nextInt(); 
////		arr[1] = sc.nextInt(); 
////		arr[2] = sc.nextInt(); 
////		arr[3] = sc.nextInt(); 
////		arr[4] = sc.nextInt();
//		for (int i =0; i<arr.length;i++) {
//			arr[i] = sc.nextInt();
//		}
//		int max = arr[0];
//		int min = arr[0];
//		for (int el : arr) {
//			if(max < el) {
//				max = el;
//				
//			}
//			else if (el < min) {
//				min = el;
//			}
//		}
//		System.out.println(Arrays.stream(arr).sum());
//		System.out.println("max : " + Arrays.stream(arr).max().getAsInt());
//		System.out.println("min : " + Arrays.stream(arr).min().getAsInt());
//		System.out.println("max : " + max);
//		System.out.println("min : " + min);
//		sc.close();

		// 5 명의 학생에 국영수점수를 입력받아 2차원배열 저장
		// 각 학생의 국영수 점수의 합/평균 구하고
		// 각 과목당 합/평균 구해보세요
//		Scanner sc = new Scanner(System.in);
//		Student st1 = new Student(sc.nextInt(),sc.nextInt(),sc.nextInt());
//		Student st2 = new Student(sc.nextInt(),sc.nextInt(),sc.nextInt());
//		Student st3 = new Student(sc.nextInt(),sc.nextInt(),sc.nextInt());
//		Student st4 = new Student(sc.nextInt(),sc.nextInt(),sc.nextInt());
//		Student st5 = new Student(sc.nextInt(),sc.nextInt(),sc.nextInt());
//		
//		int arr[][] = {
//				{st1.kor,st1.eng,st1.math},
//				{st2.kor,st2.eng,st2.math},
//				{st3.kor,st3.eng,st3.math},
//				{st4.kor,st4.eng,st4.math},
//				{st5.kor,st5.eng,st5.math}
//		};
//		
//		
//		
//		
//		System.out.println("st1 학생의 국영수 합 : " + st1.sum() + "\n각 학생의 국영수 평균 :" +  st1.Avg());
//		System.out.println("st2 학생의 국영수 합 : " + st2.sum() + "\n각 학생의 국영수 평균 :" +  st2.Avg());
//		System.out.println("st3 학생의 국영수 합 : " + st3.sum() + "\n각 학생의 국영수 평균 :" +  st3.Avg());
//		System.out.println("st4 학생의 국영수 합 : " + st4.sum() + "\n각 학생의 국영수 평균 :" +  st4.Avg());
//		System.out.println("st5 학생의 국영수 합 : " + st5.sum() + "\n각 학생의 국영수 평균 :" +  st5.Avg());
//		
//		int sumKor = 0;
//		int sumEng = 0;
//		int sumMath = 0;
//		for (int i = 0; i < arr.length;i++) {
//			sumKor += arr[i][0];
//			sumEng += arr[i][1];
//			sumMath += arr[i][2];
//		}
//		System.out.println("학생들의 각 과목별 합 : " + sumKor + " " + sumEng + " " + sumMath);
//		System.out.println("학생들의 각 과목별 평균 : " + sumKor/5 + " " + sumEng/5 + " " + sumMath/5);
//		sc.close();

		Scanner sc = new Scanner(System.in);
		int[][] scores = new int[5][3]; // 행(0~4) 학생, 열(0~2) 국(0)영(1)수(2)

		// 입력
		for (int i = 0; i < scores.length; i++) {
			// 각 학생별 반복
			System.out.printf("%d 번째 학생 국영수 점수 입력 : ", i + 1);
			for (int j = 0; j < scores[i].length; j++) {
				// 학생들의 국영수 점수
				scores[i][j] = sc.nextInt();
			}
		}

		// 학생별 총점 평균
		int students_sum[] = new int[5]; // 0-4
		double students_avg[] = new double[5]; // 0-4
		for (int i = 0; i < scores.length; i++) {
			int sum = 0;
			double avg = 0.0;
			for (int j = 0; j < scores[i].length; j++) {
				sum += scores[i][j];
			}
			avg = (double) sum / scores.length;

			students_sum[i] = sum;
			students_avg[i] = avg;
		}
		// 과목별 총점 평균
		int 과목별총점[] = new int[3]; //0 국어총점, 1 영어총점, 2 수학총점
		for (int i = 0; i < scores.length; i++) {
			과목별총점[0] += scores[i][0];
			과목별총점[1] += scores[i][1];
			과목별총점[2] += scores[i][2];
			
		}
		System.out.println(과목별총점[0] + 과목별총점[1] + 과목별총점[2]);

		sc.close();

	}

}
