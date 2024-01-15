package ba.sum.fsre.nramu.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

import ba.sum.fsre.nramu.Activity.Domain.Foods;
import ba.sum.fsre.nramu.R;

public class BestFoodsAdapter extends RecyclerView.Adapter<BestFoodsAdapter.viewholder> {
    ArrayList<Foods> Items;
    Context context;

    public BestFoodsAdapter(ArrayList<Foods> items) {

        this.Items = items;



    }

    @NonNull
    @Override
    public BestFoodsAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_best_deal,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BestFoodsAdapter.viewholder holder, int position) {
         holder.titleTxt.setText(Items.get(position).getTitle());
         holder.priceTxt.setText("$"+Items.get(position).getPrice());
         holder.timeTxt.setText(Items.get(position).getTimeValue()+"min");
         holder.starTxt.setText(""+Items.get(position).getStar());

         Glide.with(context)
                 .load(Items.get(position).getImagePath())
                 .transform(new CenterCrop(),new RoundedCorners(30))
                 .into(holder.pic);
    }

    @Override
    public int getItemCount() {


        return Items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView titleTxt,priceTxt,starTxt,timeTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {

            super(itemView);
            titleTxt=itemView.findViewById(R.id.titleTxt);
            priceTxt=itemView.findViewById(R.id.priceTxt);
            starTxt=itemView.findViewById(R.id.starTxt);
            timeTxt=itemView.findViewById(R.id.timeTxt);
            pic=itemView.findViewById(R.id.pic);
        }


    }
}
