package com.example.heip_d.com.example;

import java.util.UUID;

public class UUidUtils {
     public static String getUUid(){
        return          UUID.randomUUID().toString().replaceAll("-","");
     }
}
