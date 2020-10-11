package com.company;
import java.util.Arrays;

public class RawTaskInfoProcessor {

    public TaskInfo Parse(String[] lines){
        if (lines.length < 5) throw  new RuntimeException();
        return new TaskInfo(lines[0], lines[1],  Arrays.copyOfRange(lines, 2, lines.length));
    }

}
