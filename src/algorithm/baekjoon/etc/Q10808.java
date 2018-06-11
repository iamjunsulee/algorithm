package algorithm.baekjoon.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * 알파벳 개수
 */
public class Q10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String inputs = br.readLine();
		int[] alphabet = new int[26];
		char[] ch = inputs.toCharArray();
		//알파벳 카운트 증가
		for(int i = 0;i < ch.length;i++) {
			alphabet[ch[i]-'a']++;
		}
		//출력
		for(int result : alphabet) {
			bw.write(result+" ");
		}
		br.close();
		bw.close();
	}
}
