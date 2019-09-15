package alibaba;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String getIndexAndLongest(String _users, int K) {

        char[] users = _users.toCharArray();
        int[] previousGirls = new int[users.length];
        for(int i=0;i<previousGirls.length;i++){
            previousGirls[i] = -1;
        }
        int[] backGirls = new int[users.length];
        for(int i=0;i<backGirls.length;i++){
            backGirls[i] = -1;
        }
        int[] previousBoys = new int[users.length];
        for(int i=0;i<previousBoys.length;i++){
            previousBoys[i] = -1;
        }
        int index = 0;
        int beginIndex = -1;
        boolean begin = false;
        while(index!=beginIndex){

            if(users[index]=='b'){
                begin = true;
            }
            if(begin){
                beginIndex = index;
                if(users[index]=='b'){
                    previousGirls[index] = 0;
                }else if(users[index]=='g'){
                    previousGirls[index] = previousGirls[(index+users.length-1)% users.length]+1;
                }
            }

            index++;
            index%= users.length;
        }

        index = users.length-1;
        beginIndex = -1;
        begin = false;
        while(index!=beginIndex){
            if(users[index]=='b'){
                begin = true;
            }
            if(begin){
                beginIndex = index;
                if(users[index]=='b'){
                    backGirls[index] = 0;
                }else if(users[index]=='g'){
                    backGirls[index] = backGirls[(index+1)% users.length]+1;
                }
            }

            index--;
            index = (index+users.length)%users.length;
        }

        int max = -1;
        int maxIndex = -1;
        for(int i=0;i<users.length;i++){
            if(users[i]=='b'){
                if(previousGirls[(index+users.length-1)% users.length]+backGirls[(index+1)% users.length]>max){
                    max = previousGirls[(index+users.length-1)% users.length]+backGirls[(index+1)% users.length];
                    maxIndex = i;
                }
            }
        }

        index = 0;
        beginIndex = -1;
        begin = false;
        int cursor = -1;
        int weight = -1;
        int girlNum = 0;
        int maxWeight = -1;
        while(index!=beginIndex){
            if(users[index]=='g'){
                begin = true;
            }
            if(begin){
                beginIndex = index;
                if(users[index]=='g'){
                    if(cursor!=-1){
                        girlNum++;
                        if(girlNum>K){
                            if(maxWeight<weight){
                                maxWeight = weight;
                            }
                            while (users[cursor]=='b'){
                                cursor++;
                                weight--;
                            }
                            while(users[cursor]=='g'){
                                cursor++;
                                girlNum--;
                            }
                        }
                    }
                    previousBoys[index] = 0;
                }else if(users[index]=='b'){
                    if(cursor==-1){
                        cursor = index;
                        weight = 0;
                    }
                    weight++;
                    previousBoys[index] = previousBoys[(index+users.length-1)% users.length]+1;
                }
            }



            index++;
            index%= users.length;
        }

        return "";
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        int k = -1;
        try {
            _users = in.nextLine();
            k = in.nextInt();
        } catch (Exception e) {
            _users = null;
        }

        res = getIndexAndLongest(_users, k);
        System.out.println(res);
    }
}