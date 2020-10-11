# string 

+ [## Palindromic Substring](#palindromic-substrings/)
<!---->

## ## Palindromic Substring

https://leetcode.com/problems/palindromic-substrings/

```java
public int countSubstrings(String s) {
    char[] sentence = s.toCharArray();
    int result = sentence.length;

    //для четных палиндромов
    for (int i = 1; i < sentence.length; i++) {
        if (sentence[i] == sentence[i-1]){
            int length = maxExtendedPalindrom(sentence, i-1, i);
            result += length/2;
        }
    }

    //для нечетных палиндромов
    for (int i = 1; i < sentence.length - 1; i++) {
        if (sentence[i - 1] == sentence[i + 1]){
            int length = maxExtendedPalindrom(sentence, i-1, i+1);
            result += length/2;
        }
    }

    return result;
}

public int maxExtendedPalindrom(char[] s, int start, int end) {
    int result = end - start + 1;
    for (int i = 1; i < s.length/2; i++) {
        if (start - i < 0 || end + i > s.length-1) break;
        if (s[start - i] == s[end + i]) result += 2;
        else break;
    }
    return result;
}
```