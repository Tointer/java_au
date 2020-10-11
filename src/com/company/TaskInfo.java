package com.company;
public class TaskInfo{
    public final String name;
    public final String link;
    public final String[] solution;

    public TaskInfo(String name, String link, String[] solution) {
        this.name = name;
        this.link = link;
        this.solution = solution;
    }

    public String GetSolutionAsString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < solution.length; i++) {
            builder.append(solution[i]);
            if (i != solution.length - 1)
                builder.append(" \n");
        }
        return builder.toString();
    }
}