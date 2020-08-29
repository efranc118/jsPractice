package main.strings;

public class VersionCompare {

    public int compareVersion(String version1, String version2) {
        String[] version1Parts = version1.split("\\.");
        String[] version2Parts = version2.split("\\.");
        int length = Math.min(version1Parts.length, version2Parts.length);
        for(int i = 0; i < length; i++) {
            if(compareCurrentVersion(version1Parts[i], version2Parts[i]) != 0) return compareCurrentVersion(version1Parts[i], version2Parts[i]);
        }
        return 0;
    }

    public int compareCurrentVersion(String version1, String version2) {
        Integer version1Int = Integer.parseInt(version1);
        Integer version2Int = Integer.parseInt(version2);
        if(version1Int > version2Int) return 1;
        if(version1Int < version2Int) return -1;
        return 0;
    }


    public static void main(String[] args) {
        VersionCompare solution = new VersionCompare();
        System.out.println(solution.compareVersion("0.1", "1.1"));
    }

}
