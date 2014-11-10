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
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
public class upload extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
    FileService fileService = FileServiceFactory.getFileService();
    AppEngineFile file;
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
    	 long start,end;
        start=System.currentTimeMillis();
    	
    	
    	res.setContentType("text/plain");   
    	Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKey = blobs.get("filename");
        Iterator<BlobInfo> itr = new BlobInfoFactory().queryBlobInfos();
       String bname;
        int i=0;
        List<BlobInfo> blobinf = new LinkedList<BlobInfo>();  
        while(itr.hasNext())
    	{ 
        	// List<BlobInfo> blobinf = new LinkedList<BlobInfo>();
               blobinf.add(itr.next());          
         //   bname=blobinf.get(i).getFilename();
           // bname=itr.next().getFilename();
            if(blobinf.get(i).getSize()<=102400 )
            {   
            	file = fileService.getBlobFile(blobinf.get(i).getBlobKey());
    			cache.put(blobinf.get(i).getFilename(),file);              
    //	        res.getWriter().println(blobinf.get(i).getFilename());
            
            }
       
            i++;
     
        } 
        
    	end=System.currentTimeMillis()-start;
    	res.getWriter().println("Taken time for upload ="+end+"ms");
    }
}