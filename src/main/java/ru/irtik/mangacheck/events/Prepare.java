package ru.irtik.mangacheck.events;

import ru.irtik.mangacheck.datamodel.MangaEntry;
import ru.irtik.mangacheck.datamodel.MangaReaderSite;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

public class Prepare {

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
        Properties properties = getProperties();
        if (properties != null) {
            return new MangaReaderSite().withUrl(properties.getProperty("web.baseURL"));
        } else {
            return null;
        }
    }

    public static List<MangaEntry> readMangaList(String fileName) {
        JSONHelper jsonHelper = new JSONHelper(fileName);
        return jsonHelper.readJSONFile();
    }

}
