package demo;

import org.apache.commons.io.FileUtils;
import util.StaticUtilTool;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {
    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> {
            try {
                FileUtils.deleteDirectory(new File(StaticUtilTool.dest_root_path_str));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                do_delete_and_do_copy();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

    private static void do_delete_and_do_copy() throws IOException {
        StaticUtilTool staticUtilTool = new StaticUtilTool();

        String root_path = "C:" + File.separator + "WebstormProjects";
        staticUtilTool.do_delete_by_path(root_path, "node_modules");

        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("C:\\IdeaProjects");
        linkedList.add("C:\\WebstormProjects");

        linkedList.add("C:\\Users\\littleOStar\\.android");
        linkedList.add("C:\\Users\\littleOStar\\.config");
        linkedList.add("C:\\Users\\littleOStar\\.IntelliJIdea2018.3");
        linkedList.add("C:\\Users\\littleOStar\\.m2");
        linkedList.add("C:\\Users\\littleOStar\\.WebStorm2018.3");
        linkedList.add("C:\\Users\\littleOStar\\Coding");
        linkedList.add("C:\\Users\\littleOStar\\Pictures");
        linkedList.add("C:\\Users\\littleOStar\\Downloads");
        linkedList.add("C:\\Users\\littleOStar\\.bash_history");
        linkedList.add("C:\\Users\\littleOStar\\.gitconfig");
        linkedList.add("C:\\Users\\littleOStar\\.yarnrc");

        for (String str : linkedList) {
            staticUtilTool.do_copy_source_to_d_disk(str);
        }
        System.out.println("finish copy ............................................................");
    }
}
