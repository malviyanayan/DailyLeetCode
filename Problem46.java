import java.util.ArrayList;
import java.util.List;

class Problem46{
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int[] nums = {1, 2, 3};
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        List<Integer> rem = new ArrayList<>();

        List<List<Integer>> anslist = new ArrayList<>();
        permutation(numbers, rem, anslist);
        System.out.println("anslist:");
        for (List<Integer> sublist : anslist) {
            for (Integer num : sublist) {
                System.out.print(num + " ");
            }
            System.out.println(); // Ek newline print karne ke liye
        }
    }

    static void permutation(List<Integer> str, List<Integer> rem, List<List<Integer>> ans) {
        if (str.size() <= 0) {
            ans.add(new ArrayList<>(rem)); // New list ko add karna
            return;
        }
        for (int i = 0; i < str.size(); i++) {
            Integer x = str.get(i);
            List<Integer> a = new ArrayList<>(str.subList(0, i));
            List<Integer> b = new ArrayList<>(str.subList(i + 1, str.size()));
            a.addAll(b);
            rem.add(x);
            permutation(a, rem, ans);
            rem.remove(rem.size() - 1); // Backtracking ke liye last element ko remove karna
        }
    }
}
