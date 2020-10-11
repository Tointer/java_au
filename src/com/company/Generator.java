package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Generator {

    private static String sourceFileName = "source_leetcode_data.txt";
    private static String markDownFileName = "string.md";
    private static String commentSyntax = "<!---->";

    public static String[] ReadFromFile(String name) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(name));
        String[] stringArray = new String[lines.size()];
        return lines.toArray(stringArray);
    }

    public static void PackIntoMarkdownFile(TaskInfo task) throws IOException{
        String linkName = task.link.replace("https://leetcode.com/problems/", "");
        String head = "+ [" + task.name + "](#" + linkName + ")\n" + commentSyntax;
        String body = "## " + task.name + "\n\n" + task.link + "\n\n```java\n" + task.GetSolutionAsString() + "\n```";
        String chapterName = markDownFileName.substring(0, markDownFileName.length()-3);

        System.out.println(Paths.get((new File("").getAbsolutePath() + "\\leetcode\\" + markDownFileName)));
        List<String> mdLines = Files.readAllLines(Paths.get((new File("").getAbsolutePath() + "\\leetcode\\" + markDownFileName)));
        if(mdLines.size() < 2){
            FileWriter fileWriter = new FileWriter((new File("").getAbsolutePath() + "\\leetcode\\" + markDownFileName));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf("# %s \n\n%s", chapterName, head+ "\n\n" +body);
            printWriter.close();
            return;
        }

        int i;
        for (i = 0; i < mdLines.size(); i++) {
            if(mdLines.get(i).equals(commentSyntax)){
                mdLines.set(i, head);
                break;
            }
        }
        mdLines.add(body);

        FileWriter fileWriter = new FileWriter((new File("").getAbsolutePath() + "\\leetcode\\" + markDownFileName));
        for(String str: mdLines) {
            fileWriter.write(str + System.lineSeparator());
        }
        fileWriter.close();

    }

    public static void Generate(){
        //File file = new File("yourfileName");
        RawTaskInfoProcessor processor = new RawTaskInfoProcessor();

        try {
            PackIntoMarkdownFile(processor.Parse(ReadFromFile(sourceFileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
