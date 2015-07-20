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


public class stsize extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
    	res.setContentType("text/plain");
    	String sname=req.getParameter("filename");
    //	res.getWriter().print(sname+" ");
    	String bname;
    	Iterator<BlobInfo> itr = new BlobInfoFactory().queryBlobInfos();
        boolean result=false;
        int i=0;
        float f;
        float m=0;
    	while(itr.hasNext())
        {
         f=itr.next().getSize();
         m=m+f;
      //   if(bname!=null)
          {   
     //	  res.getWriter().println(bname);
               	  
          }
         i++; 
        }
    	m=(float)(m/1000000);
    	if(m==0)
        {
        	res.getWriter().println("nothing is in storage");
        }
        else
        {
        	res.getWriter().println( " total storage:"+m+"Mb");
        	
        }
      	
    	
    if(i==0)
    {
    	res.getWriter().println("nothing is in storage");
    }
    else
    {
    	res.getWriter().println( "number of elements in storage:"+i+"");
    	
    }
    }
}
