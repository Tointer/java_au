# string 

+ [Longest Palindromic Substring](#longest-palindromic-substring/)
<!---->

## Longest Palindromic Substring

https://leetcode.com/problems/longest-palindromic-substring/

```java
public String longestPalindrome(String s) {
    if(s.length() <= 1) return  s;
    char[] sentence = s.toCharArray();
    String result = new String(sentence, 0, 1);

    //для четных палиндромов
    for (int i = 1; i < sentence.length; i++) {
        if (sentence[i] == sentence[i-1]){
            int length = maxExtendedPalindrom(sentence, i-1, i);
            if(result.length() < length) result = new String(sentence, i - length/2, length);
        }
    }

    //для нечетных палиндромов
    for (int i = 1; i < sentence.length - 1; i++) {
        if (sentence[i - 1] == sentence[i + 1]){
            int length = maxExtendedPalindrom(sentence, i-1, i+1);
            if(result.length() < length) result = new String(sentence, i - length/2, length);
        }
    }

    return result;
}

public int maxExtendedPalindrom(char[] s, int start, int end){
    int result = end - start + 1;
    for (int i = 1; i < s.length/2; i++) {
        if (start - i < 0 || end + i > s.length-1) break;
        if (s[start - i] == s[end + i]) result += 2;
        else break;
    }
    return result;
}
```