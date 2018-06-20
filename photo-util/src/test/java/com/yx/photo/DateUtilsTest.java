package com.yx.photo;

import com.yx.photo.util.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类测试单元
 * @author yangxiang
 * @date 2018/6/20 10:36
 */
public class DateUtilsTest {

    @Test
    public void getBetweenDates() throws Exception{
            Date start = DateUtils.getStrToDate("2018-03-21","yyyy-MM-dd");
            Date end = DateUtils.getStrToDate("2018-04-02","yyyy-MM-dd");
            List<Date> list = DateUtils.getBetweenDates(start,end);
            System.out.println("个数:"+list.size());
            if(list.size() > 0){
                for(Date d : list){
                    System.out.println("时间："+DateUtils.getDateToStr(d,"yyyy-MM-dd"));
                }
            }
    }
}
