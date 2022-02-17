package algorithm.Baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ù° �ٿ� ���� ���� N(1 �� N �� 10,000,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���ڰ� �־�����. �� ���� 10,000���� �۰ų� ���� �ڿ����̴�.
 * ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
 * 
 * <�����ذ����> �ð����� : 5��, �޸����� : 8MB
 * 1. sorting algorithm �߿� ���� ���� �� ������ ����غ�������, �ð��ʰ�.
 * 2. pivot ��ġ�� ���� �ð� �ʰ��ΰ��ؼ� pivot ��ġ�� �ٲ㰡�� �غ����� ������ �ð��ʰ� Ȥ�� ������� ����� ������ �ʾҴ�.
 * 3. sorting algorithm���� �����ϴ� ������ �ƴѰŰ��ٴ� ����� ���ȴ�.
 * 4. 10
	   5
	   2
	   3
	   1
	   4
	   2
	   3
	   5
	   1
	   7
 * �� �Է¹޴� ������ ���ٷ� �Է��� �޴��� �ǹ��� �����, scanner�� ��� ������� �����ٴ� ��ǰ� BufferedReader�� �ٴ����� �Է��� �޴´ٴ� ���� ��������.
 * �׷��� ����� ��ĺ��� ����
 * 5. ���⼭ ������ �ٽ� ����. �������� ������ ���� 1 ~ 10,000,000 �ε����� ������ ũ��� 10,000�� ����� �ʴ´ٰ� �Ѵ�. �� ���� 10,000���� �۰ų� ���� ���� �ݺ��ȴٴ� ��.
 * 6. �迭�� 0���� �ε����� ���۵ǹǷ� ��ü ����� 10,001�� ���ϰ�, �Է¹޴� ������ ������ �迭�� �����Ѵ�.
 * 7. ������ 0�� �ƴ϶�� �� ������ŭ ���ڸ� ������ָ� �ȴ�. 
 */
public class q10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//Scanner sc = new Scanner(System.in);
		//int size = sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());
		int[] count = new int[10001];

		for(int i=0;i<size;i++) {
			count[Integer.parseInt(br.readLine())]++;
		}

		for(int i=1;i<=10000;i++) {
			if(count[i]>0) {
				for(int j=0;j<count[i];j++) {
					bw.write(i+"\n");
				}
			}
		}
		br.close();
		bw.close();
	}
}
