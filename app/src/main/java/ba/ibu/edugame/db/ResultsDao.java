package ba.ibu.edugame.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ResultsDao {
    @Insert
    void insertResult(Results result);

    @Query("SELECT * FROM Results ORDER BY result DESC LIMIT 5")
    List<Results> getAll();

    @Query("SELECT * FROM Results ORDER BY result DESC")
    LiveData<List<Results>> getAllLive();

}
