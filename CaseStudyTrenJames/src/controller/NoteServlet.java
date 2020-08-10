package controller;

import bo.NoteBO;
import bo.NoteBOimp;
import model.Note;
import model.NoteType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "NoteServlet",urlPatterns = "/noteServlet")
public class NoteServlet extends HttpServlet {
    private NoteBO noteBO=new NoteBOimp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "updateCreate":
                updateCreate(request,response);
                break;
            case "detailView":
                detailView(request,response);
                break;
            case "update":
                update(request,response);
                break;
            case "confirmUpdate":
                confirmUpdate(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "search":
                search(request,response);
                break;
            case "order":
                order(request,response);
                break;
            default:
                show(request,response);
                break;
        }

    }
    public void order(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        List<Note> noteList=noteBO.order();
        List<NoteType> noteTypeList=noteBO.findAllType();
        request.setAttribute("noteList",noteList);
        request.setAttribute("noteTypeList",noteTypeList);
        request.getRequestDispatcher("show.jsp").forward(request,response);

    }
    public void search(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String k=request.getParameter("k");
        List<Note> noteList=this.noteBO.searchByName(k);
        List<NoteType> noteTypeList=noteBO.findAllType();
        request.setAttribute("noteList",noteList);
        request.setAttribute("noteTypeList",noteTypeList);
        request.getRequestDispatcher("show.jsp").forward(request,response);

    }
    public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        this.noteBO.delete(id);
        this.show(request,response);

    }
    public void update(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        int idSearch=0;
        List<Note> noteList = noteBO.findAll();
        for(int i=0;i<noteList.size();i++){
            if(id==noteList.get(i).getId()){
                idSearch=i;
            }
        }
        String title=noteList.get(idSearch).getTitle();
        String content=noteList.get(idSearch).getContent();
        int typeId=noteList.get(idSearch).getTypeId();
        List<NoteType> noteTypeList=noteBO.findAllType();
        String nameType="";

        for(int i=0;i<noteTypeList.size();i++){
            if(typeId==noteTypeList.get(i).getId()){
                nameType=noteTypeList.get(i).getName();
            }
        }
        request.setAttribute("id",id);
        request.setAttribute("title",title);
        request.setAttribute("content",content);
        request.setAttribute("nameType",nameType);
        request.setAttribute("noteTypeList",noteTypeList);

        request.getRequestDispatcher("edit.jsp").forward(request,response);

    }

    public void confirmUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        int typeId=Integer.parseInt(request.getParameter("typeId"));
        Note note=new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        note.setTypeId(typeId);
        //this.userBO.update(user);
        this.noteBO.update(note);
        this.show(request,response);
    }
    public void show(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        List<Note> noteList=noteBO.findAll();
        List<NoteType> noteTypeList=noteBO.findAllType();
        request.setAttribute("noteList",noteList);
        request.setAttribute("noteTypeList",noteTypeList);
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }
    public void create(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        //List<Note> noteList=noteBO.findAll();
        List<NoteType> noteTypeList=noteBO.findAllType();
        //request.setAttribute("noteList",noteList);
        request.setAttribute("noteTypeList",noteTypeList);
        request.getRequestDispatcher("create.jsp").forward(request,response);
    }
    public void updateCreate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        int typeId=Integer.parseInt(request.getParameter("typeId"));
        Note note=new Note();
        note.setTitle(title);
        note.setContent(content);
        note.setTypeId(typeId);
        this.noteBO.save(note);
        this.show(request,response);
    }
    public void detailView(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
         int id=Integer.parseInt(request.getParameter("id"));
        List<Note> noteList=noteBO.findAllDetail(id);
        request.setAttribute("noteList",noteList);
        request.getRequestDispatcher("detailView.jsp").forward(request,response);
    }
}
