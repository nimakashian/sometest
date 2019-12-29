package searchkeyword.allmatches;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Map<String,String> all=new HashMap<String,String>();
        String theString = "[key=4335, size=1] [key=4335, size=1] [key=3793@PROXY, size=11594] [key=3804, size=26]  ";

        List<String> allMatches = new ArrayList<String>();
        Matcher m1 = Pattern.compile("key=\\d+@PROXY, size=\\d+").matcher(theString);
        Matcher m2 = Pattern.compile("key=\\d+, size=\\d+").matcher(theString);
        while (m1.find()) {
            String temp=m1.group();
            allMatches.add(temp);
            all.put(temp.substring(0,temp.indexOf(",")),temp.substring(temp.indexOf(",")+7));
            System.out.println(m1.group());
        }
        while (m2.find()) {
            String temp=m2.group();
            allMatches.add(temp);
            all.put(temp.substring(0,temp.indexOf(",")),temp.substring(temp.indexOf(",")+7));
            System.out.println(temp);
        }
        System.out.println(all.size());
        for( Map.Entry<String,String> entry : all.entrySet()){
            System.out.println(entry.getKey()+ "  >>>> "+entry.getValue());
        }
    }

}
