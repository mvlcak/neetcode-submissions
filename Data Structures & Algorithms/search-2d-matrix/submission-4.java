class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int bottomRow = 0;
        int topRow = matrix.length-1;

        if(topRow == bottomRow){
            return binarySearch(matrix[bottomRow], target);
        }

        while (topRow != bottomRow+1) {
            int ri = (topRow+bottomRow)/2;
            if(matrix[ri][0]<target){
                bottomRow=ri;
            } else if(matrix[ri][0]>target){
                topRow=ri;
            } else if(matrix[ri][0] == target){
                return true;
            }
        } 
        if(target<matrix[topRow][0]){
            return binarySearch(matrix[bottomRow], target);
        } else{
            return binarySearch(matrix[topRow], target);
        }

    }

    private boolean binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length -1;

        while (left<=right){
            int mid = (left+right)/2;
            if(array[mid] < target){
                left = mid +1;
            } else if(array[mid]> target){
                right = mid-1;
            } else {
                return true;
            }
        }
        return false;
    }
}
