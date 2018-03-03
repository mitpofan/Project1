package com.example.lisow.application;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements View.OnClickListener {


    EditText edEmail;
    EditText edLogin;
    EditText edPassword;
    Button but;
    DbHelper db; // объект для управления базой
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edEmail = (EditText) findViewById(R.id.editMail);
        edLogin = (EditText) findViewById(R.id.editLogin);
        edPassword = (EditText) findViewById(R.id.editPassword);
        but = (Button) findViewById(R.id.Registration);
        but.setOnClickListener(this);
        db = new DbHelper(this);

    }

    @Override
    public void onClick(View view) {
        ContentValues newValues = new ContentValues();// строка со значениями для вставки
        // Считаем данные с полей для ввода и запишем в строковые переменные:
        String email = edEmail.getText().toString();
        String login = edEmail.getText().toString();
        String password = edEmail.getText().toString();
        SQLiteDatabase database = db.getWritableDatabase(); // подключаемся к базе(хз че такое пока что толком)
        // хотя тут одна кнопка, но вдруг еще какие то будут, я хз
        switch (view.getId()){
            case R.id.Registration:// Зададим значение для каждой строки таблицы
                newValues.put("E_MAIL_COLUMN", email);
                newValues.put("LOGIN_COLUMN",login);
                newValues.put("PASSWORD_COLUMN ", password);
                database.insert("Users", null, newValues);
                Toast.makeText(this,"Пользователь зарегистрирован", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
