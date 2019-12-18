<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.util.List, p.jdbc1.*" %>

 <% if (request.getMethod().equals("POST")) {  
	 Book book = new Book();    
	 request.setCharacterEncoding("UTF-8");    
	 
	 String title = request.getParameter("title");   
	 book.setTitle(title); 
	 
	 String author = request.getParameter("author");   
	 book.setAuthor(author);    
	 
	 String s = request.getParameter("categoryId");
	 int categoryId = Integer.parseInt(s);
	 book.setCategoryId(categoryId);  
	 
	 String ss = request.getParameter("price");   
	 int price = Integer.parseInt(ss);   
	 book.setPrice(price); 
	     
	 BookDAO.insert(book);   
	 response.sendRedirect("bookList.jsp");    
	 return; 
	 } 
 List<Category> categories = CategoryDAO.findAll(); %> 
 <!DOCTYPE html> 
 <html> 
 <head>  
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">   
  <meta name="viewport" content="width=device-width, initial-scale=1">   
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>  
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
   <style>      
    body { font-family: 굴림체; }       
    table.table { width: 500px; }      
     table td:nth-child(1) { background-color: #eee; }   
     </style> 
     </head> 
     <body> 
     <div class="container"> 
     <h1>책 등록</h1> 
     <form method="post">   
     <table class="table table-bordered table-condensed">    
      <tr>       
      <td>제목</td>     
        <td>          
         <input type="text" name="title" class="form-control" />      
          </td>   
            </tr>   
              <tr>      
               <td>저자</td>     
                 <td>          
                  <input type="text" name="author" class="form-control" />   
                      </td>   
                        </tr>   
                          <tr>   
                              <td>카테고리</td>     
                                <td> 
                                <select name="categoryId" class="form-control">      
                                     <% for (Category category : categories) { %>    
                                              <% int id = category.getId(); %>         
                                                  <% String CategoryName = category.getCategoryName(); %>   
                                                            <option value="<%= id %>">            
                                                               <%= CategoryName %>          
                                                                  </option>   
                                                                       <% } %>        
                                                                    </select>     
                                                                     </td>    
                                                                    </tr>  
                                                                      <tr>       
      <td>가격</td>     
        <td>          
         <input type="text" name="price" class="form-control" />      
          </td>   
            </tr>   
                                                 </table> 
                                                   <button type="submit" class="btn btn-primary">저장</button>  
                              <a href="javascript:window.history.back()" class="btn btn-info">돌아가기</a> 
                              </form> 
                              </div> 
                              </body> 
                              </html> 