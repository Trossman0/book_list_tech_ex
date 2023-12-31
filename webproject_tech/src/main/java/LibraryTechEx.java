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

@WebServlet("/LibraryTechEx")
public class LibraryTechEx extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public LibraryTechEx() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");

      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<tech_ex_lib> listBooks = UtilDBRossman.listBooks();
      for (tech_ex_lib Library : listBooks) {
         System.out.println("[DBG] " + Library.getId() + ", " //
               + Library.getTitle() + ", " //
               + Library.getRating() + ", " //
               + Library.getSynop() + ", " //
               + Library.getOwned());

         out.println("<li>" + Library.getId() + ", " //
        		 + Library.getTitle() + ", " //
                 + Library.getRating() + "*, " //
                 + Library.getSynop() + ", " //
                 + Library.getOwned() + "</li>");
      }
      out.println("</ul>");
      out.println("<a href=/webproject_tech/simpleSearchHB.html>Search Data</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}