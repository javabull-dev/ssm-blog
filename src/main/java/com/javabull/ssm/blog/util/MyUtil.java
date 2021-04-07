package com.javabull.ssm.blog.util;

import cn.hutool.http.HtmlUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {

    public static String formatDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static Date parse(String dateString, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String createSummaryText(String htmlText) {
        String summaryText = HtmlUtil.cleanHtmlTag(htmlText);
        if (summaryText.length() > 250) {
            summaryText = summaryText.substring(0, 250);
        } else {
            summaryText += String.format("%" + (250 - summaryText.length()) + "s", "&nbsp;");
        }
        return summaryText;
    }
}
