package ru.irtik.mangacheck.events;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.irtik.mangacheck.datamodel.MangaEntry;
import ru.irtik.mangacheck.datamodel.MangaReaderSite;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SiteCheck {

    private static Document getHTML(MangaReaderSite mangaSite) {
        try {
            return Jsoup.parse(new URL(mangaSite.getUrl()).openStream(), "Windows-1251", mangaSite.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void checkNewStuff(MangaReaderSite mangaSite, List<MangaEntry> mangaList) {
        Document document = getHTML(mangaSite);
        Elements elements = document.select("div.simple-tile");
        List<String> titles = new ArrayList<>();
        List<String> links = new ArrayList<>();
        String title;

        for (Element element : elements) {
            title = element.attr("title");
            titles.add(title);
            for (MangaEntry mangaEntry : mangaList) {
                if (title.equals(mangaEntry.getTitle())) {
                    links.add(element.attr("a"));
                }
            }
        }
        System.out.println(elements);
        System.out.println(titles);
        System.out.println(links);
    }

}
