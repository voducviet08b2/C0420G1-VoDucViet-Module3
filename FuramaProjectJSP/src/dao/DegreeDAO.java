package dao;

import model.Degree;
import model.Position;

import java.util.List;

public interface DegreeDAO {
    List<Degree> findAll();
}
