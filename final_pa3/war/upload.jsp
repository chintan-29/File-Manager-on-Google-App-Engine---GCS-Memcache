<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%
    BlobstoreService bs = BlobstoreServiceFactory.getBlobstoreService();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div>
      <form action="<%= bs.createUploadUrl("/upload") %>" method="post" enctype="multipart/form-data">
         <p> Please select file to upload file: </p>
         <input type="file" name="filename" multiple/>
         <input type="submit" value="upload" />
      </form>
   </div>
  <div>
 <form action="/find" method="post">
         <p> Please write name of file to find: </p>
         <input type="text" name="filename" />
         <input type="submit" value="find">
      </form>
     </div>
     <div> 
     <form action="/delete" method="post">
         <p> Please write name of file to delete: </p>
         <input type="text" name="filename" />
         <input type="submit" value="delete">
      </form>
      </div>
      <div> 
     <form action="/download" method="post">
         <p> Please write name of file to download: </p>
         <input type="text" name="filename" />
         <input type="submit" value="download">
      </form>
      </div>
      <div>
      <form action="/list" method="post">
         <p> press show all to get list of all files:  </p>
         <input type="submit" value="show_all">
      </form>
      </div>
      <div> 
     <form action="/checkcache" method="post">
         <p> Please write name of file to find file from cache:</p>
         <input type="text" name="filename" />
         <input type="submit" value="check_cache">
      </form>
      </div>
        <div>
      <form action="/removecache" method="post">
         <p> press remove_all_cache to remove all files of cache:   </p>
         <input type="submit" value="remove_all_cache">
      </form>
      </div>
     
        <div>
      <form action="/removeall" method="post">
         <p> press remopve_all to remove all files of storage:  </p>
         <input type="submit" value="remove_all">
      </form>
      </div>
   
        <div>
      <form action="/cachesiz" method="post">
         <p> press cache_size to get size of cache:  </p>
         <input type="submit" value="cache_size">
      </form>
      </div>
      <div>
         <form action="/stsize" method="post">
         <p> press storage_size to get size of storage :  </p>
         <input type="submit" value="storage_size">
         </form>
      </div>
      <div>
        <form action="/listing" method="post">
         <p> Please write regular expression :</p>
         <input type="text" name="filename" />
         <input type="submit" value="listing">
      </form>
     </div>
      	    	
       
</body>
</html>