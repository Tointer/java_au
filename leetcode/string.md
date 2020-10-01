# String

+ [Group Anagrams](#group-anagrams)
+ [Valid Palindrome](#valid-palindrome)
+ [Longest Palindromic Substring](#longest-palindromic-substring)
+ [Palindromic Substring](#palindromic-substrings)


## Group Anagrams

https://leetcode.com/problems/group-anagrams/

```java
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);

            if (!groups.containsKey(key)) groups.put(key, new ArrayList<>());
            groups.get(key).add(str);
        }

        return new ArrayList<>(groups.values());
    }
```

## Valid Palindrome

https://leetcode.com/problems/valid-palindrome/

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

## Palindromic Substring

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