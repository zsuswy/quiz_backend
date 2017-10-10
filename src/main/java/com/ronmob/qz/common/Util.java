package com.ronmob.qz.common;

import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.vo.SearchVo;
import com.ronmob.qz.web.SurveyController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建时间：9/22/17
 * 创建人：sunwuyang
 */
public class Util {
    private static Log logger = LogFactory.getLog(SurveyController.class);

    public static Date getDateFromString(String dateString) throws ParseException {
        String pattern = "yyyy-MM-dd";

        if (dateString.length() > 10)
            pattern = "yyyy-MM-dd hh:mm:ss";

        return getDateFromString(dateString, pattern);
    }


    public static Date getDateFromString(String dateString, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(dateString);
        return date;
    }

    public static Page getPageFromSearchVo(SearchVo searchVo) {
        Page page = null;
        if (searchVo.getPage() != null) {
            page = new Page();
            page.setPageNO(searchVo.getPage().getPageNO());
            page.setEveryPageCount(searchVo.getPage().getEveryPageCount());
        }
        return page;
    }

    public static Byte getByte(String s) {
        int c;
        try {
            c = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            double d = Double.parseDouble(s);
            c = (int) d;
        }

        return (byte) c;
    }


    public static Integer getInteger(String s) {
        int c;
        try {
            c = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            double d = Double.parseDouble(s);
            c = (int) d;
        }
        return c;
    }

    public final static String getIpAddress(HttpServletRequest request) throws IOException {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

        String ip = request.getHeader("X-Forwarded-For");
        if (logger.isInfoEnabled()) {
            logger.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
                }
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}
