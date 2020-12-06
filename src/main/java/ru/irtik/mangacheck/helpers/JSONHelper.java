package ru.irtik.mangacheck.helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import ru.irtik.mangacheck.datamodel.MangaEntry;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONHelper {

    private String filePath;

    public JSONHelper(String filePath) {
        this.filePath = filePath;
    }

    public List<MangaEntry> readJSONFile() {
        try {
            JSONParser parser = new JSONParser();
            JSONArray jData = (JSONArray) parser.parse(getJsonData());
            return parseMangaEntries(jData);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private String getJsonData() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.availableCharsets().get("UTF-8"));
            lines.forEach(builder::append);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    private List<MangaEntry> parseMangaEntries(JSONArray jData) {
        List<MangaEntry> mangaEntries = new ArrayList<>();
        for (Object jItem : jData) {
            MangaEntry mangaEntry = changeToMangaEntry(jItem);
            mangaEntries.add(mangaEntry);
        }
        return mangaEntries;
    }

    private MangaEntry changeToMangaEntry(Object jItem) {
        JSONObject jMangaEntry = (JSONObject) jItem;
        String title = (String) jMangaEntry.get("title");
        return new MangaEntry().withTitle(title);
    }
}
