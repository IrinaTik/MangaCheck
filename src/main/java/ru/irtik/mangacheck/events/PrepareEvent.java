package ru.irtik.mangacheck.events;

import com.google.gson.Gson;
import ru.irtik.mangacheck.datamodel.MangaEntry;
import ru.irtik.mangacheck.datamodel.MangaReaderSite;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PrepareEvent {

    private static Properties getProperties() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(new File("src\\main\\resources\\local.properties")));
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MangaReaderSite defineMangaReaderSite() {
        try {
            Properties properties = getProperties();
            assert properties != null;
            return new MangaReaderSite().withUrl(properties.getProperty("web.baseURL"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Look at properties file");
        }
        return null;
    }

    public static List<MangaEntry> readMangaList(String fileName) {
        List<MangaEntry> mangaEntries = new ArrayList<>();

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            MangaEntry[] entries = gson.fromJson(reader, MangaEntry[].class);
            mangaEntries = Arrays.asList(entries);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mangaEntries;
    }

    public static void main(String[] args) {
        MangaReaderSite readmanga = defineMangaReaderSite();
        if (readmanga != null) {
            System.out.println(readmanga.getUrl());
        } else {
            System.out.println("MangaReaderSite definition gone wrong - URL not identified!");
        }

        List<MangaEntry> mangaList = readMangaList("src\\main\\resources\\MangaEntryList.json");
        for (MangaEntry entry : mangaList) {
            System.out.println(entry.getTitle());
        }

    }
}
