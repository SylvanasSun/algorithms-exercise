package com.sylvanas.algorithms_exercise.string;

/**
 * Knuth–Morris–Pratt algorithm
 * In computer science, the Knuth–Morris–Pratt string searching algorithm (or KMP algorithm)
 * searches for occurrences of a "word" W within a main "text string" S by employing the
 * observation that when a mismatch occurs, the word itself embodies sufficient information
 * to determine where the next match could begin, thus bypassing re-examination
 * of previously matched characters.
 *
 * For more details: http://www.wikiwand.com/en/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
 *
 * Created by SylvanasSun on 4/26/2018.
 */
public class KMP {

    public static int solution(String mainString, String pattern) {
        char[] t = mainString.toCharArray();
        char[] p = pattern.toCharArray();
        int t_length = t.length;
        int p_length = p.length;
        int i = 0, j = 0;
        int[] next = initNext(p, p_length);

        while (i < t_length && j < p_length) {
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j]; // backtrack
            }
        }

        if (j == p_length)
            return i - j;
        else
            return -1;
    }

    /**
     * The next array is a PMT(Partial-Match-Table) that the length of the longest element
     * in the intersection of the prefixes and suffixes in the pattern string,
     * for easy access, the next array is shifted to the right by one.
     *
     * Example:
     * pattern string: a b a b a b c a
     * --------index:  0 1 2 3 4 5 6 7
     * ----------pmt:  0 0 1 2 3 4 0 1
     * --------next:-1 0 0 1 2 3 4 0 1
     *
     * string "ababa"
     * prefixes : {"a" , "ab", "aba", "abab"}
     * suffixes : {"baba", "aba", "ba", "a"}
     * intersection : {"a", "aba"}
     * length of the longest element: 3 (pmt[4] = 3)
     */
    private static int[] initNext(char[] p, int p_length) {
        int[] next = new int[p_length + 1];
        next[0] = -1; // Just a sentinel mark
        int i = 0, j = -1;

        // Start with the match itself from the index 1 of the pattern string
        // matched the longest length is value in the current location
        while (i < p_length) {
            if (j == -1 || p[i] == p[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j]; // backtrack
            }
        }

        return next;
    }

    public static void main(String[] args) {
        String pattern = "abababca";
        assert KMP.solution("abababcasafaiogasg", pattern) == 0;
        assert KMP.solution("babasfasgabababca", pattern) == 9;
        assert KMP.solution("kp", pattern) == -1;
    }

}
