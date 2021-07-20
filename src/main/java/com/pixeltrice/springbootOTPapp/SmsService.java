package com.pixeltrice.springbootOTPapp;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
	public class SmsService {

	    
	    private final String ACCOUNT_SID ="AC06f3c3bd1ca7192e7035bab214c97777";

	    private final String AUTH_TOKEN = "4c85f8a066366616097abf02cb7a16b2";

	    private final String FROM_NUMBER = "+13473912842";

	    public void send(SmsPojo sms) {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

	    }

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	
}
