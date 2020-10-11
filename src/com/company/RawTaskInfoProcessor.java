package com.company;
import java.util.Arrays;

public class RawTaskInfoProcessor {

    public TaskInfo Parse(String[] lines){
        //String[] lines = rawString.split("\\r?\\n");
        if (lines.length < 4) throw  new RuntimeException();
        return new TaskInfo(lines[0], lines[1],  Arrays.copyOfRange(lines, 3, lines.length - 1));
    }

}
