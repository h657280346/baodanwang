package com.yczc.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class GetID {

	public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
      }
	

}
