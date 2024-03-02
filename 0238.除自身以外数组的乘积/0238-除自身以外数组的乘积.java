class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] backPdt = new int[n];
        backPdt[n-1]=1;
        for (int i = n-1; i>= 1; i--){
            backPdt[i-1] = backPdt[i]*nums[i];
        }
        int prePdt = 1;
        for (int i = 0; i<n;i++){
            backPdt[i]*=prePdt;
            prePdt*=nums[i];
        }
        return backPdt;
    }
}