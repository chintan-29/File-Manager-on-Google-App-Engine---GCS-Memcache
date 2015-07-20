package com.ex;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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

public class delete extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
    	res.setContentType("text/plain");
    	String sname=req.getParameter("filename");
    	res.getWriter().print(sname+" ");
    	String bname;
    	Iterator<BlobInfo> itr = new BlobInfoFactory().queryBlobInfos();
        int i=0;
        List<BlobInfo> blobinf = new LinkedList<BlobInfo>();
    	boolean result=false;
    	long start,end;
        start=System.currentTimeMillis();
    	
    	while(itr.hasNext())
        {// List<BlobInfo> blobinf = new LinkedList<BlobInfo>();
          blobinf.add(itr.next());          
          bname=blobinf.get(i).getFilename();
         // bname=itr.next().getFilename();
          if(bname.equals(sname))
          {   
        	  
        	  result=true;
          blobstoreService.delete(blobinf.get(i).getBlobKey());
   //     	  res.getWriter().print("is present in storage");
              
              break;   	  
          }
        i++;
        }
    if(result)
    {
    	res.getWriter().print("is deleted");
    	end=System.currentTimeMillis()-start;
    	res.getWriter().println("Taken time ="+end+"ms");

    }
    else
    {
    	res.getWriter().print("is not present in storage");
    	
    }
    }
}
