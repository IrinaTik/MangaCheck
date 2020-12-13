package ru.irtik.mangacheck.helpers;

import ru.irtik.mangacheck.datamodel.MangaEntry;

import javax.swing.*;
import java.util.Set;

public class MainGUIForm extends JFrame {

    private static final String MAINFRAIM_TITLE = "Manga Check";
    private static final int MAINFRAIM_WIDHT = 600;
    private static final int MAINFRAIM_HEIGHT = 400;
    private static Set<MangaEntry> mangaList;

    private JList<String> mangaListGUI;
    private JButton buttonDisplayList;

    public MainGUIForm(Set<MangaEntry> inputMangaList) {
        super();
        mangaList = inputMangaList;
        createAndShowGUI();
    }


    public void createAndShowGUI() {
        JFrame frame = new JFrame(MAINFRAIM_TITLE);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(MAINFRAIM_WIDHT, MAINFRAIM_HEIGHT);
        frame.setLocationRelativeTo(null);

        fillMangaListGUI();
        JPanel contentPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(mangaListGUI);
        contentPanel.add(scrollPane);
        frame.add(contentPanel);

//        frame.pack();
        frame.setVisible(true);

    }

    private void fillMangaListGUI() {
        String[] mangaTitleArray = mangaList.stream()
                .map(MangaEntry::getTitle).toArray(String[]::new);
        mangaListGUI = new JList<>(mangaTitleArray);
    }

}
