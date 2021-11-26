package com.jcs.wallpaperapi.model;

public class Category {
    private final String name;
    private final int quantity;
    private final String url;

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUrl() {
        return url;
    }

    private Category(Builder builder) {
        this.name = builder.name;
        this.quantity = builder.quantity;
        this.url = builder.url;
    }

    public static class Builder {
        private String name;
        private int quantity;
        private String url;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
