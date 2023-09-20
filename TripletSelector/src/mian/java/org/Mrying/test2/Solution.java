package org.Mrying.test2;

public class Solution {

    // answer
    private long ans = 0;

    // 计算一组特工中两两之间的有效组合数量，而不考虑顺序
    private long calCombinations(long n) {
        return n*(n-1)/2;
    }

    public long select(int[] dest, int d) {

        for(int i = 0,j = 0;i < dest.length;i++) {

            // 题目要求有 3 个埋伏地点
            // 3 个特工，所有 i >= 2 时取 dist[2] 是第三个特工
            // 此时 j = 0，dist[i]-dist[j] > d 是比较最近和最远的距离
            // 找到特工 i 和特工 j 之间的最大距离不大于 d 的 j 值
            while(i >= 2 && (dest[i]-dest[j] > d)) {
                // 满足距离小于等于 d 时，个数加 1
                j++;
            }

            // 计算当前情况下 i 和 j 的组合数量
            ans += calCombinations(i-j);
        }

        // 最后结果可能溢出，所以对 mod 取模
        return ans%Constant.mod;
    }
}
