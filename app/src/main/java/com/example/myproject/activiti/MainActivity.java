package com.example.myproject.activiti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myproject.R;
import com.example.myproject.database.AppDatabase;
import com.example.myproject.database.Product;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppDatabase db;
    private Context context;
    EditText edName,edQuantity;
    Button btAdd,btView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);
        context = this;
        db = AppDatabase.getAppDatabase((context));
        
        edName = findViewById(R.id.edName);
        edQuantity = findViewById(R.id.edQuantity);
        btAdd = findViewById(R.id.btAdd);
        btView = findViewById(R.id.btView);
        btAdd.setOnClickListener(this);
        btView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btAdd:
                onRegister();
                break;
            case R.id.btView:
                onView();
                break;
            default:
                break;
        }
        

    }

    private void onView() {

    }

    private void onRegister() {

        Product product = new Product();
        product.name = edName.getText().toString();
        product.quantity = Integer.valueOf(edQuantity.getText().toString());
        long id = db.productDao().insertProduct(product);
        if(id > 0){
            Toast.makeText(this,"Add Success",Toast.LENGTH_SHORT).show();
        }
    }
}