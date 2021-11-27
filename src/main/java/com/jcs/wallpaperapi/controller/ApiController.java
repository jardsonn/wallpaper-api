package com.jcs.wallpaperapi.controller;

import com.jcs.wallpaperapi.model.Category;
import com.jcs.wallpaperapi.model.Wallpaper;
import com.jcs.wallpaperapi.model.Wallpapers;
import com.jcs.wallpaperapi.service.CategoryService;
import com.jcs.wallpaperapi.service.WallpapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    private ResponseEntity<List<Wallpapers>> index() {
        return new ResponseEntity<>(wallpapersService.getWallpapers(), HttpStatus.OK);
    }

    @GetMapping("/wallpaper/random-wallpapers")
    private ResponseEntity<List<Wallpapers>> getRandomWallpapers() {
        return new ResponseEntity<>(wallpapersService.getRandomWallpapers(new Random().nextInt(Integer.MAX_VALUE)), HttpStatus.OK);
    }

    @GetMapping("/wallpaper/popular-wallpapers")
    private ResponseEntity<List<Wallpapers>> getPopularWallpapers() {
        return new ResponseEntity<>(wallpapersService.getPopularWallpapers(), HttpStatus.OK);
    }

    @GetMapping("wallpaper/{wallpaperUrl}")
    private ResponseEntity<List<Wallpaper>> getWallpaper(@PathVariable("wallpaperUrl") String params) {
        return new ResponseEntity<>(wallpapersService.getWallpaper(params), HttpStatus.OK);
    }

    @GetMapping("wallpaper")
    private ResponseEntity<List<Wallpapers>> getWallpapers() {
        return new ResponseEntity<>(wallpapersService.getWallpapers(), HttpStatus.OK);
    }

    @GetMapping("wallpaper/page={pageNumber}")
    private ResponseEntity<List<Wallpapers>> getWallpapersByPage(@PathVariable("pageNumber") int pageNumber) {
        return new ResponseEntity<>(wallpapersService.getWallpapersByPage(pageNumber), HttpStatus.OK);
    }

    @GetMapping("wallpaper/popular-wallpapers/page={pageNumber}")
    private ResponseEntity<List<Wallpapers>> getPopularWallpapersByPage(@PathVariable("pageNumber") int pageNumber) {
        return new ResponseEntity<>(wallpapersService.getPopularWallpapersByPage(pageNumber), HttpStatus.OK);
    }

    @GetMapping("/category")
    private ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/category/{categoryName}/page={pageNumber}")
    private ResponseEntity<List<Wallpapers>> getWallpapersCategoryByPage(@PathVariable("categoryName") String categoryName, @PathVariable("pageNumber") int pageNumber) {
        return new ResponseEntity<>(wallpapersService.getWallpapersCategoryByPage(categoryName, pageNumber), HttpStatus.OK);
    }

    @GetMapping("/wallpaper/category/{categoryName}")
    private ResponseEntity<List<Wallpapers>> getWallpapersByCategory(@PathVariable("categoryName") String category) {
        return new ResponseEntity<>(wallpapersService.getWallpapersByCategory(category), HttpStatus.OK);
    }

    // search={query}&page=2 for search by page
    @GetMapping("/search={query}")
    private ResponseEntity<List<Wallpapers>> getSearchResults(@PathVariable("query") String query) {
        return new ResponseEntity<>(wallpapersService.getSearchResults(query), HttpStatus.OK);
    }


}
