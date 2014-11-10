package com.ex;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class find extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
    	long start,end;
        start=System.currentTimeMillis();
    	
    	
    	res.setContentType("text/plain");
    	String sname=req.getParameter("filename");
    	res.getWriter().print(sname+" ");
    	String bname;
    	Iterator<BlobInfo> itr = new BlobInfoFactory().queryBlobInfos();
        boolean result=false;
    	int i=0;
        while(itr.hasNext())
        { 
          bname=itr.next().getFilename();
          if(bname.equals(sname))
          {   result=true;
   //     	  res.getWriter().print("is present in storage");
               i++;  	  
          }
        }
    if(result)
    {
    	res.getWriter().println(" is present in storage.");
    	if(i>1)
    	{
    		res.getWriter().print("There are "+i+" copys present in storage.");
    		//long start,end;
    	  //  end=System.currentTimeMillis()-start;
    	   // res.getWriter().println(" is present in storage.");
    	   // res.getWriter().println("Taken time for upload ="+end+"ms");
    	}
    	 
    	end=System.currentTimeMillis()-start;
    	res.getWriter().println("Taken time ="+end+"ms");
    	
    }
    else
    {
    	res.getWriter().print("is not present in storage.");
    	
    }
    }
}