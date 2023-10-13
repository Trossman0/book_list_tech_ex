import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.tech_ex_lib;
import util.UtilDBRossman;

@WebServlet("/SimpleSearchHB")
public class SimpleSearchHB extends HttpServlet{
   private static final long serialVersionUID = 1L;

   public SimpleSearchHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Library Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");

      List<tech_ex_lib> listBooks = null;
      if (keyword != null && !keyword.isEmpty()) {
    	  listBooks = UtilDBRossman.listBooks(keyword);
      } else {
    	  listBooks = UtilDBRossman.listBooks();
      }
      display(listBooks, out);
      out.println("</ul>");
      out.println("<a href=/webproject_tech/simpleSearchHB.html>Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<tech_ex_lib> listEmployees, PrintWriter out) {
      for (tech_ex_lib book : listEmployees) {
         System.out.println("[DBG] " + book.getId() + ", " //
               + book.getTitle() + ", " //
               + book.getRating()  + ", " //
               + book.getSynop()  + ", " //
               + book.getOwned());

         out.println("<li>" + book.getId() + ", " //
        		 + book.getTitle() + ", " //
                 + book.getRating() + "*, " //
                 + book.getSynop() + ", " //
                 + book.getOwned());
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
