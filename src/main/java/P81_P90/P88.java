package p81_p90;

public class P88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=n;i<m+n;i++) {
            nums1[i] = nums1[i-n];
        }
        int i,j,k;
        for (i=0,j=0,k=0;j<n && k<m;i++) {
            if (nums1[j]<nums1[k]) {
                nums1[i] = nums1[j];
                j++;
            } else {
                nums1[i] = nums2[k];
                k++;
            }
        }
        if (k!=m) {
            for (;k<m;k++,i++)
                nums1[i] = nums2[k];
        }
    }

    //others
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int last = m+n-1;
        int first = m - 1;
        int second = n - 1;

        while (first >= 0 && second >= 0) {
            if (nums1[first] > nums2[second]) {
                nums1[last] = nums1[first];
                first--;
            } else {
                nums1[last] = nums2[second];
                second--;
            }
            last--;
        }

        if (first < 0) {
            for (int i = 0; i <= last; i++) {
                nums1[i] = nums2[i];
            }
        }

    }
}
