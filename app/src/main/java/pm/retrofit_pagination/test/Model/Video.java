package pm.retrofit_pagination.test.Model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Video {

    @SerializedName("Movie")
    @Expose
    private List<Movie> movie = null;
    @SerializedName("MESSAGE")
    @Expose
    private String message;
    @SerializedName("STATUS")
    @Expose
    private Integer status;

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}