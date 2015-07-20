package com.ex;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;


public class list extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
    	res.setContentType("text/plain");
    	String sname=req.getParameter("filename");
    //	res.getWriter().print(sname+" ");
    	long start,end;
        start=System.currentTimeMillis();
    	
    	String bname;
    	Iterator<BlobInfo> itr = new BlobInfoFactory().queryBlobInfos();
        boolean result=false;
        int i=0;
    	while(itr.hasNext())
        {
          bname=itr.next().getFilename();
          if(bname!=null)
          {   
     	  res.getWriter().println(bname);
               	  
          }
         i++; 
        }
    if(i==0)
    {
    	res.getWriter().println("nothing is in storage");
    }
    else
    {    	end=System.currentTimeMillis()-start;
	res.getWriter().println("Taken time ="+end+"ms");

  
    	res.getWriter().println("Done");
    	
    }
    }
}
