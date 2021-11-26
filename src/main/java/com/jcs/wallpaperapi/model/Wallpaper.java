package com.jcs.wallpaperapi.model;

import java.util.List;

public class Wallpaper {
    private final String title;
    private final String url;
    private final String publicationDate;
    private final String authorName;
    private final String authorPortfolioLink;
    private final String category;
    private final List<RelatedWallpapers> relatedWallpapers;
    private final List<DifferentResolutions> differentResolutions;

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorPortfolioLink() {
        return authorPortfolioLink;
    }

    public String getCategory() {
        return category;
    }

    public List<RelatedWallpapers> getRelatedWallpapers() {
        return relatedWallpapers;
    }

    public List<DifferentResolutions> getDifferentResolutions() {
        return differentResolutions;
    }

    private Wallpaper(Builder builder) {
        this.title = builder.title;
        this.url = builder.url;
        this.publicationDate = builder.publicationDate;
        this.authorName = builder.authorName;
        this.authorPortfolioLink = builder.authorNamePortfolioLink;
        this.category = builder.category;
        this.relatedWallpapers = builder.relatedWallpapers;
        this.differentResolutions = builder.differentResolutions;

    }

    public static class Builder {
        private String title;
        private String url;
        private String publicationDate;
        private String authorName;
        private String authorNamePortfolioLink;
        private String category;
        private List<RelatedWallpapers> relatedWallpapers;
        private List<DifferentResolutions> differentResolutions;

        public Builder setAuthorName(String authorNamePortfolioLink) {
            this.authorName = authorNamePortfolioLink;
            return this;
        }

        public Builder setAuthorNamePortfolioLink(String authorNamePortfolioLink) {
            this.authorNamePortfolioLink = authorNamePortfolioLink;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setPublicationDate(String publicationDate) {
            this.publicationDate = publicationDate;
            return this;
        }

        public Builder setCategoty(String category) {
            this.category = category;
            return this;
        }


        public Builder setRelatedWallpapers(List<RelatedWallpapers> relatedWallpapers) {
            this.relatedWallpapers = relatedWallpapers;
            return this;
        }

        public Builder setDifferentResolutions(List<DifferentResolutions> differentResolutions) {
            this.differentResolutions = differentResolutions;
            return this;
        }

        public Wallpaper build() {
            return new Wallpaper(this);
        }
    }


}
