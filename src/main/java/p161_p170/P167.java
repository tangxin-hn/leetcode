package p161_p170;

public class P167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] pos = new int[2];
        pos[0] = 1;
        pos[1] = numbers.length;
        while (pos[0]<pos[1]) {
            if (numbers[pos[0]-1]+numbers[pos[1]-1]==target)
                return pos;
            else if (numbers[pos[0]-1]+numbers[pos[1]-1]>target)
                pos[1]--;
            else
                pos[0]++;
        }
        return pos;
    }
}
