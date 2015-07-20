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

public class cachesiz extends HttpServlet {
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
     // cache.clearAll();
    	float n=cache.getStatistics().getItemCount();
    	//file=(AppEngineFile) cache.get(sname);
      res.getWriter().println("Number of element:."+n+"");
          n=cache.getStatistics().getTotalItemBytes();
         float m=(float)(n/100);
          res.getWriter().println("size of cache:."+m+"Kb");
          
         }
}

