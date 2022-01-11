package com.example.a20211201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);
        EditText sex = findViewById(R.id.sex);
        name.setHint("name");
        phone.setHint("phone");
        sex.setHint("sex");
    }
    public void save (View view){
        EditText name = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);
        EditText sex = findViewById(R.id.sex);

        SharedPreferences settings = getSharedPreferences("DATA", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("name",name.getText().toString());
        editor.putString("phone",phone.getText().toString());
        editor.putString("sex",sex.getText().toString());
        editor.commit();
    }
    public void read (View view){
        TextView name = findViewById(R.id.name);
        TextView phone = findViewById(R.id.phone);
        TextView sex = findViewById(R.id.sex);

        name.setText(read_name());
        phone.setText(read_phone());
        sex.setText(read_sex());
    }
    private String read_name(){
        /**創建SharedPreferences，索引為"Data"*/
        SharedPreferences settings = getSharedPreferences("DATA", Context.MODE_PRIVATE);
        /**回傳在"Saved"索引之下的資料；若無儲存則回傳"未存任何資料"*/
        return settings.getString("name","無資料");
    }
    private String read_phone(){
        /**創建SharedPreferences，索引為"Data"*/
        SharedPreferences settings = getSharedPreferences("DATA", Context.MODE_PRIVATE);
        /**回傳在"Saved"索引之下的資料；若無儲存則回傳"未存任何資料"*/
        return settings.getString("phone","無資料");
    }
    private String read_sex(){
        /**創建SharedPreferences，索引為"Data"*/
        SharedPreferences settings = getSharedPreferences("DATA", Context.MODE_PRIVATE);
        /**回傳在"Saved"索引之下的資料；若無儲存則回傳"未存任何資料"*/
        return settings.getString("sex","無資料");
    }
    public void clear (View view) {
        /**創建SharedPreferences*/
        SharedPreferences sharedPreferences = getSharedPreferences("DATA", Context.MODE_PRIVATE);
        /**取得SharedPreferences.Editor*/
        SharedPreferences.Editor editor = sharedPreferences.edit();
        /**利用clear清除掉所有資料*/
        editor.clear();
        /**不返回結果的提交*/
        /**若需要提交結果，則可使用.commit()*/
        editor.apply();
    }
}