package ba.ibu.edugame.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(foreignKeys = @ForeignKey(entity = Users.class, parentColumns = "users_id", childColumns = "userId"))
public class Results implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "results_id")
    public int id;

    @NonNull
    public int userId;

    @NonNull
    public double result;

    // Constructor
    public Results(int userId, double result) {
        this.userId = userId;
        this.result = result;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String resultToString() {
        return result + "";
    }
}
