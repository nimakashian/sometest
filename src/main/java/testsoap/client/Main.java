package testsoap.client;

import testsoap.service.MtMessage;
import testsoap.service.MtResponse;
import testsoap.service.SoapMtService;
import testsoap.service.SoapMtServiceService;

public class Main {
    public static void main(String[] args) {
        SoapMtServiceService soapMtServiceService= new SoapMtServiceService();
        SoapMtService service=soapMtServiceService.getSoapMtServicePort();
        MtResponse mtResponse=service.submitMessage(new MtMessage("34535","678678","gfsdfsf","wewerwe"));
        System.out.println(mtResponse.getId());
    }
}
