package p11_p20;

public class P11 {
    public int maxArea(int[] height) {
        int max=0;
        for(int i=0; i<height.length;i++) {
            for (int j=i+1;j<height.length;j++) {
                int h = height[i];
                if(height[j]<height[i]) {
                    h = height[j];
                }
                int c = (j-i) * h;
                if(c>max) {
                    max = c;
                }
            }
        }
        return max;
    }

    //others
    public int maxArea1(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
