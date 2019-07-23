package dp;

public class Palindrome {

    public String longestPalindrome(String s) {
        if(s==null||s.equals("")) return "";
        char[] list = s.toCharArray();
        int size = list.length;
        boolean[][] palindrome = new boolean[size][size];
        int left = 0;
        int right = 0;
        int maxLen = 0;
        for(int step=0;step<size;step++){
            for(int i=0;i+step<size;i++){
                if(step==0){
                    palindrome[i][i] = true;
                }else if(step==1){
                    palindrome[i][i+1] = list[i]==list[i+1];
                }else{
                    palindrome[i][i+step]=palindrome[i+1][i+step-1]&&list[i]==list[i+step];
                }
                if(palindrome[i][i+step]&&step>=maxLen){
                    maxLen = step;
                    left = i;
                    right = i+step;
                }
            }
        }
        return s.substring(left, right+1);

    }

}
