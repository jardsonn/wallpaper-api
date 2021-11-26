package com.jcs.wallpaperapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RelatedWallpapers {
    private final String title;
    private final String thumbUrl;
    private final String url;

    public String getTitle() {
        return title;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getUrl() {
        return url;
    }

    private RelatedWallpapers(Builder builder) {
        this.title = builder.title;
        this.thumbUrl = builder.thumbUrl;
        this.url = builder.url;
    }

    public static class Builder {
        private String title;
        private String thumbUrl;
        private String url;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public RelatedWallpapers build(){
            return new RelatedWallpapers(this);
        }
    }
}
