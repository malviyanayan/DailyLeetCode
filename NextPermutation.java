// in this example we have to find just next lexographicaly permutation of java
// Problem Number-31 on leetcode

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation{
    private static List<ArrayList<Integer>> list = new ArrayList<>();
    private static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        int num[] = {1,1};
        int[] dup = new int[num.length];
        for(int i=0;i<num.length;i++){
            dup[i]= num[i];
        }
        Arrays.sort(num);
        boolean[] isValid = new boolean[num.length];

        permutations(num,isValid);
        
        System.out.println("This is my permutation list.....!!");
        for(ArrayList<Integer> a : list){
            for(int i=0;i<a.size();i++){
                System.out.print(a.get(i)+" ");
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println();
        ArrayList<Integer> my = new ArrayList<>();

        //finding next per
        for(int i=list.size()-1;i>=0;i--){
            ArrayList<Integer> l = list.get(i);
            if(isEqual(dup, l)){
                if(i == list.size() - 1){
                    my = list.get(0);
                    break;
                }
                else{
                    my = list.get(i+1);
                    break;
                }

            }
        }

        for(int i=0;i<num.length;i++){
            num[i] = my.get(i);
        }
        
        for(int k=0;k<num.length;k++){
            System.out.print(num[k] + " ");
        }
        System.out.println("\nEnd Program...!!");
    }


    //My all permutation method

    static void permutations(int[]num,boolean[] isValid){
        if(num.length == ans.size()){
            list.add(new ArrayList<>(ans));
            return;
        }

        for(int i=0;i<num.length;i++){
            if(isValid[i] == false){
                isValid[i]=true;
                ans.add(num[i]);
                permutations(num, isValid);
                ans.remove(ans.size()-1);
                isValid[i]=false;
            }
        }
    }


    // for checking is eqaul method
    public static boolean isEqual(int[] array, ArrayList<Integer> arrayList) {
        if (array.length != arrayList.size()) {
            return false; // Sizes are different, arrays cannot be equal
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != arrayList.get(i)) {
                return false; // Elements are different, arrays cannot be equal
            }
        }

        return true; // Arrays are equal
    }

}