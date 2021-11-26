package com.jcs.wallpaperapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DifferentResolutions {
    private final String resolutions;
    private final String url;

    public String getResolutions() {
        return resolutions;
    }

    public String getUrl() {
        return url;
    }

    private DifferentResolutions(Builder builder) {
        this.resolutions = builder.resolutions;
        this.url = builder.url;
    }

    public static class Builder {
        private String resolutions;
        private String url;

        public Builder setResolutions(String resolutions) {
            this.resolutions = resolutions;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public DifferentResolutions build() {
            return new DifferentResolutions(this);
        }
    }
}
