package algorithm.Kakao;

import java.util.*;

/**
 * Created by jslee on 2018-09-15.
 */
public class Kakao_2018Q1 {
    public static void main(String[] args) {

        String[] testCase = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] result = solution(testCase);
        for(String s : result){
            System.out.println(s);
        }
    }

    public static String[] solution(String[] record){
        String[] answer = {};
        int size = record.length;
        String[] keyArr = new String[size];
        String[] idArr = new String[size];
        String[] nameArr = new String[size];
        Set<String> set = new HashSet<String>();
        int count = 0;

        for(int i = 0;i < size;i++){
            StringTokenizer st = new StringTokenizer(record[i]);

            String word = st.nextToken();
            keyArr[i] = word;

            String id = st.nextToken();
            set.add(id);
            idArr[i] = id;

            if(word.equals("Enter")){
                count++;
                String name = st.nextToken();
                nameArr[i] = name;
            }else if(word.equals("Leave")){
                nameArr[i] = "out";
                count++;
            }else{
                String name = st.nextToken();
                nameArr[i] = name;
            }
        }

        ArrayList<Map<String, String>> finalList = new ArrayList<Map<String, String>>();
        for(String s : set){
            Stack<String> stack = new Stack<String>();
            Map<String, String> map = new HashMap<String, String>();
            for(int i = 0;i < size;i++){
                if(s.equals(idArr[i])){
                    if(keyArr[i].equals("Enter") || keyArr[i].equals("Change")){
                        stack.push(nameArr[i]);
                    }
                }
            }
            map.put("ID",s);
            map.put("NAME",stack.pop());
            finalList.add(map);
        }

        answer = new String[count];

        for(int i = 0;i <finalList.size();i++){
            String id = finalList.get(i).get("ID");
            String name = finalList.get(i).get("NAME");

            for(int j = 0;j < size;j++){
                StringBuffer sb = new StringBuffer();
                if(idArr[j].equals(id) && !keyArr[j].equals("Change")){
                    sb.append(name);
                    if(keyArr[j].equals("Enter")){
                        sb.append("님이 들어왔습니다.");
                    }else if(keyArr[j].equals("Leave")){
                        sb.append("님이 나갔습니다.");
                    }
                    answer[j] = sb.toString();
                }
            }
        }
        return answer;
    }
}
