package flowers.action;

import flowers.bean.Ribbon;
import flowers.bean.RibbonTagName;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class RibbonSaxHandler extends DefaultHandler {
    private List<Ribbon> ribbonList = new ArrayList<Ribbon>();
    private Ribbon ribbon;
    private StringBuilder text;

    public List<Ribbon> getRibbonList() {
        return ribbonList;
    }

    public void startDocument() throws SAXException {
        //System.out.println("Parsing started.");
    }

    public void endDocument() throws SAXException {
       // System.out.println("Parsing ended.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // System.out.print("Start element: ");
        // System.out.println(qName);

        //System.out.println("startElement -> " + "uri: " + uri + ", localName:" + localName + ", qName: " + qName);
        text = new StringBuilder();
        if (qName.equals("ribbon")) {
            ribbon = new Ribbon();
            ribbon.setId((Integer.parseInt(attributes.getValue("id"))));
        }
    }

    public void characters(char[] buffer, int start, int length) {
        // text = new StringBuilder();
        if (text != null) {
            text.append(buffer, start, length);
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        // System.out.println("End Element: "+localName);

        RibbonTagName tagName = RibbonTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        // text = new StringBuilder();
        switch (tagName) {
            case ID:
                ribbon.setId(Integer.parseInt(text.toString()));
                break;
            case PRICE:
                ribbon.setPrice(Double.parseDouble(text.toString()));
                break;
            case COLOR:
                ribbon.setColor(text.toString());
                break;
            case LENGTH:
                ribbon.setLength(Integer.parseInt(text.toString()));
                break;
            case RIBBON:
                ribbonList.add(ribbon);
                ribbon = null;
                break;
        }
    }

    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
        throw (exception);
    }
}
