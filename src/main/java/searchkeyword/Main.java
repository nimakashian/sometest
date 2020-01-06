package searchkeyword;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        String[][] keysList ={
          /*0*/      {"updateEventRequests","updateEventsSize","pickedUpdateCount","finalizedCount","processedUpdateEvents","eventCommandAcceptedCount","eventCommandRejectedCount","eventCommandTimedOutCount","eventIOErrorCount","eventMessageDeliveredCount","eventMessageDeletedCount","eventMessageExpiredCount","eventMessageRejectedCount","eventMessageUndeliverableCount","eventUnknownCount","eventUnhandledCount","registered","cleared","relayReceivedDelivered","relayReceivedIOError","relayReceivedDeleted","relayReceivedExpired","relayReceivedRejected","relayReceivedUndeliverable","relayReceivedUnknown","nonCleared","relayed","relayReceived","asyncQSize","asyncQCapacity","eventCommandAcceptedNotFoundCount","eventCommandRejectedNotFoundCount","eventCommandTimedOutNotFoundCount","eventIOErrorNotFoundCount","eventMessageDeliveredNotFoundCount","eventMessageExpiredNotFoundCount","eventMessageRejectedNotFoundCount","eventMessageUndeliverableNotFoundCount","eventUnknownNotFoundCount"},
          /*1  */    {"updateEventCounter","deliveredCounter","acceptedCounter","undeliveredCounter","rejectedCounter","unknownCounter","deletedCounter","expiredCounter","unhandledCounter"},
          /*2 */    {"updateEventsSize"},
          /* 3 */    {"mtSubmitCounter","moSubmitCounter","messages.size()","submitIndex","submittedMessages.size()","mtSubmitSpeed","pduToMessageMapSize","commandHistorySize"},
          /*  4*/    {"y","size"},
          /*5 */    {"4016@PROXY", "2113@PROXY", "2361@PROXY", "453@PROXY" , "2736@PROXY", "4079@PROXY", "305@PROXY" , "2721@PROXY", "1534@PROXY", "2283@PROXY", "2216@PROXY", "1327@PROXY", "4041@PROXY", "1507@PROXY", "3793@PROXY", "2098@PROXY", "129@PROXY" , "2437@PROXY", "3829@PROXY", "2522@PROXY", "3744@PROXY", "1441@PROXY", "4260@PROXY", "3865@PROXY", "1148@PROXY", "4027@PROXY", "1323@PROXY", "4265@PROXY"},
          /* 6 */    {"retryCount"},
          /* 7 */    {"dirtyListSize"},
                /* 8 */ {"freeMemoryBytes"}
        };
        PrintWriter out = new PrintWriter("out.txt");
        boolean flag = true;

        int threshold = 1;
        String delimiter="=";
        String[] keys =keysList[8];

        for (int ii = 1; ii <= threshold; ii++) {
            boolean nameFlag = true;
            for (String s : keys) {

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
                            if (nextLine.contains(stemp) && nextLine.indexOf(stemp) == 0 && nextLine.indexOf(delimiter) == stemp.length()) {
                                if (iteration < ii) {
                                    iteration++;
                                    continue;
                                }
                                if (nextLine.indexOf(":") == -1)
                                    row.append(nextLine.substring(keyLength/*,nextLine.indexOf(",")*/) + ",");
                                else
                                    row.append(nextLine.substring(keyLength, nextLine.indexOf(":")) + ",");
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
}
