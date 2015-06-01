package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import org.mybeans.form.FormBeanFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.zip.*;

import formbeans.PathForm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;



    public class DownloadPlainHtml extends Action {
        private FormBeanFactory<PathForm> formBeanFactory = FormBeanFactory
                .getInstance(PathForm.class);
        private String package_files =  "Output/notice.html";
//        private String dynamic_file_src = "WebContent/css/bootstrap.css";
//        private String dynamic_file_des = "WebContent/index.html";

        // constructor
        public DownloadPlainHtml(Model model) {
            
        }

        // get action name
        public String getName() {
            return "downloadHtml.do";
        }

//        private void createHTML(String username, String userage, String usergendor) {
//            File readfile = new File(dynamic_file_src);
//            BufferedReader reader = null;
//            StringBuffer sb = new StringBuffer();
//            try {
//                reader = new BufferedReader(new FileReader(readfile));
//                String tempString = null;
//                while ((tempString = reader.readLine()) != null)
//                    sb.append(tempString);
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (IOException e1) {
//                    }
//                }
//            }
//            String html = sb.toString();
//            html = html.replaceAll("username", username);
//            html = html.replaceAll("userage", userage);
//            html = html.replaceAll("usergendor", usergendor);
//            try {
//                File writefile = new File(dynamic_file_des);
//                if (!writefile.exists())
//                    writefile.createNewFile();
//                FileOutputStream out = new FileOutputStream(writefile, false);
//                out.write(html.getBytes("utf-8"));
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        
        private void doPackage(ServletOutputStream outStream, ServletContext servletCtx) {
            byte[] buffer = new byte[1024];
           
            InputStream fis = null;
            try {
                fis = servletCtx.getResourceAsStream(package_files);//new FileInputStream(files[i]);
                int len;
                while ((len = fis.read(buffer)) > 0)
                    outStream.write(buffer, 0, len);
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        
            
            try {
                
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String perform(HttpServletRequest request, HttpServletResponse response) {
            List<String> errors = new ArrayList<String>();
            request.setAttribute("errors", errors);
            try {
                ServletOutputStream sos = response.getOutputStream();
                response.setContentType("application/zip");
                response.setHeader("Content-Disposition", "attachment; filename=\"notice.html\"");
                
                //createHTML(request.getParameter("path"),request.getParameter("name"),request.getParameter("age"));
                doPackage(sos, request.getServletContext());
            
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
            
            return null;
        }

        
    }
