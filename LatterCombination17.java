import java.util.LinkedList;
import java.util.List;

class LatterCombination17{

    static String[] latters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    static public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        char[] ansstr = new char[digits.length()];
        getAns(digits,ansstr, 0, ans);
        return ans;
    }

    static void getAns(String digits,char[] ansstr,int idx,LinkedList<String> ans){
        if(idx == digits.length()){
            String temp = "";
            for(char x : ansstr){
                temp+=x;
            }
            ans.add(temp);
            return ;
        }

        String mystr = latters[Character.getNumericValue(digits.charAt(idx))];

        for(int i=0;i<mystr.length();i++){
            ansstr[idx] = mystr.charAt(i);
            getAns(digits, ansstr, 1+idx, ans);
        }
    }
    

    public static void main(String[] args) {
        String digits = "234";
        List<String> ans = letterCombinations(digits);

        System.out.println(ans);
    }


}