package pm.retrofit_pagination.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import pm.retrofit_pagination.test.Adapter.RecyclerAdapter;
import pm.retrofit_pagination.test.Model.Movie;
import pm.retrofit_pagination.test.Model.Video;
import pm.retrofit_pagination.test.Service.ApiUti;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private ProgressBar loadingPB;
    private NestedScrollView nestedSV;
    RecyclerAdapter recyclerViewadapter;
    RecyclerView mRecyclerView;
    List<Movie> GetDataAdapter1;
    Movie GetDataAdapter2;
    int count = 0;
    int page=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerview);
        nestedSV = findViewById(R.id.idNestedSV);
        loadingPB = findViewById(R.id.idPBLoading);

        GetDataAdapter1 = new ArrayList<>();
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        Movies(page,"active");

        nestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    count++;
                    loadingPB.setVisibility(View.VISIBLE);
                    if (count < 5) {
                        page++;

                        // hub.show();
                        Movies(page,"active");
                    }
                }
            }
        });

    }
    private void Movies(int page_num,String status){

        ApiUti.mMovie().getMovieData(page_num,status).enqueue(new Callback<Video>() {

            @Override
            public void onResponse(Call<Video> call, retrofit2.Response<Video> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null) {

                        for (int i = 0; i < response.body().getMovie().size(); i++)
                        {
                            try {
                                GetDataAdapter2 =new Movie();
                                Log.i("post_title", response.body().getMovie().get(i).getTitle());
                                Log.i("post_video", response.body().getMovie().get(i).getVideo());

                                GetDataAdapter2.setTitle(response.body().getMovie().get(i).getTitle());
                                GetDataAdapter2.setVideo(response.body().getMovie().get(i).getVideo());

                                GetDataAdapter1.add(GetDataAdapter2);

                            } catch (Exception e) {

                            }
                    }

                    }

                }
                Log.i("post", String.valueOf(GetDataAdapter1.size()));
                recyclerViewadapter = new RecyclerAdapter(GetDataAdapter1, MainActivity.this);
                mRecyclerView.setAdapter(recyclerViewadapter);

            }

            @Override
            public void onFailure(Call<Video> call, Throwable t) {
                Log.i("post_",t.toString());
            }
        });

    }
}