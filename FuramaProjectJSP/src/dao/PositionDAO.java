package dao;

import model.Position;
import model.TypeService;

import java.util.List;

public interface PositionDAO {
    List<Position> findAll();
}
