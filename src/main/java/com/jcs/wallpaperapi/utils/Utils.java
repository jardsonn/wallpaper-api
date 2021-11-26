package com.jcs.wallpaperapi.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Utils {
    public static final int MAIN_PAGE = -1;
    public static final String URL_BASE = "https://hdqwalls.com/";
    public static final String PARAMS_BY_PAGE = "latest-wallpapers/page/";
    public static final String PARAMS_RANDOM = "random-wallpapers/";
    public static final String PARAMS_POPULAR = "popular-wallpapers/";
    public static final String PARAMS_POPULAR_PAGE = "popular-wallpapers/page/";
    public static final String PARAMS_CATEGORY = "category/";
    public static final String PARAMS_SEARCH = "search?q=";

    public static Document decument(String url, int acion) throws IOException {
        Connection conn;
        if (acion == MAIN_PAGE)
            conn = Jsoup.connect(url).timeout(5000);
        else {
            if (url.equals(URL_BASE)) {
                conn = Jsoup.connect(url).timeout(5000);
            }
            else if (url.contains(PARAMS_BY_PAGE)) {
                conn = Jsoup.connect(url + PARAMS_BY_PAGE + acion).timeout(5000);
            }
            else if (url.contains(PARAMS_RANDOM)) {
                conn = Jsoup.connect(url + acion).timeout(5000);
            }else if (url.contains(PARAMS_POPULAR)) {
                conn = Jsoup.connect(url + acion).timeout(5000);
            } else if (url.contains(PARAMS_POPULAR_PAGE)) {
                conn = Jsoup.connect(url + acion).timeout(5000);
            } else {
                conn = Jsoup.connect(url).timeout(5000);
            }
        }
        int statusCode = conn.execute().statusCode();
        if (statusCode == 200) {
            return conn.get();
        } else {
            throw new IOException("Ocorreu um erro com codigo: " + statusCode);
        }

    }

    public static String getData(String text) {
        return text.substring(text.indexOf("on") + 3, text.indexOf("|")).trim();
    }
}
