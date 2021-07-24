package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service
public class StudentServiceImpl {

public void SMS(String name) {
	String ACCOUNT_SID =
            "AC2de808e86e04d8c0309dff859388cd03";
  String AUTH_TOKEN =
            "c61ce2ddd8eb1b380a14f3925b093b82";
  	String msg="New Entry - NAME : "+name;
  	

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+919096904640"), // to
                        new PhoneNumber("+17275131648"), // from
                        msg)
                .create();
}

}
