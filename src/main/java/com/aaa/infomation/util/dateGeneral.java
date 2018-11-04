package com.aaa.infomation.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateGeneral {

    public static String GetNowDate() {
        String temp_str = "";
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
        temp_str = sdf.format(dt);
        return temp_str;
    }
}