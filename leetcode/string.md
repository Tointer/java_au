# string 

+ [Group Anagrams](#group-anagrams)
<!---->

## Group Anagrams

https://leetcode.com/problems/group-anagrams

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