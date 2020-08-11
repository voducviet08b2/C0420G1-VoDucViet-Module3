package dao;

import model.Note;
import model.NoteType;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteDaoimp implements NoteDao {
    private BaseDAO baseDAO = new BaseDAO();
    private final String SELECT_ALL_NOTE_SQL = "select n.id,title,content,type_id from note n join note_type nt on n.type_id=nt.id";
    private final String SELECT_ORDER_NOTE_SQL = "select n.id,title,content,type_id from note n join note_type nt on n.type_id=nt.id order by title";

    private final String SELECT_ALL_NOTETYPE_SQL = "select id,name,description from note_type";
    private static final String SAVE_INSERT_SQL =
            "insert into note (title, content,type_id) " +
                    "values (?, ?, ?)";
    private final String SELECT_ONE_NOTE_SQL = "select id,title,content,type_id from note where id=?";
    private static final String UPDATE_NOTE_SQL = "update note set " +
            "title = ?,content= ?, type_id =? where id = ?;";
    private static final String DELETE_NOTE_SQL = "delete from note where id=?";
    private static final String SEARCH_NOTE_SQL = "select id,title,content,type_id\n" +
            "from note\n" +
            "where title like ?;";
    @Override
    public List<Note> findAll() {
        List<Note> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_NOTE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Note note = null;


            while (resultSet.next()) {
                note = new Note();
                note.setId(resultSet.getInt("id"));
                note.setTitle(resultSet.getString("title"));
                note.setContent(resultSet.getString("content"));
                note.setTypeId(resultSet.getInt("type_id"));
                showList.add(note);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }

    @Override
    public List<NoteType> findAllType() {
        List<NoteType> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_NOTETYPE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            NoteType noteType = null;
            while (resultSet.next()) {
                noteType = new NoteType();
                noteType.setId(resultSet.getInt("id"));
                noteType.setName(resultSet.getString("name"));
                noteType.setDescription(resultSet.getString("description"));
                showList.add(noteType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }

    @Override
    public void save(Note note) {

    }

    @Override
    public List<Note> findAllDetail(int id) {
        List<Note> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ONE_NOTE_SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Note note = null;
            while (resultSet.next()) {
                note = new Note();
                note.setId(resultSet.getInt("id"));
                note.setTitle(resultSet.getString("title"));
                note.setContent(resultSet.getString("content"));
                showList.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }

    @Override
    public void update(Note note) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_NOTE_SQL);
            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setString(2, note.getContent());
            preparedStatement.setInt(3, note.getTypeId());
            preparedStatement.setInt(4, note.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try{
            PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(DELETE_NOTE_SQL);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Note> searchByName(String name) {
        List<Note> noteList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().prepareStatement(SEARCH_NOTE_SQL);
//            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall();
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();

            Note note = null;
            while (resultSet.next()) {
               note = new Note();
                note.setId(resultSet.getInt("id"));
                note.setTitle(resultSet.getString("title"));
                note.setContent(resultSet.getString("content"));
                note.setTypeId(resultSet.getInt("type_id"));
                noteList.add(note);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return noteList;
    }

    @Override
    public List<Note> order() {
        List<Note> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ORDER_NOTE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Note note = null;


            while (resultSet.next()) {
                note = new Note();
                note.setId(resultSet.getInt("id"));
                note.setTitle(resultSet.getString("title"));
                note.setContent(resultSet.getString("content"));
                note.setTypeId(resultSet.getInt("type_id"));
                showList.add(note);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }


}

