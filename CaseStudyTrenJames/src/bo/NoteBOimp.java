package bo;

import dao.NoteDao;
import dao.NoteDaoimp;
import model.Note;
import model.NoteType;

import java.util.List;

public class NoteBOimp implements NoteBO{
    private NoteDao noteDao=new NoteDaoimp();

    @Override
    public List<Note> findAll(int i) {
        return noteDao.findAll(i);
    }

    @Override
    public List<NoteType> findAllType() {
        return noteDao.findAllType();
    }

    @Override
    public void save(Note note) {
        noteDao.save(note);
    }

    @Override
    public List<Note> findAllDetail(int id) {
        return noteDao.findAllDetail(id);
    }

    @Override
    public void update(Note note) {
        noteDao.update(note);
    }

    @Override
    public void delete(int id) {
        noteDao.delete(id);
    }

    @Override
    public List<Note> searchByName(String name) {
        return noteDao.searchByName(name);
    }

    @Override
    public List<Note> order() {
        return noteDao.order();
    }


}
