package algorithm.hackerrank.stringSolution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSolution {
    public static void main(String[] args) {
//        System.out.println(superReducedString("aaabccddd"));
//        System.out.println(minimumNumber(7, "AUzs-nV"));
//        System.out.println(palindromeIndex("aaa"));
//        System.out.println(makingAnagrams("cde", "abc"));
//        System.out.println(twoStrings("hackerrankcommunity", "cdecdecdecde"));
//        System.out.println(caesarCipher("Hello_World!", 4));
//        System.out.println(marsExploration("SOSOOSOSOSOSOSSOSOSOSOSOSOS"));
//        System.out.println(hackerrankInString("hereiamstackerrank"));
//        separateNumbers("100101103");
//        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
//        System.out.println(funnyString("acxz"));
//        int[] arr = new int[]{1,2,3,4,5};
//        miniMaxSum(arr);
//        System.out.println(beautifulBinaryString("0101000010011100111110011000001000100101100010000011010111111101110110001110111110110101001011"));
//        System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
//        System.out.println(anagram("xaxbbbxx"));
//        System.out.println(alternatingCharacters("ABABABAB"));
//        int[] a = {1, 3, 12, 5, 9, 10};
//        String[] strings = weightedUniformStrings("abccddde", a);
//        for(String s : strings){
//            System.out.println(s);
//        }
//        System.out.println(highestValuePalindrome("3943", 4, 4));
        System.out.println(sherlockAndAnagrams("cdcd"));
    }

    private static String superReducedString(String s) {
        String result;
        char[] inputs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char input : inputs) {
            if (stack.empty()) {
                stack.push(input);
            } else {
                if (input == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(input);
                }
            }
        }
        if(stack.empty()){
            result = "Empty String";
        }else {
            StringBuilder sb = new StringBuilder();
            while (!stack.empty()) {
                sb.append(stack.pop());
            }
            result = sb.reverse().toString();
        }
        return result;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        //오른족 대각선, 왼쪽 대각선의 차이 구하기
        int left = 0, right = 0;
        for(int i = 0;i < arr.size();i++){
            List<Integer> list = arr.get(i);
            //대각선 합
            right += list.get(i);
            left += list.get(list.size() - 1 - i);
        }

        return Math.abs(right - left);
    }

    public static int minimumNumber(int n, String password) {
        //문자열이 주어질 때, 강력한 비밀번호가 되려면 추가로 필요한 문자열 수 출력
        int result = 0;
        String pattern1 = "[0-9]";
        String pattern2 = "[a-z]";
        String pattern3 = "[A-Z]";
        String pattern4 = "[!@#$%^&*()\\-+]";

        //패턴이 없는 경우, 필요 문자 +1
        Pattern p = Pattern.compile(pattern1);
        Matcher m = p.matcher(password);
        if(!m.find()){
            System.out.println("숫자");
            result++;
        }
        p = Pattern.compile(pattern2);
        m = p.matcher(password);
        if(!m.find()){
            System.out.println("소문");
            result++;
        }
        p = Pattern.compile(pattern3);
        m = p.matcher(password);
        if(!m.find()){
            System.out.println("대문");
            result++;
        }
        p = Pattern.compile(pattern4);
        m = p.matcher(password);
        if(!m.find()){
            System.out.println("특문");
            result++;
        }
        //최소 길이를 만족하지 않는다면 최소 길이-입력 문자 길이 만큼의 문자 필요
        if(result + password.length() < 6){
            result = 6 - password.length();
        }

        return result;
    }

    public static int palindromeIndex(String s) {
        int l = s.length();
        int i, j, a, b;
        //다른지점 찾기
        for (i = 0, j = l - 1; i < l; i++,j--){
            if (s.charAt(i) != s.charAt(j))
                break;
        }
        //다른 곳이 없는 경우
        if(i > j){
            return -1;
        }
        //누가 다른 건지 찾기
        for(a = i + 1, b = j;a < j && b > i + 1;a++, b--){
            if (s.charAt(a) != s.charAt(b)){
                return j;
            }
        }
        return i;
    }

    private static String highestValuePalindrome(String s, int n, int k){
        //앞으로 읽으나 뒤로 읽으나 같은 숫자를 Palindrome 이라함
        //주어진 횟수 k 안에서 주어진 문자열 s를 최대값인 palindrome이 되도록 변경한 후 출력
        char[] chars = s.toCharArray();
        int[] change = new int[n];
        Arrays.fill(change, 0);
        //교차되면 종료
        for(int i = 0;i < n/2;i++){
            int end = n - 1 -i;
            if(chars[i] != chars[end]){
                int max = Math.max(chars[i], chars[end]);
                chars[i] = (char)max;
                chars[end] = (char)max;
                change[i] = 1;  //값 바꾼 위치 기억
                k--;
            }
        }
        System.out.println("남은 횟수 : " + k);
        if(k < 0){
            return "-1";
        }
        for(int i = 0;i < n/2 && k > 0;i++){
            int end = n - 1 -i;
            //9가 아니라면 앞 뒤 모두 9로 바꿔주면 최대값이 될거니까
            if(chars[i] != '9'){
                //남은 횟수가 앞뒤 모두 바꿀 횟수 2보다 커야하지만
                //이미 바꿨다면 중복으로 빼주는 것이니까 change[i] 값을 뺸다.
                if(k >= 2 - change[i]){
                    chars[i] = '9';
                    chars[end] = '9';
                    k -= 2 - change[i];
                }
            }
        }
        //홀수인경우, 아직 횟수가 남았다면 한 가운데 숫자를 9로
        if(n%2 != 0 && k > 0){
            chars[n/2] = '9';
        }
        return new String(chars);
    }

    public static int makingAnagrams(String s1, String s2) {
        //anagram : 다른 글자일 수 있지만 같은 문자로 구성된 글자, 즉 문자열 내 문자와 문자의 숫자가 동일한 경우
        int result = 0;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int[] num1 = new int[26];
        int[] num2 = new int[26];
        for(char c : ch1){
            num1[c - 'a']++;
        }
        for(char c : ch2){
            num2[c - 'a']++;
        }

        for(int i = 0;i < 26;i++){
            if(num1[i] != num2[i]){
                result += Math.abs(num1[i] - num2[i]);
            }
        }
        return result;
    }

    private static int sherlockAndAnagrams(String s){
        int count=0;
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++){
            for (int j=i+1; j<=s.length(); j++){
                char[] chars = s.substring(i, j).toCharArray();
                Arrays.sort(chars);
                String str2 = new String(chars);
                System.out.println("str2 : " + str2);
                map.put(str2, map.getOrDefault(str2, 0)+1);
            }
        }
        for(String key : map.keySet()){
            System.out.println("key : " + key + "// value : " + map.get(key));
        }
        for (Map.Entry e : map.entrySet()){
            int val = (int)e.getValue();
            count+= val*(val-1)/2;
        }
        return count;
    }

    private static int anagram(String s){
        //주어진 문자열 s를 반으로 나눠서 각 문자열에서 몇개를 바꾸면 anagram이 되는지 출력
        if(s.length() % 2 != 0){
            return -1;
        }
        int result = 0;
        int half = s.length() / 2;
        String sub1 = s.substring(0, half);
        String sub2 = s.substring(half);
        StringBuilder sb = new StringBuilder(sub2);
        for(char c : sub1.toCharArray()){
            int idx = sb.toString().indexOf(c);
            if(idx == -1) result++;
            else sb.deleteCharAt(idx);
        }
        return result;
    }

    public static String twoStrings(String s1, String s2) {
        //두 문자열 s1, s2가 주어질 때, s1의 문자가 s2에 포함되어있으면 YES 출력 아니면 NO 출력
        //중복을 없애야함. 아니면 timeout 떨어짐. => 중복없애기위해 set 사용
        Set<String> strings = new HashSet<>();
        Collections.addAll(strings, s1.split(""));
        for(String str : strings){
            if(s2.contains(str)) return "YES";
        }
        return "NO";
    }

    public static String caesarCipher(String s, int k) {
        //문자열 s가 주어질 때, 숫자 k만큼 각 문자를 이동시킨 문자열 출력
        //아스키코드로 계산하는데, z(Z) 다음은 a(A)여야함.
        char[] chars = s.toCharArray();
        Pattern p = Pattern.compile("^[a-zA-Z]*$");
        Pattern upper = Pattern.compile("[A-Z]");

        for(int i =0;i < chars.length;i++){
            Matcher m = p.matcher(String.valueOf(chars[i]));
            if(!m.find()) {
                continue;
            }
            int j = 1;
            while(j <= k){
                m = upper.matcher(String.valueOf(chars[i]));
                char rotate = (char) ((int) chars[i] + 1);
                if(m.find()){
                    if(rotate > (int)'Z'){
                        rotate -= 26;
                    }
                }else{
                    if(rotate > (int)'z'){
                        rotate -= 26;
                    }
                }
                chars[i] = rotate;
                j++;
            }
        }
        return String.valueOf(chars);
    }

    public static int marsExploration(String s) {
        //문자열 s가 주어질 때, 문자열 길이 / 3 만큼 SOS 문자가 포함되어 있어야하는데, SOS문자가 틀린 문자 개수 구하기
        //S, O 개수만 가지고 틀린 문자 찾으려 했으나 테스트 케이스 실패 -> 위치가 틀린 걸 고려해야함.
        int diff = 0;
        String sos = "SOS";

        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) != sos.charAt(i % 3)) diff++;
        }
        return diff;
    }

    public static String hackerrankInString(String s) {
        //subsequence로 hackerrank를 포함하고 있는 지 출력
        //순서도 중요함.
        String message = "hackerrank";//hereiamstackerrank
        int j = 0;
        for(int i = 0;i < s.length();i++){
            if(j < message.length() && s.charAt(i) == message.charAt(j)){
                j++;
            }
        }
        return (j == message.length())? "YES" : "NO";
    }

    public static void separateNumbers(String s){
        //문자열 s가 주어질 때, 연속된 숫자로 이루어져있는지
        //길이별로 잘라서 연속된 숫자로 이루어진 문자열 s'를 만들어서 s와 비교
        boolean isEnd = false;
        String first = "";
        for(int i = 1;i <= s.length()/2;i++){
            first = s.substring(0, i);
            long temp = Long.parseLong(first);
            StringBuilder sb = new StringBuilder(first);
            while (sb.length() < s.length()){
                sb.append(++temp);
            }
            if(sb.toString().equals(s)){
                isEnd = true;
                break;
            }
        }
        System.out.println(isEnd? "YES " + first : "NO");
    }

    private static String pangrams(String s){
        //a~z 까지 모든 문자가 다 들어가있는 문자열을 pangram이라 한다.
        //문자열 s가 주어질 때, pangram인지 아닌지 출력, 대소문자 구분안함
        //공백을 제거한 문자열을 중복제거위해 set에 저장, set의 총 사이즈가 26이면 모든 문자가 다 들어있는 것을 의미
        String[] lower = s.toLowerCase().replaceAll(" ", "").split("");
        Set<String> set = new HashSet<>(Arrays.asList(lower));
        return set.size() == 26? "pangram" : "not pangram";
    }

    private static String funnyString(String s) {
        //문자열 s 와 reverse 문자열 s'와 비교해서 인접한 두 문자열의 차가 같으면 funny 출력
        for(int i = 0, j = s.length()-1;i < s.length() - 1 && j > 0;i++, j--){
            if(Math.abs(s.charAt(i) - s.charAt(i+1)) != Math.abs(s.charAt(j) - s.charAt(j-1))){
                return "Not Funny";
            }
        }
        return "Funny";
    }

    private static void miniMaxSum(int[] arr){
        //5개의 숫자가 주어질 때, 4개를 선택하여 더했을 때 최소값과 최대값 출력
        //최소값은 5개 중 최대값을 빼고 더한 경우, 최대값은 최소값을 뺀 나머지 4개를 더한 경우이다.
        int min = arr[0];
        int max = arr[0];
        long sum = 0L;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
            sum += value;
        }
        System.out.print(sum-max);
        System.out.print(" ");
        System.out.print(sum-min);
    }

    private static int beautifulBinaryString(String b){
        //010 이 포합되어 있으면 0을 1로 바꿔서 beautiful string을 만들어야한다. 바꾸는 횟수 출력
        //주어진 문자열 b가 010을 몇개 포합하고 있는 지 출력하면 된다.
        Pattern p = Pattern.compile("010");
        Matcher m = p.matcher(b);
        int count = 0;
        while(m.find()){
            count++;
        }
        return count;
    }

    private static int gemstones(String[] arr) {
        //문자열 배열이 주어질 때, 각 문자열이 공통으로 가지고 있는 substring 개수 출력
        //중복을 없앤 상태에서 각 문자열의 수가 주어진 문자열 배열의 크기랑 같은 경우 각 문자열에 다 포함되었다는 의미
        int[] num = new int[26];
        int count = 0;
        for (String s : arr) {
            Set<Character> characterSet = new HashSet<>();
            for (char c : s.toCharArray()) {
                characterSet.add(c);
            }
            for (char c : characterSet) {
                num[c - 'a']++;
            }
        }
        for(int i : num){
            if(i >= arr.length){
                count++;
            }
        }
        return count;
    }

    private static String isValid(String s) {
        //문자열 s가 주어질 때, 각 문자열의 갯수가 동일해야함. 최대 문자 1개를 제거할 수 있을 때, valid인지 invalid인지 출력
        //즉, 문자의 개수가 다른 문자가 1개 초과할 경우 invalid
        int[] num = new int[26];
        int count = 0, start = 0;
        for(char c : s.toCharArray()){
            num[c - 'a']++;
        }
        for(int i = 0;i < num.length - 1;i++){
            if(num[i] > 0){
                start = i;
                break;
            }
        }
        for(int i = start+1;i < num.length;i++){
            if(num[start] != 0 && num[i] != 0 && (num[start] != num[i])){
                count++;
            }
        }
        if(count > 1)return "NO";

        return "YES";
    }

    private static int alternatingCharacters(String s){
        //A와 B로 이루어진 문자열 s에서 각 문자가 연속되지 않도록 하기 위해 지워야하는 문자의 수 출력
        char[] chars = s.toCharArray();
        int start = 0, count = 0;
        for(int i = 1; i < chars.length; i++){
            if(chars[start] != chars[i]) start = i;
            else count++;
        }
        return count;
    }

    private static int stringConstruction(String s){
        //문자열 s가 주어질때, 새로운 문자열 p를 만드는 데 소요되는 cost 출력
        //문자 하나를 복사하는 데 cost 1이 들고, p의 substring을 복사해서 붙이는 데에는 cost 0이 든다.
        //즉, 중복을 없앤 문자의 개수를 출력하면 된다.
        Set<Character> characterSet = new HashSet<>();
        for(char c : s.toCharArray()){
            characterSet.add(c);
        }
        return characterSet.size();
    }

    private static String[] weightedUniformStrings(String s, int[] queries){
        //주어진 문자열 안에서 연속된 substring을 uniformstring이라함.
        //연속된 문자가 나올경우 연속된 만큼 점수를 곱해서 저장
        //구할 수 있는 점수를 중복을 방지하기 위해 set에 넣는다. 주어진 합계가 존재하는 지 찾으면 Yes 출력
        String[] result = new String[queries.length];
        Arrays.fill(result, "No");
        char[] chars = s.toCharArray();
        Set<Integer> sum = new HashSet<>();
        int count = 1;
        int before = 0;
        for (char c : chars) {
            int score = c - 'a' + 1;
            if (score == before) {
                count++;
            } else {
                count = 1;
                before = score;
            }
            sum.add(score * count);
        }
        for(int i = 0;i < queries.length;i++){
            if(sum.contains(queries[i])) result[i] = "Yes";
        }
        return result;
    }
}
