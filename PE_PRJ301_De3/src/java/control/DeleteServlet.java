/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DeleteDBContext;
import dao.TblCapstonesDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.TblCapstones;
import model.TblUsers;

/**
 *
 * @author G5 5590
 */
public class DeleteServlet extends BaseAuthenticationCotroller {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, TblUsers account) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, TblUsers account) throws ServletException, IOException {
        String id = req.getParameter("id");
        DeleteDBContext db = new DeleteDBContext();
        TblCapstones capstones = new TblCapstones();
        capstones.setCapid(id);
        db.delete(capstones);
        
      
        TblCapstonesDBContext tblCapstonesDBContext = new TblCapstonesDBContext();
        ArrayList<TblCapstones> listsByName = tblCapstonesDBContext.listTblCapstoneses();
        req.setAttribute("lists", listsByName);
        req.getRequestDispatcher("captstonesList.jsp").forward(req, resp);
    }

}
