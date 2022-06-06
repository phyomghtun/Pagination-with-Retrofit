package pm.retrofit_pagination.test.Service;

import pm.retrofit_pagination.test.Model.Movie;
import pm.retrofit_pagination.test.Model.Video;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieJson {
    @GET("/videoapi.php")
    Call<Video> getMovieData(@Query("page") int page, @Query("status") String status);
}
