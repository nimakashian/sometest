package testsoap.client;

import testsoap.service.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SoapMtServiceService soapMtServiceService = new SoapMtServiceService();
        SoapMtService service = soapMtServiceService.getSoapMtServicePort();
//        List<MtMessage> messages = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            MtMessage message = new MtMessage();
//            message.setDestAddress("9129371813");
//            if (i == 2)
//                message.setSrcAddress("900011");
//            else
//                message.setSrcAddress("90001"+i);
//            message.setTextMessage("hi morteza " + i);
//            message.setDueDate("2020-01-01 12:02:03");
//            messages.add(message);
//        }
//
//        List<MtResponse> mtResponse = service.submitBlock(messages);
//
//        String str = "";
//        for (MtResponse r : mtResponse) {
//            str = str + "," + r.getId();
//        }
//        System.out.println(str);


//        -----------------get state---------------
//        String key="8";
//        MtDelivery mtDelivery = service.getMessageStatus(key);
//        System.out.println(mtDelivery.getStatuString());

//        List<String> keys = new ArrayList<>();
//        keys.add("56");
//        keys.add("53");
//        keys.add("52");
//        List<MtDelivery> mtDelivery = service.getMessageBulkStatus(keys);
//        mtDelivery.forEach(mtDelivery1 -> System.out.println(mtDelivery1.getMessageId() + ":" + mtDelivery1.getMessageStatus()));


        //---------------submit ----------------------------
//        MtMessage message = new MtMessage();
//        message.setDestAddress("989129371813");
//        //default 982000 in app.properties
//        message.setTextMessage("soap test no 7777" );
//        java.text.SimpleDateFormat formatd = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = formatd.format( new Date()   );
//        message.setDueDate(dateString);
//        MtResponse mtsubmited= service.submitMessage(message);
//        System.out.println(mtsubmited.getId());


//        ----------------------submit bulk ------------------------
//        String[] dests={"9893548890782","989197943188","989129371813","989124777431","989024777440","989131151813"};
        String[] dests={"989129371813","989129252132",};
        List<MtMessage> messages = new ArrayList<>();
        for(String dest: dests) {
            MtMessage message = new MtMessage();
            message.setDestAddress(dest);
//            message.setSrcAddress("982000");
            message.setTextMessage("سلام، این پیام به منظور تست وب سرویس است. هر هر.");
            java.text.SimpleDateFormat formatd = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatd.format( new Date()   );
            message.setDueDate(dateString);
            messages.add(message);
        }
        List<MtResponse> mtResponse = service.submitBulkMessage(messages);
        mtResponse.forEach(mtResponse1 -> System.out.println(mtResponse1.getId()));

    }
}
