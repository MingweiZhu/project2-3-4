import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Project3 {
    public List<List<Integer>> solution(int[] array)
    {
        int sum = 10;
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(array);
        helper(answer, temp, array, sum, 0);
        return answer;
    }
    public void helper(List<List<Integer>> answer, List<Integer> temp, int[] array, int sum, int index)
    {
        //if get the result, return
        if(sum == 0)
        {
            // add the result to the answer
            answer.add(new ArrayList<>(temp));
            return;
        }
        //loop to check each element that can add to the sum
        for(int i = index; i < array.length; i++)
        {
            // if the element is the same, jump it
            if(i > index && array[i] == array[i - 1]) continue;
            // over the sum, don't need it, finish this loop
            if(sum - array[i] < 0) break;;
            temp.add(array[i]);
            helper(answer, temp, array, sum - array[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
