package com.jcs.wallpaperapi.controller;

import com.jcs.wallpaperapi.model.Wallpapers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/", method = GET)
public class RedirectController {
    @GetMapping
    private void redirect(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("api/v1");
    }

}
