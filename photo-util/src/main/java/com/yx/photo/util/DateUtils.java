package com.yx.photo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 * @author yangxiang
 * @date 2018/6/20 10:35
 */
public class DateUtils {

    /**
     * 获取两个日期之间的日期
     * @param start 开始日期
     * @param end 结束日期
     * @return 日期集合
     */
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    /**
     * 将时间字符串按指定的时间格式转为日期格式
     * @author yangxiang
     * @date 2018/6/20 10:45
     * @param dateStr 时间字符串
     * @param formate 时间格式
     * @return
     */
    public static Date getStrToDate(String dateStr,String formate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        Date date = sdf.parse(dateStr);
        return date;
    }

    /**
     * 将时间日期按指定的时间格式转为日期字符串
     * @author yangxiang
     * @date 2018/6/20 11:07
     * @param
     * @return
     */
    public static String getDateToStr(Date date,String formate){
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        String dateStr = sdf.format(date);
        return dateStr;
    }
}
