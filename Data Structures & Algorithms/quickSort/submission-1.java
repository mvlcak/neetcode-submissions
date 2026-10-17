// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return new ArrayList<>(Arrays.asList(quickSort(pairs.toArray(Pair[]::new), 0, pairs.size()-1)));
    }

    public Pair[] quickSort(Pair[] pairs, int start, int end){
        if(end-start<1){
            return pairs;
        }
        int pointer = start;
        Pair pivot = pairs[end];
        for (int i = start; i < end; i++){
            Pair curr = pairs[i];
            if(curr.key < pivot.key){
                Pair tmp = pairs[pointer];
                pairs[pointer] = curr;
                pairs[i]= tmp;
                pointer++;
            }

        }
        Pair tmp = pairs[pointer];
        pairs[pointer] = pivot;
        pairs[end] = tmp;
        quickSort(pairs, start, pointer-1);
        quickSort(pairs, pointer+1, end);
        
        return  pairs;
    }
}
