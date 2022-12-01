package dp;

public class Q55_Jump_Game {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0) {
                continue;
            }

            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                dp[i + j] = 1;
            }
        }
        return dp[dp.length - 1] == 1;
    }
}