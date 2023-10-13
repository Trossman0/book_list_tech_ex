import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilDBRossman;

@WebServlet("/SimpleInsertHB")
public class SimpleInsertHB extends HttpServlet{
   private static final long serialVersionUID = 1L;

   public SimpleInsertHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String title = request.getParameter("title").trim();
      String rating = request.getParameter("rating").trim();
      String synop = request.getParameter("synop").trim();
      String owned = request.getParameter("owned").trim();
      
      UtilDBRossman.addBook(title, rating, synop, owned);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String doctitle = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + doctitle + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + doctitle + "</h1>\n");
      out.println("<ul>");
      out.println("<li> Title: " + title);
      out.println("<li> Rating: " + rating);
      out.println("<li> Synopsis: " + synop);
      out.println("<li> If Owned: " + owned);
      
      
      out.println("</ul>");
      out.println("<a href=/webproject_tech/simpleSearchHB.html>Search Data</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
