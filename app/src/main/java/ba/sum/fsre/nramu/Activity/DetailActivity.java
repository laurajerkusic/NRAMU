package ba.sum.fsre.nramu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;

import ba.sum.fsre.nramu.Activity.Domain.Foods;
import ba.sum.fsre.nramu.Activity.Helper.ManagmentCart;
import ba.sum.fsre.nramu.R;
import ba.sum.fsre.nramu.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
private Foods object;
private int num=1;
private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        getIntentExtra();
        setVariable();

    }

    private void setVariable() {
        managmentCart=new ManagmentCart(this);
        binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(DetailActivity.this)
                .load(object.getImagePath())
                .into(binding.pic);

        binding.priceTxt.setText("$" + object.getPrice());
        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getDescription());
        binding.rateTxt.setText(object.getStar() + "Rating");
        binding.ratingBar.setRating((float) object.getStar());


        binding.plusBtn.setOnClickListener(v -> {
            num++;
            binding.numTxt.setText(num+ " ");
            binding.totalBtn.setText("$"+( num* object.getPrice()));
        });

        binding.minusBtn.setOnClickListener(v -> {
            if(num>1){
                num--;
                binding.numTxt.setText(num+ " ");
                binding.totalBtn.setText("$"+( num* object.getPrice()));
            }
        });

        binding.addBtn.setOnClickListener(v -> {
            object.setNumberInCart(num);
            managmentCart.insertFood(object);
        });
    }

    private void getIntentExtra() {
        object= (Foods) getIntent().getSerializableExtra("object");
    }


}