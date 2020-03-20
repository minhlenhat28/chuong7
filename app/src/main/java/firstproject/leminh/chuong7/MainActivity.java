package firstproject.leminh.chuong7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    NhanVienAdapter nhanVienAdapter;
    ArrayList<NhanVien> nhanViens = new ArrayList<>();
    EditText editTextmanv;
    EditText editTexttennv;
    RadioGroup radioGroup;
    Button nhap;
    int gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextmanv = (EditText) findViewById(R.id.manv);
        editTexttennv = (EditText) findViewById(R.id.tennv);
        radioGroup = (RadioGroup) findViewById(R.id.gioitinh);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        nhap = (Button) findViewById(R.id.nhapsv);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getCheckedRadioButtonId() == R.id.nu){
                    gender = R.drawable.icons8_female_24;
                }else if(group.getCheckedRadioButtonId() == R.id.nam){
                    gender = R.drawable.icons8_male_24;
                }
            }
        });

       nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nhanViens.add(new NhanVien(String.valueOf(editTextmanv.getText()),String.valueOf(editTexttennv.getText()),gender));
                nhanVienAdapter = new NhanVienAdapter(recyclerView,MainActivity.this,nhanViens);
                recyclerView.setAdapter(nhanVienAdapter);
                //nhanVienAdapter.notifyItemInserted(nhanViens.size())

              ;
            }
        });
    }
}
