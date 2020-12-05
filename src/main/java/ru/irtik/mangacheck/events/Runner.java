package ru.irtik.mangacheck.events;

import ru.irtik.mangacheck.datamodel.MangaEntry;
import ru.irtik.mangacheck.datamodel.MangaReaderSite;

import java.util.List;

public class Runner {

    private static final String JSONFILE_PATH = "src/main/resources/MangaEntryList.json";

    public static void main(String[] args) {
        MangaReaderSite readmanga = Prepare.defineMangaReaderSite();
        if (readmanga != null) {
            System.out.println(readmanga.getUrl());
        } else {
            System.out.println("MangaReaderSite definition gone wrong - URL not identified!");
        }

        List<MangaEntry> mangaList = Prepare.readMangaList(JSONFILE_PATH);
        for (MangaEntry entry : mangaList) {
            System.out.println(entry.getTitle());
        }

//        SiteCheck.checkNewStuff(readmanga, mangaList);
    }
}
