/*
Hi, here's your problem today. This problem was recently asked by Microsoft:

Given a string, find the length of the longest substring without repeating characters.

Here is an example solution in Python language. (Any language is OK to use in an interview, though we'd recommend Python as a generalist language utilized by companies like Google, Facebook, Netflix, Dropbox, Pinterest, Uber, etc.,)

class Solution:
  def lengthOfLongestSubstring(self, s):
    # Fill this in.

print Solution().lengthOfLongestSubstring('abrkaabcdefghijjxxx')
# 10

Can you find a solution in linear time?
*/

package main.java;

public class _2_Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {
        System.out.println("abcabcabc");
        System.out.println(lengthOfLongestSubstring("abcabcabc"));// output should be 3 - "abc"
        System.out.println(("bbbbbbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbbb"));// output should be 1 - "b"
        System.out.println(("pewdjncvvvr"));
        System.out.println(lengthOfLongestSubstring("pewdjncvvvr"));// output should be 8 - "pewdjncv"
    }
    
    public static int lengthOfLongestSubstring(String s) {
        if(s==null)
            return 0;
        if(s.length() < 2)
            return s.length();
        int start = 0;
        int end = 1;
        int maxLen = 0;
        boolean[] ascii = new boolean[257];
        ascii[s.charAt(start)] = true;
        maxLen = 1;
        while(end != s.length()) {
            while(start < end && ascii[s.charAt(end)] == true) {
                ascii[s.charAt(start)] = false;
                start++;
            }
            ascii[s.charAt(end)] = true;
            maxLen = Math.max(maxLen, end - start + 1);
            end++;            
        }
        return maxLen;
    }
}