# string 

+ [Valid Palindrome](#valid-palindrome)
<!---->

## Valid Palindrome

https://leetcode.com/problems/valid-palindrome

```java
public boolean isPalindrome(String s) {
    char[] sentence = s.toLowerCase().toCharArray();
    int j = sentence.length - 1;
    for (int i = 0; i < sentence.length; i++) {
        while (!Character.isLetterOrDigit(sentence[i])){
            i++;
            if(j <= i) break;
        }
        while (!Character.isLetterOrDigit(sentence[j])){
            j--;
            if(j <= i) break;
        }
        if(j <= i) break;
        if (sentence[i] != sentence[j]) return false;
        j--;
    }
    return true;
}
```