/*
Hi, here's your problem today. This problem was recently asked by Twitter:

A palindrome is a sequence of characters that reads the same backwards and forwards. Given a string, s, find the longest palindromic substring in s.

Example:
Input: "banana"
Output: "anana"

Input: "million"
Output: "illi"
*/
package main.java;

public class _3_Longest_Palindromic_Substring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));// ans -> bb
        System.out.println(longestPalindrome("abababa"));// ans -> abababa
        System.out.println(longestPalindrome("abcdefg"));// ans -> a
        System.out.println(longestPalindrome(""));// ans -> ""
    }
    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1)
            return "";
        int maxLen = 1;
        int start = 0;
        for(int i = 1 ; i < s.length() ; i++) {
            int currLen = 1;
            int l = i - 1;
            int r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                currLen += 2;
                if(currLen > maxLen) {
                    maxLen = currLen;
                    start = l;
                }
                l--;
                r++;                
            }            
            l = i - 1;
            r = i;
            currLen = 0;            
            
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                currLen += 2;
                if(currLen > maxLen) {
                    maxLen = currLen;
                    start = l;
                }
                l--;
                r++;
            }
        }
        
        return s.substring(start, start + maxLen);        
    }
}