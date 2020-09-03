package ru.irtik.mangacheck.datamodel;

import java.util.Objects;

public class MangaReaderSite {
    private String url;

    public String getUrl() {
        return url;
    }

    public MangaReaderSite withUrl(String url) {
        if (url != null) {
            this.url = url;
            return this;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "MangaReaderSite{" +
                "url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MangaReaderSite that = (MangaReaderSite) o;
        return url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
