package com.jcs.wallpaperapi.model;

public class Wallpapers {
    private final String url;
    private final String thumbUrl;
    private final String subtitle;

    public String getUrl() {
        return url;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getSubtitle() {
        return subtitle;
    }

    private Wallpapers(Builder builder) {
        this.url = builder.url;
        this.thumbUrl = builder.urlThumb;
        this.subtitle = builder.subtitle;
    }

    public static class Builder {
        private String url;
        private String urlThumb;
        private String subtitle;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder urlThumb(String urlThumb) {
            this.urlThumb = urlThumb;
            return this;
        }

        public Builder subtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public Wallpapers build(){
            return new Wallpapers(this);
        }
    }

}
