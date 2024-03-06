package ba.sum.fsre.nramu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import ba.sum.fsre.nramu.Activity.Adapter.CartAdapter;
import ba.sum.fsre.nramu.Activity.Helper.ChangeNumberItemsListener;
import ba.sum.fsre.nramu.Activity.Helper.ManagmentCart;
import ba.sum.fsre.nramu.R;
import ba.sum.fsre.nramu.databinding.ActivityCartBinding;

public class CartActivity extends BaseActivity {
private ActivityCartBinding binding;
private RecyclerView.Adapter adapter;
private ManagmentCart managmentCart;
private double tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managmentCart=new ManagmentCart(this);

        setVariable();
        calculateCart();
        initList();
    }

    private void initList() {
        if(managmentCart.getListCart().isEmpty()){
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollviewCart.setVisibility(View.GONE);
    }else{
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollviewCart.setVisibility(View.VISIBLE);
        }

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        binding.cartView.setLayoutManager(linearLayoutManager);
        adapter=new CartAdapter(managmentCart.getListCart(),this, () -> calculateCart());
        binding.cartView.setAdapter(adapter);
    }

    private void calculateCart() {
        //double parcentTax=0.02; // 2%
        double delivery=10; // Dolar

        tax=Math.round((managmentCart.getTotalFee())*100.0)/100.0;

        double total = Math.round((managmentCart.getTotalFee()+delivery)*100.0)/100.0;
        double itemTotal=Math.round(managmentCart.getTotalFee()*100.0)/100.0;

        binding.totalFeeTxt.setText("$"+itemTotal);

        binding.deliveryTxt.setText("$"+delivery);
        binding.totalTxt.setText("$"+total);
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
    }
}