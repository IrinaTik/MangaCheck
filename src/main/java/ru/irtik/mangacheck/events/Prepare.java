package ru.irtik.mangacheck.events;

import ru.irtik.mangacheck.datamodel.MangaEntry;
import ru.irtik.mangacheck.datamodel.MangaReaderSite;
import ru.irtik.mangacheck.helpers.JSONHelper;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;

public class Prepare {

    private static final String PROPERTIES_FILE = "src/main/resources/local.properties";

    private static Properties getProperties() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(new File(PROPERTIES_FILE)));
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

    public static Set<MangaEntry> readMangaList(String fileName) {
        JSONHelper jsonHelper = new JSONHelper(fileName);
        return jsonHelper.readJSONFile();
    }

}
