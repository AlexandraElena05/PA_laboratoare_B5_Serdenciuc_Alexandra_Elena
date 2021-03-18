package com.company;

import javax.imageio.metadata.IIOInvalidTreeException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
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
