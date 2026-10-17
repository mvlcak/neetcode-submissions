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
        return quickSort(pairs, 0, pairs.size()-1);
    }

    public List<Pair> quickSort(List<Pair> pairs, int start, int end){
        if(end-start<1){
            return pairs;
        }
        int pointer = start;
        Pair pivot = pairs.get(end);
        for (int i = start; i < end; i++){
            Pair curr = pairs.get(i);
            if(curr.key < pivot.key){
                Pair tmp = pairs.get(pointer);
                pairs.set(pointer, curr);
                pairs.set(i,tmp);
                pointer++;
            }

        }
        Pair tmp = pairs.get(pointer);
        pairs.set(pointer, pivot);
        pairs.set(end, tmp);
        quickSort(pairs, start, pointer-1);
        quickSort(pairs, pointer+1, end);
        
        return  pairs;
    }
}
