package com.example.dal32.comedor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import com.example.dal32.comedor.Comedor;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class RssHandler extends DefaultHandler {
    Activity contexto;

    private List<Comedor> comedor;
    private Comedor comedores;
    private StringBuilder sbTexto;


    public List<Comedor> getComedor() {
        return comedor;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        comedor = new ArrayList<>();
        sbTexto = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if (localName.equals("dia"))
            comedores = new Comedor();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        if (comedores != null)
            sbTexto.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if (comedores != null) {
            if (localName.equals("Plato_1"))
                comedores.setPlato1(sbTexto.toString());
            else if (localName.equals("Plato_2"))
                comedores.setPlato2(sbTexto.toString());
            else if (localName.equals("Postre"))
                comedores.setFecha(sbTexto.toString());
            else if (localName.equals("Fecha"))
                comedores.setPostre(sbTexto.toString());
            else if (localName.equals("Dia"))
                comedor.add(comedores);

            sbTexto.setLength(0);
        }


    }
}
