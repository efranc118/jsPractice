package main.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

class FileSystem {
    Dir root;

    public FileSystem() {
        root = new Dir("/");
    }

    public List<String> ls(String path) {
        Dir dir = root;
        List<String> contents = new ArrayList<>();
        if(!path.equals("/")) {
            dir = getDir(path);
            String[] ar = path.split("/");
            List<Dir> directories = new ArrayList<>(dir.directories.values());
            if(ar.length > 0 && dir.files.containsKey(ar[ar.length - 1])) {
                contents.add(ar[ar.length - 1]);
                return contents;
            }
        }
        contents.addAll(dir.directories.keySet());
        contents.addAll(dir.files.keySet());
        Collections.sort(contents);

        return contents;
    }

    public void mkdir(String path) {
        String[] pathParts = path.split("/");
        Dir parent = root;
        for(String part: pathParts) {
            if(!part.isEmpty()) {
                Dir child = parent.directories.get(part);
                if(child == null) child = new Dir(part);
                parent.directories.put(part, child);
                parent = child;
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        Dir dir = getDir(filePath);
        String[] ar = filePath.split("/");
        String fileName = ar[ar.length - 1];
        String curContent = dir.files.get(fileName);
        if(curContent != null && !curContent.isEmpty()) content = curContent + content;
        dir.files.put(fileName, content);
    }

    public String readContentFromFile(String filePath) {
        Dir dir = getDir(filePath);
        String[] ar = filePath.split("/");
        return dir.files.get(ar[ar.length-1]);
    }

    private Dir getDir(String path) {
        Dir cur = root;
        String[] remainingPaths = path.split("/");
        for(String nextPath: remainingPaths) {
            if(!nextPath.isEmpty()) {
                Dir nextDir = cur.directories.get(nextPath);
                if (nextDir == null) break;
                cur = nextDir;
            }
        }
        return cur;
    }

}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */


class Dir {
    public String name;
    public TreeMap<String, Dir> directories;
    public TreeMap<String, String> files;

    Dir(String name) {
        this.name = name;
        directories = new TreeMap<>();
        files = new TreeMap<>();
    }
}
