package pm.retrofit_pagination.test.Adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import pm.retrofit_pagination.test.Model.Movie;
import pm.retrofit_pagination.test.R;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;

    List<Movie> getDataAdapter;


    public RecyclerAdapter(List<Movie> getDataAdapter, Context context) {

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        Movie getDataAdapter1 = getDataAdapter.get(position);

        Viewholder.title.setText(getDataAdapter1.getTitle());

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.isMemoryCacheable();
        Glide.with(Viewholder.itemView)
                .setDefaultRequestOptions(requestOptions)
                .load(getDataAdapter1.getVideo())
                .into(Viewholder.networkImageView);

        Viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
//                Intent i=new Intent(context, DetailsActivity.class);
//                i.putExtra("link",link);
//                i.putExtra("image",img);
//                i.putExtra("title",title);
//                i.putExtra("time",time);
//                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }
    /////////////

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView networkImageView;
        public TextView title;

        public ViewHolder(View itemView) {

            super(itemView);

            context = itemView.getContext();

            title = (TextView) itemView.findViewById(R.id.title);

            networkImageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }

}
