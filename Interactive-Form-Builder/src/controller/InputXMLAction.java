/**************************
 * @author Charlotte Lin
 * @date 05/28/2015
 * @description for uploading XML file
 **************************/

package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
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

import databeans.Information;
import formbeans.PathForm;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileUpload;

public class InputXMLAction extends Action {
	private FormBeanFactory<PathForm> formBeanFactory = FormBeanFactory
			.getInstance(PathForm.class);
	ServletConfig config;
	// constructor
	public InputXMLAction(Model model) {
		this.config = model.config;
	}

	// get action name
	public String getName() {
		return "InputXML.do";
	}

	// return next page name
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Information info = null;
		if (ServletFileUpload.isMultipartContent(request)) {
		try {
				request.setCharacterEncoding("utf-8");
				ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
				List<FileItem> list = (List<FileItem>) upload.parseRequest(request);

				for (FileItem item : list) {
					String name = item.getFieldName();
					
				
				if (!item.isFormField()) {
					System.out.println(name);
					
					InputStream in = item.getInputStream();
				
					info = parseXMLFile(in);
					in.close();
								
					request.setAttribute("information", info);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
}
				

			
			
	return "index.jsp";

	}
	
	private Information parseXMLFile(InputStream in) {
		Information info = new Information();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>();
		list.add("company");
		list.add("entity");
		list.add("entities");
		list.add("joint");
		list.add("phone");
		list.add("email");
		list.add("web");
		list.add("address");
		list.add("city");
		list.add("zipcode");
		list.add("state");	
		list.add("sharing1");
		list.add("optout1");
		list.add("sharing2");
		list.add("optout2");
		list.add("sharing3");
		list.add("optout3");
		list.add("sharing4");
		list.add("optout4");
		list.add("sharing5");
		list.add("optout5");
		list.add("sharing6");
		list.add("optout6");
		list.add("sharing7");
		list.add("measures");		
		list.add("collection");
		list.add("affiliate");
		list.add("naffiliate");
		list.add("nonaffiliates");
		list.add("mailin");
		list.add("others");
		list.add("others2");
		list.add("choice");
		list.add("others3");
		list.add("others7");
		
		list.add("whatinfo1");
		list.add("whatinfo2");
		list.add("whatinfo3");
		list.add("whatinfo4");
		list.add("whatinfo5");
		
		list.add("how1");
		list.add("how2");
		list.add("how3");
		list.add("how4");
		list.add("how5");
		
		try {
			//File file = new File(path);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(in);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getChildNodes();
			Element root = (Element) nodeList.item(0);
			
			nodeList = root.getChildNodes();
			
			for (String s : list) {
				nodeList = root.getElementsByTagName(s);
				Element element = (Element) nodeList.item(0);
				if (element == null) res.add("");
				else {
					nodeList = element.getChildNodes();
					if (((Node) nodeList.item(0)) == null) res.add("");
					else res.add(((Node) nodeList.item(0)).getNodeValue());	
				}
			}
			System.out.println(res);
			info = new Information(
					res.get(0), 
					res.get(1), 
					res.get(2), 
					res.get(3), 
					res.get(4),
					res.get(5), 
					res.get(6), 
					res.get(7), 
					res.get(8), 
					res.get(9), 
					res.get(10), 
					res.get(11), 
					res.get(12), 
					res.get(13), 
					res.get(14), 
					res.get(15), 
					res.get(16), 
					res.get(17), 
					res.get(18), 
					res.get(19), 
					res.get(20), 
					res.get(21), 
					res.get(22), 
					res.get(23), 
					res.get(24), 
					res.get(25), 
					res.get(26), 
					res.get(27), 
					res.get(28), 
					res.get(29), 
					res.get(30), 
					res.get(31), 
					res.get(32), 
					res.get(33),
					res.get(34),
					res.get(35),
					res.get(36),
					res.get(37),
					res.get(38),
					res.get(39),
					res.get(40),
					res.get(41),
					res.get(42),
					res.get(43),
					res.get(44));
			return info;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
}