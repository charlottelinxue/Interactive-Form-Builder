/**************************
 * @author Charlotte Lin
 * @date 05/28/2015
 * @description for downloading XML file
 **************************/

package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;

import model.Model;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.xml.sax.*;
import org.w3c.dom.*;

import formbeans.SearchForm;

public class OutputXMLAction extends Action {
	private FormBeanFactory<SearchForm> formBeanFactory = FormBeanFactory
			.getInstance(SearchForm.class);
	ServletConfig config;
	
//	private String[] package_files = {
  //          "Output/XMLFile.xml",
    //        };
	
	// constructor
	public OutputXMLAction(Model model) {
		this.config = model.config;
	}

	// get action name
	public String getName() {
		return "OutputXML.do";
	}

	// return next page name
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ArrayList<String> info = (ArrayList<String>) session.getAttribute("info");	
		
		System.out.println("***********" + config.getServletContext().getRealPath(""));
		String path = config.getServletContext().getRealPath("") + "/Output/XMLFile.xml";
		Document dom = generateXMLFile(path, info);
		
		
		session.setAttribute("dom", dom);
		
	//	ServletOutputStream sos;
		try {
	//		sos = response.getOutputStream();
	//	
	//		response.setContentType("application/zip");
      //  response.setHeader("Content-Disposition", "attachment; filename=\"data.zip\"");
        
        //createHTML(request.getParameter("path"),request.getParameter("name"),request.getParameter("age"));
   //     doPackage(sos, request.getServletContext());
        
        
        
        response.setContentType("text/xml");  
        PrintWriter out = response.getWriter();      
        response.setContentType("APPLICATION/OCTET-STREAM");   
        response.setHeader("Content-Disposition","attachment; filename=\"" + "XMLFile.xml" + "\"");   
          
        FileInputStream fileInputStream = new FileInputStream(path);  
                    
        int i;   
        while ((i=fileInputStream.read()) != -1) {  
        out.write(i);   
        }   
        fileInputStream.close();   
        out.close();   
        
        
        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index.jsp";		
	}
/*	
	private void doPackage(ServletOutputStream outStream, ServletContext servletCtx) {
        byte[] buffer = new byte[1024];
        ZipOutputStream out = new ZipOutputStream(outStream);
      
        for (int i = 0; i < package_files.length; i++) {
            InputStream fis = null;
            try {
                fis = servletCtx.getResourceAsStream(package_files[i]);//new FileInputStream(files[i]);
                out.putNextEntry(new ZipEntry(package_files[i]));
                int len;
                while ((len = fis.read(buffer)) > 0)
                    out.write(buffer, 0, len);
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try {
            
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
    
	
	private Document generateXMLFile(String path, ArrayList<String> info) {
	    try {
	    		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document dom = db.newDocument();
	        
	        ArrayList<String> list = new ArrayList<String>();
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
			
			
	        // create element1
	        Element root = dom.createElement("root");
	        dom.appendChild(root);
	        
	        for (int i = 0; i < list.size(); i++) {
	        		Element element = dom.createElement(list.get(i));
		        root.appendChild(element);	 
		        if (info.get(i) == null)	element.appendChild(dom.createTextNode(""));
		        else element.appendChild(dom.createTextNode(info.get(i)));
	        }
	        
	        try {
	        	Transformer tf = TransformerFactory.newInstance().newTransformer();
	        	tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        	tf.setOutputProperty(OutputKeys.INDENT, "yes");
	        Writer out = new StringWriter();
	        FileOutputStream file = new FileOutputStream(path);
	               
	        tf.transform(new DOMSource(dom), new StreamResult(file));
	        
	        File position = new File(path);
	        System.out.println(position.getPath());
	        return dom;
	        
	        } catch (TransformerException te) {
	            System.out.println(te.getMessage());
	        } catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	    } catch (ParserConfigurationException pce) {
	        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
	    }
	    return null;
	}
}