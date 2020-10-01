# Intervals

+ [Non Overlapping Intervals](#non-overlapping-intervals)
+ [Merge Intervals](#merge-intervals)
+ [Insert Interval](#insert-interval)

## Non Overlapping Intervals

https://leetcode.com/problems/non-overlapping-intervals

```java
public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length <= 1) return 0;

    ArrayList<int[]> list = new ArrayList<>(Arrays.asList(intervals));
    list.sort((x, y) -> Integer.compare(x[1], y[1]));
    
    int[] prev = list.get(0);
    int erased = 0;
    
    for (int i = 1; i < list.size(); i++){
        if (list.get(i)[0] < prev[1]) erased++;
        else prev = list.get(i);
    }
    
    return erased;
}
```

## Merge Intervals

https://leetcode.com/problems/merge-intervals/

```java
public int[][] merge(int[][] intervals) {
    if(intervals.length == 0) return intervals;
    ArrayList<int[]> list = new ArrayList<>(Arrays.asList(intervals));
    list.sort((x, y) -> Integer.compare(x[0], y[0]));

    for (int i = 1; i < list.size(); i++){
        int[] last = list.get(i-1);
        int[] cur = list.get(i);
        
        if (!isOverlapping(last, cur)) continue;

        list.set(i-1, new int[]{Integer.min(last[0], cur[0]), Integer.max(last[1], cur[1])});
        list.remove(i);
        i--;
    }

    intervals = new int[list.size()][2];
    return list.toArray(intervals);
}

public boolean isOverlapping(int[] firstInterval, int[] SecondInterval){
    if (firstInterval[0] > SecondInterval[0]) {
        return firstInterval[0] <= SecondInterval[1];
    }
    else return SecondInterval[0] <= firstInterval[1];
}
```

## Insert Interval

https://leetcode.com/problems/insert-interval/

```java
public int[][] insert(int[][] intervals, int[] newInterval) {
    ArrayList<int[]> list = new ArrayList<>(Arrays.asList(intervals));
    
    int i = 1;
    for (; i < list.size(); i++) {
        if (list.get(i)[0] < newInterval[0]) continue;
        break;
    }
    list.add(i-1, newInterval);
    list = merge(list);
    intervals = new int[list.size()][2];
    return list.toArray(intervals);
}

public ArrayList<int[]> merge(ArrayList<int[]> intervals) {

    intervals.sort((x, y) -> Integer.compare(x[0], y[0]));

    for (int i = 1; i < intervals.size(); i++){
        int[] last = intervals.get(i-1);
        int[] cur = intervals.get(i);

        if (!isOverlapping(last, cur)) continue;

        intervals.set(i-1, new int[]{Integer.min(last[0], cur[0]), Integer.max(last[1], cur[1])});
        intervals.remove(i);
        i--;
    }

    return intervals;
}

public boolean isOverlapping(int[] firstInterval, int[] SecondInterval){
    if (firstInterval[0] > SecondInterval[0]) {
        return firstInterval[0] <= SecondInterval[1];
    }
    else return SecondInterval[0] <= firstInterval[1];
}
```
