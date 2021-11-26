package com.jcs.wallpaperapi.service;

import com.jcs.wallpaperapi.model.*;
import com.jcs.wallpaperapi.utils.Utils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static com.jcs.wallpaperapi.utils.Utils.*;

@Service
public class WallpapersService {

    public List<Wallpaper> getWallpaper(String params) {
        try {
            Document doc = Utils.decument(URL_BASE + params, MAIN_PAGE);

            Elements container = doc.select(".container");
            Elements relatedWallpapers = container.select("div.col-lg-12.col-md-12.col-sm-6.col-xs-12");
            Elements differentResolutions = container.select("div.list-group .panel-body").select("a");
            List<DifferentResolutions> differentResolutionList =
                    differentResolutions.stream().map(element -> new DifferentResolutions.Builder()
                            .setResolutions(element.text())
                            .setUrl(container.select(".wallpaper a")
                                    .attr("href")
                                    .replace("wallpapers", "download")
                                    .replace(".jpg", "-" + element.text() + ".jpg"))
                            .build()).collect(Collectors.toList());

            List<RelatedWallpapers> relatedWallpapersList =
                    relatedWallpapers.stream().map(element -> new RelatedWallpapers.Builder()
                            .setTitle(element.select("img").attr("title"))
                            .setUrl("/api/v1/wallpaper" + element.select("a").attr("href"))
                            .setThumbUrl(element.select("img").attr("src"))
                            .build()).collect(Collectors.toList());

            String author = Objects.requireNonNull(container.select("a.btn-link.btn-link").last()).tagName("i").text();
            String linkAuthor = container.select("i").attr("href");

            return List.of(new Wallpaper.Builder()
                    .setTitle(container.select("h1").text().trim())
                    .setUrl(container.select(".wallpaper a").attr("href"))
                    .setPublicationDate(getData(container.select("footer").text()))
                    .setCategoty(container.select("ol.breadcrumb > li").get(1).text())
                    .setRelatedWallpapers(relatedWallpapersList)
                    .setAuthorName(author.equals("Add Author") ? "Não atribuido" : author)
                    .setAuthorNamePortfolioLink(linkAuthor.contains("addauthor") ? "" : linkAuthor)
                    .setDifferentResolutions(differentResolutionList)
                    .build());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public List<Wallpapers> getWallpapersByCategory(String category) {
        return allWallpapers(URL_BASE + PARAMS_CATEGORY + category, MAIN_PAGE);
    }

    public List<Wallpapers> getWallpapers() {
        return allWallpapers(URL_BASE, MAIN_PAGE);
    }

    public List<Wallpapers> getPopularWallpapers() {
        return allWallpapers(URL_BASE + PARAMS_POPULAR, MAIN_PAGE);
    }

    public List<Wallpapers> getRandomWallpapers(int numberRandom) {
        return allWallpapers(URL_BASE + PARAMS_RANDOM, numberRandom);
    }

    public List<Wallpapers> getWallpapersByPage(int pageNumber) {
        return allWallpapers(URL_BASE + PARAMS_BY_PAGE, pageNumber);
    }

    public List<Wallpapers> getPopularWallpapersByPage(int pageNumber) {
        return allWallpapers(URL_BASE + PARAMS_POPULAR_PAGE, pageNumber);
    }

    public List<Wallpapers> getSearchResults(String query) {
        return allWallpapers(URL_BASE + PARAMS_SEARCH + query, MAIN_PAGE);
    }

    private List<Wallpapers> allWallpapers(String url, int action) {
        try {
            Document doc = Utils.decument(url, action);
            Elements imageCantainer = doc.select(".wallpapers_container");
            Elements images = imageCantainer.select(".column_padding");
            return images.stream().map(element -> new Wallpapers.Builder()
                    .url("/api/v1/wallpaper" + element.select("a.caption").attr("href"))
                    .urlThumb(element.select("img.thumbnail ").attr("src"))
                    .subtitle(element.select("a.caption").text())
                    .build()).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

}
