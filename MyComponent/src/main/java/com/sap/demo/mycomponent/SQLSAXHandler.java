package com.sap.demo.mycomponent;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sap.demo.mycomponent.DBTableName.Action;

public class SQLSAXHandler extends DefaultHandler {
	private List<Access> accesses;
	private List<Key> keys;
	private Key Key;
	private List<DBTableName> dbTableNames;
	private Access access;
	private DBTableName dbtableName;
	private boolean qaccess;
	private boolean qkey;
	private boolean qtable;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("dbTableName")) {
			String action = attributes.getValue("action");
			dbtableName = new DBTableName();
			dbtableName.setAction(Action.valueOf(action));
		} else if (qName.equalsIgnoreCase("table")) {
			qtable = true;
		} else if (qName.equalsIgnoreCase("access")) {
			qaccess = true;
		} else if (qName.equalsIgnoreCase("key")) {
			qkey = true;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("dbTableName")) {
			dbTableNames.add(dbtableName);
		}

	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if(qtable){
			dbtableName.setTable(new String(ch, start, length));
			qtable=false;
		}
		if(qaccess){
		    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
	        AccessHandler handler = new AccessHandler();
	        saxParser.parse(new String(ch, start, length), handler);
	        access.setColumnValues(handler.getColumnValueList());
		}

	}

}
