package ba.sum.fsre.nramu.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
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

import ba.sum.fsre.nramu.Activity.Domain.Category;
import ba.sum.fsre.nramu.Activity.Domain.Foods;
import ba.sum.fsre.nramu.Activity.ListFoodsActivity;
import ba.sum.fsre.nramu.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {
    ArrayList<Category> Items;
    Context context;

    public CategoryAdapter(ArrayList<Category> items) {

        this.Items = items;



    }

    @NonNull
    @Override
    public CategoryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewholder holder, int position) {
        holder.titleTxt.setText(Items.get(position).getName());

         switch (position){
             case 0:{
                 holder.pic.setBackgroundResource(R.drawable.cat_0_background);
                 break;
             }
             case 1:{
                 holder.pic.setBackgroundResource(R.drawable.cat_1_background);
                 break;
             }
             case 2:{
                 holder.pic.setBackgroundResource(R.drawable.cat_2_background);
                 break;
             }
             case 3:{
                 holder.pic.setBackgroundResource(R.drawable.cat_3_background);
                 break;
             }
             case 4:{
                 holder.pic.setBackgroundResource(R.drawable.cat_4_background);
                 break;
             }
             case 5:{
                 holder.pic.setBackgroundResource(R.drawable.cat_5_background);
                 break;
             }
             case 6:{
                 holder.pic.setBackgroundResource(R.drawable.cat_6_background);
                 break;
             }
             case 7:{
                 holder.pic.setBackgroundResource(R.drawable.cat_7_background);
                 break;
             }
         }
         int drawableResourceId=context.getResources().getIdentifier(Items.get(position).getImagePath(),
                 "drawable",holder.itemView.getContext().getPackageName());
         Glide.with(context)
                 .load(drawableResourceId)
                 .into(holder.pic);
         holder.itemView.setOnClickListener(v -> {
             Intent intent=new Intent(context, ListFoodsActivity.class);
             intent.putExtra("categoryId",Items.get(position).getId());
             intent.putExtra("categoryName",Items.get(position).getName());
             context.startActivity(intent);
         });
    }

    @Override
    public int getItemCount() {


        return Items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView titleTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {

            super(itemView);
            titleTxt=itemView.findViewById(R.id.catNameTxt);
            pic=itemView.findViewById(R.id.imgCat);
        }


    }
}
