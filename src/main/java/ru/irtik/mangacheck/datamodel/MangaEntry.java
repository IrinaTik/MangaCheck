package ru.irtik.mangacheck.datamodel;

import java.util.Objects;

public class MangaEntry {

    private String title;
    private int chapterCount;
    private int lastChapter;
    private MangaStatus status;

    public String getTitle() {
        return title;
    }

    public MangaEntry withTitle(String title) {
        this.title = title;
        return this;
    }

    public int getChapterCount() {
        return chapterCount;
    }

    public MangaEntry withChapterCount(int chapterCount) {
        this.chapterCount = chapterCount;
        return this;
    }

    public int getLastChapter() {
        return lastChapter;
    }

    public MangaEntry withLastChapter(int lastChapter) {
        this.lastChapter = lastChapter;
        return this;
    }

    public MangaStatus getStatus() {
        return status;
    }

    public MangaEntry withStatus(MangaStatus status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MangaEntry that = (MangaEntry) o;
        return chapterCount == that.chapterCount &&
                lastChapter == that.lastChapter &&
                title.equals(that.title) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, chapterCount, lastChapter, status);
    }

    @Override
    public String toString() {
        return "MangaEntry{" +
                "title='" + title + '\'' +
                '}';
    }
}
