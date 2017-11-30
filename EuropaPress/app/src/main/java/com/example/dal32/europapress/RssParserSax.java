package com.example.dal32.europapress;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by dal32 on 19/10/2017.
 */

public class RssParserSax {

    URL rssUrl;

    public RssParserSax(String rssUrl) {
        try {
            this.rssUrl = new URL(rssUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Noticia> parse() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            RssHandler handler = new RssHandler();
            parser.parse(this.abrirParaLectura(), handler);
            return handler.getNoticias();
     
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream abrirParaLectura() {
        try {
            return rssUrl.openConnection().getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
