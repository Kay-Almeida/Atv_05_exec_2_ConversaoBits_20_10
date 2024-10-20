package kailaine.mobile.atv_05_exec_2_conversaobits_20_10;
/*
 *@author:<Kailaine Almeida de Souza RA: 1110482313026>
 */
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etBits;
    private TextView tvRsultado, tvTexto1;
    private Button btnConverter;
    private RadioButton rbBytes, rbKB, rbMB, rbGB, rbTB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etBits = findViewById(R.id.etBits);
        tvRsultado = findViewById(R.id.tvRsultado);
        tvTexto1 = findViewById(R.id.tvTexto1);
        btnConverter = findViewById(R.id.btnConverter);
        rbBytes = findViewById(R.id.rbBytes);
        rbBytes.setChecked(true);
        rbKB = findViewById(R.id.rbKB);
        rbMB = findViewById(R.id.rbMB);
        rbGB = findViewById(R.id.rbGB);
        rbTB = findViewById(R.id.rbTB);
        
        btnConverter.setOnClickListener(op -> conversaoBits());

    }

    private void conversaoBits() {
        double bits = Double.parseDouble(etBits.getText().toString());
        double bytes = bits / 8.0;
        double kilobytes = bytes / 1024.0;
        double megabytes = kilobytes / 1024.0;
        double gigabytes = megabytes / 1024.0;
        double terabytes = gigabytes / 1024.0;

        if(rbBytes.isChecked()){
            tvRsultado.setText(bytes + " Bytes");
        }else if(rbKB.isChecked()){
            tvRsultado.setText(kilobytes + " KB");
        }else if(rbMB.isChecked()){
            tvRsultado.setText(megabytes + " MB");
        }else if(rbGB.isChecked()){
            tvRsultado.setText(gigabytes + " GB");
        }else if(rbTB.isChecked()){
            tvRsultado.setText(terabytes + " TB");
        }

        etBits.setText("");
    }
}