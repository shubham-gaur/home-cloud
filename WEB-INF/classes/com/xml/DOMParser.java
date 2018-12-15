package com.xml;

/**
 * DOMParser.java
 * Copyright (c) 2002 by Dr. Herong Yang
 */

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
class DOMParser {
	public static void main(String[] args) {
		try {
			File x = new File(args[0]);
			DocumentBuilderFactory f 
			= DocumentBuilderFactory.newInstance();
			System.out.println(f.toString()); 	
			DocumentBuilder b = f.newDocumentBuilder();
			System.out.println(b.toString()); 	
			Document d = b.parse(x);
			System.out.println(d.toString()); 	
			DOMImplementation i = d.getImplementation();
			System.out.println(i.toString());
		} catch (ParserConfigurationException e) {
			System.out.println(e.toString()); 	
		} catch (SAXException e) {
			System.out.println(e.toString()); 	
		} catch (IOException e) {
			System.out.println(e.toString()); 	
		}
	}
}