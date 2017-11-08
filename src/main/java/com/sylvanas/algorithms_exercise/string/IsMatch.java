package com.sylvanas.algorithms_exercise.string;

/**
 * 通配符匹配
 * 判断两个可能包含通配符“？”和“*”的字符串是否匹配。匹配规则如下：
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个串完全匹配才算匹配成功。
 * 函数接口如下:
 * bool isMatch(const char *s, const char *p)
 *
 * Created by SylvanasSun on 11/4/2017.
 */
public class IsMatch {

    /**
     * 使用动态规划实现
     * 状态转移:
     * 如果 s[i] == p[j]
     * 那么 dp[i][j] = dp[i+1][j+1]
     * 如果 p[j] == '?'
     * 那么 dp[i][j] = dp[i+1][j+1]
     * 如果 p[j] == '*'
     * 分三种情况:
     * 1. 只匹配s[i],那么 dp[i][j] = dp[i+1][j+1]
     * 2. 作为空值出现,那么 dp[i][j] = dp[i][j+1]
     * 3. 匹配两个以上字符,那么 dp[i][j] = dp[i+1][j]
     */
    public static boolean isMatch(String s, String p) {
        int s_length = s.length();
        int p_length = p.length();
        boolean[][] dp = new boolean[s_length + 1][p_length + 1];
        dp[s_length][p_length] = true;

        // 如果p的后面有连续字符为*时，可以初始化为true。
        for (int i = p_length - 1; i >= 0; i--) {
            if (p.charAt(i) != '*')
                break;
            else
                dp[s_length][i] = true;
        }

        for (int i = s_length - 1; i >= 0; i--) {
            for (int j = p_length - 1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    dp[i][j] = dp[i + 1][j + 1];
                else
                    dp[i][j] = p.charAt(j) == '*' && (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }

}
