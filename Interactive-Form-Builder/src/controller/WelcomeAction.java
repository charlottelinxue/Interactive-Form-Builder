/**************************
 * @author Charlotte Lin
 * @date 05/28/2015
 * @description welcome
 **************************/

package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;

import model.Model;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import javax.xml.parsers.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.xml.sax.*;
import org.w3c.dom.*;

import formbeans.PathForm;

public class WelcomeAction extends Action {
	private FormBeanFactory<PathForm> formBeanFactory = FormBeanFactory
			.getInstance(PathForm.class);

	// constructor
	public WelcomeAction(Model model) {
		
	}

	// get action name
	public String getName() {
		return "welcome.do";
	}

	// return next page name
	public String perform(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("I get here!");
	
			return "index.jsp";

	}
	
	private void parseXMLFile(String path) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("name");
		list.add("happy");
		list.add("age");
		list.add("gender");
		list.add("description");
		
		try {
			File file = new File(path);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getChildNodes();
			Element root = (Element) nodeList.item(0);
			
			nodeList = root.getChildNodes();
			
			for (String s : list) {
				nodeList = root.getElementsByTagName(s);
				Element element = (Element) nodeList.item(0);
				nodeList = element.getChildNodes();
				System.out.println(s  + ((Node) nodeList.item(0)).getNodeValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}