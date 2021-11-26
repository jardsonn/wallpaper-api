package com.jcs.wallpaperapi.controller;

import com.jcs.wallpaperapi.model.Category;
import com.jcs.wallpaperapi.model.Wallpaper;
import com.jcs.wallpaperapi.model.Wallpapers;
import com.jcs.wallpaperapi.service.CategoryService;
import com.jcs.wallpaperapi.service.WallpapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "api/v1", method = GET)
public class ApiController {

    @Autowired
    private WallpapersService wallpapersService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    private List<Wallpapers> index() {
        return wallpapersService.getWallpapers();
    }

    @GetMapping("/wallpaper/random-wallpapers")
    private List<Wallpapers> getRandomWallpapers() {
        return wallpapersService.getRandomWallpapers(new Random().nextInt(Integer.MAX_VALUE));
    }

    @GetMapping("/wallpaper/popular-wallpapers")
    private List<Wallpapers> getPopularWallpapers() {
        return wallpapersService.getPopularWallpapers();
    }

    @GetMapping("wallpaper/{page}")
    private List<Wallpaper> getWallpaper(@PathVariable("page") String params) {
        return wallpapersService.getWallpaper(params);
    }

    @GetMapping("wallpaper")
    private List<Wallpapers> getWallpapers() {
        return wallpapersService.getWallpapers();
    }

    @GetMapping("wallpaper/page={pageNumber}")
    private List<Wallpapers> getWallpapersByPage(@PathVariable("pageNumber") int pageNumber) {
        return wallpapersService.getWallpapersByPage(pageNumber);
    }

    @GetMapping("wallpaper/popular-wallpapers/page={pageNumber}")
    private List<Wallpapers> getPopularWallpapersByPage(@PathVariable("pageNumber") int pageNumber) {
        return wallpapersService.getPopularWallpapersByPage(pageNumber);
    }

    @GetMapping("/category")
    private List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/wallpaper/category/{categoryName}")
    private List<Wallpapers> getWallpapersByCategory(@PathVariable("categoryName") String category) {
        return wallpapersService.getWallpapersByCategory(category);
    }

    // search={query}&page=2 for search by page
    @GetMapping("/search={query}")
    private List<Wallpapers> getSearchResults(@PathVariable("query") String query) {
        return wallpapersService.getSearchResults(query);
    }


}
