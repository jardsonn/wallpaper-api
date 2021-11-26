package com.jcs.wallpaperapi.service;

import com.jcs.wallpaperapi.model.Category;
import com.jcs.wallpaperapi.utils.Utils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.jcs.wallpaperapi.utils.Utils.MAIN_PAGE;
import static com.jcs.wallpaperapi.utils.Utils.URL_BASE;

@Service
public class CategoryService {

    public List<Category> getAllCategories() {
        try {
            Document doc = Utils.decument(URL_BASE, MAIN_PAGE);
            Elements categories = doc.select("div.panel.panel-default a.list-group-item.cat_list").not("a#res_link");
            return categories.stream().map(element -> new Category.Builder()
                    .setName(element.text().replace((element.select("span").text().trim()), ""))
                    .setQuantity(Integer.parseInt(element.select("span").text().trim()))
                    .setUrl("/api/v1/wallpaper" + element.attr("href"))
                    .build()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
