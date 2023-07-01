package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 플랫폼: 백준
 * 이름: 팰린드롬 (1259)
 * 분류: 구현, 문자열
 */
public class Palindrome {
    public boolean isPalindrome(String data) {
        String[] palindromeData = data.split("");

        int low=palindromeData.length/2-1;
        int high = palindromeData.length/2;
        if(palindromeData.length%2==1) {
            high+=1;
        }

        while(low>=0 && high< palindromeData.length) {
            if(!palindromeData[low].equals(palindromeData[high])) {
                return false;
            }
            low--;
            high++;

        }
        return true;
    }
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String data = br.readLine();
            if(data.equals("0")) {
                break;
            }

            if(isPalindrome(data)) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Palindrome().solution();
    }
}
