/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.TplProductDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Cart;
import model.TblProducts;

/**
 *
 * @author G5 5590
 */
public class ProductSearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TplProductDBContext bContext = new TplProductDBContext();
        ArrayList<TblProducts> lists = bContext.search();
        req.setAttribute("list111", lists);

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String des = req.getParameter("description");
        float price = Float.parseFloat(req.getParameter("price"));
        boolean status = Boolean.parseBoolean(req.getParameter("status"));

        if (id.isEmpty() || name.isEmpty() || des.isEmpty() || price == 0) {
            req.setAttribute("eron", "You must input all texts");
        } else {
            HttpSession session = req.getSession();
            //Đoạn mã trên tạo hoặc lấy một phiên (session)
            //từ đối tượng HttpServletRequest (req). 
            //Session trong Java thường được sử dụng
            //để lưu trữ thông tin trạng thái của phiên làm việc 
            //giữa các yêu cầu từ cùng một người dùng.
            ArrayList<Cart> list;
            //kiểm tra xem trong session có lưu danh sách nào ko nếu ko thì khởi tạo
            if (session.getAttribute("list") == null) {
                list = new ArrayList<>();
            } else {
                //da ton tai
                list = (ArrayList<Cart>) session.getAttribute("list");
            }
            Cart newCart = new Cart(id, name, des, price, status);
            list.add(newCart);
            //để lưu danh sách trong session
            session.setAttribute("list", list);
            req.setAttribute("list", list);
        }

        req.getRequestDispatcher("shopping.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchParam = req.getParameter("search");
        if (searchParam != null && searchParam.trim().equalsIgnoreCase("Search all")) {
            // Logic to fetch and display list of products
            TplProductDBContext bContext = new TplProductDBContext();
            ArrayList<TblProducts> lists = bContext.search();
            req.setAttribute("list111", lists);

        }
        
        String textString= req.getParameter("submit12");
        if (textString != null && textString.trim().equalsIgnoreCase("Submit")) {
            String id1 = req.getParameter("id1");
            String name1 = req.getParameter("name1");
            String des1 = req.getParameter("description1");
            float price1 = Float.parseFloat(req.getParameter("price1"));
            boolean status1 = Boolean.parseBoolean(req.getParameter("status1"));

            if (id1.isEmpty() || name1.isEmpty() || des1.isEmpty() || price1 == 0) {
                req.setAttribute("eron", "You must input all texts");

            } else {
                HttpSession session = req.getSession();
                ArrayList<Cart> list;

                if (session.getAttribute("list") == null) {
                    list = new ArrayList<>();
                } else {
                    list = (ArrayList<Cart>) session.getAttribute("list");
                }

                Cart newCart = new Cart(id1, name1, des1, price1, status1);
                list.add(newCart);

                session.setAttribute("list", list);
                req.setAttribute("list", list);

                req.getRequestDispatcher("viewCart.jsp").forward(req, resp);
            }
        }

        req.getRequestDispatcher("shopping.jsp").forward(req, resp);

    }

}
