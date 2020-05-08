import java.util.HashMap;
import java.util.Map;
public class TreeCutGroup {

    /**
     * 给一个整数数组，找两个分割点，把该数组分成三段，每段和相等。如果能找到两个分割点，输出两个点的索引，否则输出空。
     * eg:nums[1,3,4,2,2,2,1,1,2]
     * 输出：[2,5]
     * 删除nums[2]和mums[5] ,数组分割W为【1,3】,[2,2],[1,1,2]每个和为4
     */
    public static void main(String[] args) {
        int[] input = new int[9002];
        for(int i=0;i<9002;i++){
            input[i] = 1000;
        }

        int[] result = getTree(input);
        for (int x : result) {
            System.out.println(x);
        }

    }

    public static int[] getTree(int[] input) {
        Map<Integer, Long> sumMap = new HashMap<>();
        Map<Long, Integer> sumMap2 = new HashMap<>();
        long sum = 0L;
        for (int i = 0; i < input.length; i++) {
            sum = sum + input[i];
            sumMap.put(i, sum);
            sumMap2.put(sum, i);
        }
        int stage = 0;
        int stage2 = 0;
        long sums = 0L;
        boolean tag = false;
        for (int j = 1; j < input.length-1; j++) {
            stage = j;
            sums = sumMap.get(j - 1);
            long sum2 = sums + sumMap.get(j);
            if (sumMap2.containsKey(sum2)) {
                int stageBefore = sumMap2.get(sum2);
                long sum3 = sumMap.get(input.length - 1) - sumMap.get(stageBefore + 1);
                if (sum3 == sums) {
                    stage2 = stageBefore + 1;
                    tag = true;
                    break;
                }
            }
        }
        int[] result = new int[2];
        if (tag) {
            result[0] = stage;
            result[1] = stage2;
            return result;
        }
        return new int[0];
    }
}
