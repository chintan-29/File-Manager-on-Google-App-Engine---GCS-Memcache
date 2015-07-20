
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
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

public class removeall extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
   // private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
    public FileService fileService = FileServiceFactory.getFileService();
    public AppEngineFile file;
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
    	res.setContentType("text/plain");
    	String sname=req.getParameter("filename");
    //	res.getWriter().print(sname+" ");
         //	String bname;
    	long start,end;
        start=System.currentTimeMillis();
    	
      cache.clearAll();
    	//file=(AppEngineFile) cache.get(sname);
    //  res.getWriter().print("cache has been cleared..");
 // 	res.setContentType("text/plain");
//	String sname=req.getParameter("filename");
//	res.getWriter().print(sname+" ");
	String bname;
	Iterator<BlobInfo> itr = new BlobInfoFactory().queryBlobInfos();
    boolean result=false;
    int i=0;
	while(itr.hasNext())
    {
		blobstoreService.delete(itr.next().getBlobKey());
    } 
   // }

	res.getWriter().print("all file has been deleted. ");
	end=System.currentTimeMillis()-start;
	res.getWriter().println("Taken time ="+end+"ms");

      
         }
}

