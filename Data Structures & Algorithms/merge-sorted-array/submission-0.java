class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m+n;
        for (int i=m, j = 0; i < l; i++, j++){
            nums1[i]=nums2[j];
        }
        
        merge(nums1, 0,m,l);


    }


    private void merge(int[]arr, int start, int middle, int end){

        int l = middle - start;
        int r = end - middle;

        int[] left = new int[l];
        int[] right = new int[r];
        for (int i = 0; i<l; i++){
            left[i] = arr[i+start];
        }

        for (int i = 0; i < r; i++ ){
            right[i] = arr[i+middle];
        }
        int li = 0;
        int ri = 0;
        int i = start;
        while(li < l && ri < r){
            if(left[li]<right[ri]){
                arr[i] = left[li];
                li++;
            } else {
                arr[i] = right[ri];
                ri++;
            }
            i++;
        }

        while(li<l){
            arr[i]=left[li];
            li++;
            i++;
        }

        while(ri<r){
            arr[i]=right[ri];
            ri++;
            i++;
        }

    }
}