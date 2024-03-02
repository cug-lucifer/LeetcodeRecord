class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int mxnP = nums[0];
        int end = 0;
        int steps = 0;
        for (int i = 0; i< nums.length-1;i++){
            mxnP = Math.max(mxnP,i+nums[i]);
            if (i == end){
                end = mxnP;
                steps+=1;
            }
        }
        return steps;
    }
}