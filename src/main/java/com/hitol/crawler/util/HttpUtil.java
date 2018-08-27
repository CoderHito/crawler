package com.hitol.crawler.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class HttpUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static final String VERIFY_URL = "http://www.baidu.com/";

    /**
     * 验证代理是否可用
     *
     * @param ip
     * @param port
     * @return
     */
    public static boolean verifyProxy(String ip, int port) {
        boolean useful;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(VERIFY_URL);
            InetSocketAddress addr = new InetSocketAddress(ip, port);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
            connection = (HttpURLConnection) url.openConnection(proxy);
            connection.setConnectTimeout(4 * 1000);
            connection.setInstanceFollowRedirects(false);
            connection.setReadTimeout(6 * 1000);
            int rCode = connection.getResponseCode();
            useful = rCode == 200;
        } catch (IOException e1) {
            logger.warn(String.format("verify proxy %s:%d exception: " + e1.getMessage(), ip, port));
            useful = false;
        } finally {
            if (connection != null) connection.disconnect();
        }

        logger.info(String.format("verify proxy %s:%d useful: " + useful, ip, port));
        return useful;
    }

    public static int getResponseCode(String address) throws Exception {
        StringBuffer html = new StringBuffer();
        String result = null;
        URL url = new URL(address);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)");

        connection.setConnectTimeout(4 * 1000);
        connection.setInstanceFollowRedirects(false);
        connection.setReadTimeout(6 * 1000);
        return connection.getResponseCode();
    }
}
