package bo;

import model.Note;
import model.NoteType;

import java.util.List;

public interface NoteBO {
    List<Note> findAll(int i);
    List<NoteType> findAllType();
    void save(Note note);
    List<Note> findAllDetail(int id);
    void update(Note note);
    void delete(int id);
    List<Note> searchByName(String name);
    List<Note> order();
}
