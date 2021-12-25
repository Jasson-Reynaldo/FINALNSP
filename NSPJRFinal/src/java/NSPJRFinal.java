/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jasso
 */
public class NSPJRFinal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = null;
        String fullname,b_date,favfood,gender,CookExp,ReqEmail,LikedFlav;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
        fullname = request.getParameter("fullname");
        b_date = request.getParameter("bdate");
        favfood = request.getParameter("favfood");
        gender = request.getParameter("gender");
        CookExp = request.getParameter("Exp");
        ReqEmail = request.getParameter("email");
        List<String> flavor = new ArrayList<>();
        LikedFlav = null;
        String tempdev;
        for (int i =1; i<=5;++i){
            tempdev = request.getParameter("flav"+i);
            if (tempdev != null){
                flavor.add(tempdev);   
            }
        }
        for (int i = 0; i < flavor.size(); i++) {
            if (LikedFlav == null){
                LikedFlav=flavor.get(i);
            }
            else{
            LikedFlav += flavor.get(i);
            }
            if(i < flavor.size() - 1)
            {
                LikedFlav += ", ";
            }
        }
        StringBuffer buf = new StringBuffer();  
        buf.append("<html>\n");
        buf.append("<head>\n");
        buf.append("<title>User Biodata - Jasson Reynaldo NSP Quiz Servlet</title>\n");
        buf.append("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
        buf.append("<link rel=\"stylesheet\" href=\"main.css\">\n");
        buf.append("</head>\n");
        buf.append("<body>\n");
        buf.append("<div class=\"container my-5 px-5 py-5\" style=\"width: 30%;text-align:center\">");
        buf.append("<h2><b>New Applicant!</b></h2>");
        buf.append("<div class=\"cntx\">");
        buf.append("Full Name: " + fullname);
        buf.append("<br>Date of Birth: " + b_date);
        buf.append("<br>Favorite Food: " + favfood);
        buf.append("<br>Gender: " + gender);
        buf.append("<br>Liked Food Flavors: " + LikedFlav);
        buf.append("<br>Cooking Experience: " + CookExp);
        buf.append("<br>Active E-mail: " + ReqEmail);
        buf.append("</div>")
        buf.append("<br><br><button class=\"btn btn-warning\" onclick=\"window.open('http://localhost:8080/NSPJRFinal/','_self')\">Confrim</button>\n");
        buf.append("</div>\n");
        buf.append("</body>\n");
        buf.append("</PRE>\n</html>");
        out.println(buf.toString());
        out.close();
        
        /*Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuisine_clubs", "root", "");
        PreparedStatement ps = con.prepareStatement("insert into cuisine_clubs.requesters values(?,?,?,?,?,?,?)");
        ps.setString(1, fullname);
        ps.setString(2, b_date);
        ps.setString(3, favfood);
        ps.setString(4, gender);
        ps.setString(5, CookExp);
        ps.setString(6, LikedFlav);
        ps.setString(7, ReqEmail);
        ps.executeUpdate();*/

        
        }
        catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
