class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSort(points, 0, points.length-1);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void quickSort(int[][] points, int start, int end){
        if(end-start <1){
            return;
        }
        int pointer = start;
        int[] pivot = points[end];
        for(int i = start; i<end; i++){
            if(dist(points[i]) < dist(pivot)){
                shift(points, i, pointer);
                pointer++;
            }
        }
        shift(points, end,pointer);

        quickSort(points, start, pointer-1);
        quickSort(points, pointer+1, end);
    }

    //sqrt((x1 - x2)^2 + (y1 - y2)^2))
    private double dist(int[] in){
        return Math.sqrt(Math.pow(in[0], 2) + Math.pow(in[1], 2));
    }

    private void shift(int[][] points, int i, int pointer){
        int[] tmp = points[pointer];
        points[pointer] = points[i];
        points[i] = tmp;
    }
}
