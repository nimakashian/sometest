package searchkeyword;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) throws Exception {

        String[][] keysList ={
                {"0"}
        };
        PrintWriter out = new PrintWriter("out.txt");
        boolean flag = true;

        int threshold = 1;
        String delimiter="=";
        String[] keys =keysList[0];
        String prefix="[";
        String postfix=", size";

        List<String> all=allKeys();


        for (int ii = 1; ii <= threshold; ii++) {
            boolean nameFlag = true;
            for (String s : all) {

                String stemp = s.trim();
                int keyLength = stemp.length() + 1;

                StringBuilder minutesRow = new StringBuilder("max,---,minute,");

                boolean keyFoundFlag = false;
                File[] days = new File("./debugarchive").listFiles();


                for (File d : days) {
                    Integer max = 0;

                    StringBuilder row = new StringBuilder();
                    row.append(d.getName().substring(6) + "," + s + ",");
                    System.out.println(row);
                    File[] minutes = new File("./debugarchive/" + d.getName()).listFiles();
                    for (File minute : minutes) {

                        int iteration = 1;
                        if (flag) {
                            minutesRow.append(minute.getName().substring(17, 22) + ",");

                        }
                        Scanner scanner = new Scanner(minute);
                        while (scanner.hasNextLine()) {

                            String nextLine = scanner.nextLine();
                            if (nextLine.contains("Operator plugin info") && nameFlag && iteration >= ii && threshold > 1) {
                                scanner.nextLine();
                                nextLine = scanner.nextLine();
                                out.println(nextLine);
                                nameFlag = false;

                            }
                            if (nextLine.contains(stemp) && nextLine.indexOf(prefix+stemp) == 0 && nextLine.indexOf(delimiter,nextLine.indexOf(delimiter)+1) == (prefix+stemp+postfix).length()) {
                                if (iteration < ii) {
                                    iteration++;
                                    continue;
                                }
//
                                Matcher m1 = Pattern.compile(stemp+postfix+"=\\d+").matcher(nextLine);
                                m1.find();
                                String s1 = m1.group();
                                row.append(s1.substring(s1.indexOf(",")+7)  +",");
                                keyFoundFlag = true;
                                if (nextLine.substring(keyLength) != null) {
                                    try {
                                        Integer i = 0;
                                        if (nextLine.indexOf(":") == -1)
                                            i = Integer.parseInt(nextLine.substring(keyLength).trim());
                                        else
                                            i = Integer.parseInt(nextLine.substring(keyLength, nextLine.indexOf(":")).trim());
                                        if (i > max) max = i;
                                    } catch (NumberFormatException e) {
                                        System.out.println(nextLine);
                                    }
                                }
                                break;
                            }
                        }
                        if (keyFoundFlag) {
                            keyFoundFlag = false;
                        } else {
                            row.append("0,");
                        }

                    }
                    if (flag) {
                        out.println(minutesRow);
                        flag = false;
                    }
                    row.insert(0, ",");
                    row.insert(0, max);


                    //System.out.println(row);
                    out.println(row);
                    out.flush();


                }


            }
//            out.println("-------------------");
        }
        out.close();
    }

    public static List<String> allKeys() throws Exception{



        Set<String> all = new HashSet<>();
        List<String> allList=new ArrayList<>();

        File[] days = new File("./debugarchive").listFiles();
        for (File d : days) {
            Integer max = 0;


            File[] minutes = new File("./debugarchive/" + d.getName()).listFiles();
            for (File minute : minutes) {
                byte[] encoded = Files.readAllBytes(Paths.get(minute.getAbsolutePath()));
                String content =  new String(encoded);
                Matcher m1 = Pattern.compile("key=\\d+@PROXY, size=\\d+").matcher(content);
                Matcher m2 = Pattern.compile("key=\\d+, size=\\d+").matcher(content);
                while (m1.find()) {
                    String temp=m1.group();
                    all.add(temp.substring(0,temp.indexOf(",")));

                }
                while (m2.find()) {
                    String temp=m2.group();
                    all.add(temp.substring(0,temp.indexOf(",")));

                }
            }
        }
        System.out.println(all.size());
        allList.addAll(all);
        Collections.sort(allList, new Comparator<String>(){
            @Override
            public int compare(String obj0, String obj1) {
                return obj0.length() - obj1.length();
            }
        });
        for( String entry : allList){
            System.out.println(entry);
        }

        return allList;
    }
}
