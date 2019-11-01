package com.example.myapplication11;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication11.R;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText mileage_in;
    EditText addition_in;
    EditText amount_in;
    TextView amount_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mileage_in = (EditText)findViewById(R.id.mileage_in);// 取得里程物件
        addition_in = (EditText)findViewById(R.id.addition_in);// 取得每行進里程物件
        amount_in = (EditText)findViewById(R.id.amount_in);// 取得加錢物件
        amount_out= (TextView) findViewById(R.id.amount_out);
        Button submit = (Button)findViewById(R.id.output);
        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                //判斷條件 總里程,每行進里程,+多少錢 都要輸入值才能執行
                int num1 = Integer.parseInt(mileage_in.getText().toString());
                int num2=Integer.parseInt(addition_in.getText().toString());

                if (num1<num2) {
                    amount_out.setText("75元");




                }
                else  if (num1>num2) {
                    float fresult_out = Float.parseFloat(mileage_in.getEditableText().toString());      // 取得里程輸入值
                    float addition = Float.parseFloat(addition_in.getEditableText().toString());      // 取得每行進里程輸入值
                    float amount = Float.parseFloat(amount_in.getEditableText().toString());      // 取得加錢額輸入值
                    TextView result = (TextView)findViewById(R.id.amount_out);// 取得顯示結果物件
                    fresult_out = ((fresult_out/addition)*amount)+75;
                    NumberFormat nf = NumberFormat.getInstance();   // 數字格式
                    nf.setMaximumFractionDigits(2);                 // 限制小數第二位
                    result.setText(nf.format(fresult_out) +"元");           // 顯示計算結果



                }

            }
        });
    }
}