package com.company;

import javax.imageio.metadata.IIOInvalidTreeException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class Main {

    public static void main(String[] args) throws IOException, InvalidCommandException {
	// write your code here
        /*Main app = new Main();
        app.testCreateSave();
        app.testLoadView();

         */
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(Main.class, "");
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Catalog catalog = new Catalog("My Books", "d:/media/catalog.ser");
        Command command;

        while(true){
            // Enter data using BufferReader
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.println("Introdu o comanda");

            // Reading data using readLine
            String cmd = reader.readLine();
            if (cmd.equals("add"))
            {
                command = new AddCommand(catalog);
            }
            else if(cmd.equals("list"))
            {
                command = new ListCommand(catalog);
            }
            else if(cmd.equals("play"))
            {
                command = new PlayCommand(catalog);
            }
            else if(cmd.equals("load"))
            {
                command = new LoadCommand(catalog);
            }
            else if(cmd.equals("save"))
            {
                command = new SaveCommand(catalog);
            }
            else if(cmd.equals("report"))
            {
                command = new ReportCommand(catalog, cfg);
            }
            else
            {
                throw new InvalidCommandException(new Exception("Invalid command"));
            }
            command.Execute();
        }
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("My Books", "d:/media/catalog.ser");
        var song = new Song("bestArtis", "BestAlbum", "BestSong", "d:/java/song.mp3" );
        var book = new Book("bestAutor", "bestEditura", "bestBook", "d:/java/book.pdf" );
        catalog.add(song);
        catalog.add(book);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("d:/java/catalog.ser");
            CatalogUtil.play(catalog.findById("BestSong"));
            }
        catch (InvalidCatalogException e) {
            System.out.println(e);
        }
    }


}
