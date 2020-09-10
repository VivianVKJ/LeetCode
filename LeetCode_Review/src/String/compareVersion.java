package String;

public class compareVersion {
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
    }

    public static int compareVersion(String version1, String version2) {
        while (version1.length() < version2.length())
            version1 += ".0";
        while (version2.length() < version1.length())
            version2 += ".0";
        String[] list1 = version1.split("\\.");
        String[] list2 = version2.split("\\.");
        for (int i = 0; i < list1.length; i++) {
            if (list1[i].charAt(0) < list2[i].charAt(0)) return -1;
            else if (list1[i].charAt(0) > list2[i].charAt(0)) return 1;
        }
        return 0;
    }
}
