package ru.irtik.mangacheck.helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import ru.irtik.mangacheck.datamodel.MangaEntry;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class JSONHelper {

    private String filePath;
    private Gson gson;

    public JSONHelper(String filePath) {
        this.filePath = filePath;
        this.gson = new Gson();
    }

    public Set<MangaEntry> readJSONFile() {
        try {
            JsonReader reader = new JsonReader(new FileReader(filePath));
            Map<String, List<String>> mangaInfo = gson.fromJson(reader, new TypeToken<Map<String, List<String>>>(){}.getType());
            Set<MangaEntry> entries = new TreeSet<>(Comparator.comparing(MangaEntry::getTitle));
            mangaInfo.get("titles").forEach(title -> entries.add(new MangaEntry().withTitle(title)));
            System.out.println("over");
            return entries;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
