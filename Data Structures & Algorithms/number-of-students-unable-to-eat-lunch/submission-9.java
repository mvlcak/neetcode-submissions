class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
    int[] want = new int[2];
    for (int s : students) {
        want[s]++;
    }
    for (int s : sandwiches) {
        if (want[s] == 0) {
            return want[0] + want[1];
        }
        want[s]--;
    }
    return 0;
}

}
