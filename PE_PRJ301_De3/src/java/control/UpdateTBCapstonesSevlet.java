/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.TblCapstonesDBContext;
import dao.TblUsersDBContext;
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
public class UpdateTBCapstonesSevlet  extends BaseAuthenticationCotroller{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, TblUsers account) throws ServletException, IOException {
      
       
       String capid=req.getParameter("did");
       String capname= req.getParameter("name");
       String des= req.getParameter("des");
       String capuserid= req.getParameter("userid");
       
       
       TblCapstones capstones= new TblCapstones();
       TblUsers tblUsers= new TblUsers();
       tblUsers.setUserId(capuserid);
       
       capstones.setCapid(capid);
       capstones.setCapname(capname);
       capstones.setCapdescription(des);
       capstones.setCapuserid(tblUsers);
       
       TblCapstonesDBContext bContext= new TblCapstonesDBContext();
       bContext.update(capstones);
       
        TblCapstonesDBContext tblCapstonesDBContext = new TblCapstonesDBContext();
        ArrayList<TblCapstones> listsByName = tblCapstonesDBContext.listTblCapstoneses();
        req.setAttribute("lists", listsByName);
        req.getRequestDispatcher("captstonesList.jsp").forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, TblUsers account) throws ServletException, IOException {
        String capid=req.getParameter("id");
        TblCapstonesDBContext bContext= new TblCapstonesDBContext();
        TblCapstones capstones=bContext.getTblCapstones(capid);
        req.setAttribute("cap",capstones);
        
        TblUsersDBContext tudbc=new TblUsersDBContext();
        ArrayList<TblUsers> listU= tudbc.getListTblUsers();
        req.setAttribute("listU", listU);
         req.getRequestDispatcher("update.jsp").forward(req, resp);
        
    }
    
}
