package dao;

import model.Note;
import model.NoteType;
import java.util.List;

public interface NoteDao {
        List<Note> findAll();
        List<NoteType> findAllType();
        void save(Note note);
        List<Note> findAllDetail(int id);
        void update(Note note);
        void delete(int id);
        List<Note> searchByName(String name);
        List<Note> order();
}
