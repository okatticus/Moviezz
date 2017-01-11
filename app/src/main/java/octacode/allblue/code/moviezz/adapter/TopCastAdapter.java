package octacode.allblue.code.moviezz.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import octacode.allblue.code.moviezz.FeaturedCrew;
import octacode.allblue.code.moviezz.R;

/**
 * Created by shasha on 11/1/17.
 */

public class TopCastAdapter extends RecyclerView.Adapter<TopCastAdapter.TopCastHolder> {

    private List<FeaturedCrew> mFeaturedCast;
    private Context mContext;
    @Override
    public TopCastHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_cast_list_item,parent,false);
        return new TopCastHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopCastHolder holder, int position) {
        FeaturedCrew featuredCast = mFeaturedCast.get(position);
        holder.top_name.setText(featuredCast.getName());
        holder.top_role.setText(featuredCast.getRole());
        Picasso.with(mContext).load(featuredCast.getId_url()).error(R.mipmap.ic_launcher).into(holder.cast_image);
    }

    public TopCastAdapter(Context context, List<FeaturedCrew> crewList){
        mContext=context;
        mFeaturedCast=crewList;
    }

    @Override
    public int getItemCount() {
        return mFeaturedCast.size();
    }

    public class TopCastHolder extends RecyclerView.ViewHolder{

        public TextView top_name,top_role;
        public ImageView cast_image;

        public TopCastHolder(View itemView) {
            super(itemView);
            top_name=(TextView)itemView.findViewById(R.id.cast_tv_list_name);
            top_role = (TextView)itemView.findViewById(R.id.cast_tv_list_role);
            cast_image = (ImageView)itemView.findViewById(R.id.cast_image_list_item);
        }
    }
}