package com.christzhang.smartvideo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.christzhang.title.TitleBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regist extends AppCompatActivity {
private EditText email,name,pwd,repwd,phone,age;
private RadioGroup sex;
private RadioButton boy,girl;
private Button btn_subregist;
private TextView re_login;
private String email_info,name_info,phone_info,age_info,sex_info,pwd_info,repwd_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initTitle();
        initview();
        submitinfo();
    }

    private void initTitle() {
        // 1.设置左边的图片按钮显示，以及事件 2.设置中间TextView显示的文字 3.设置右边的图片按钮显示，并设置事件
        new TitleBuilder(this).setLeftImageRes(true, 0)
                .setLeftTextOrImageListener(true, null)
                .setMiddleTitleText("用户注册");
    }

    private void initview(){
        email=(EditText)findViewById(R.id.email);
        name=(EditText)findViewById(R.id.name);
        pwd=(EditText)findViewById(R.id.pwd);
        repwd=(EditText)findViewById(R.id.repwd);
        phone=(EditText)findViewById(R.id.phone);
        age=(EditText)findViewById(R.id.age);
        sex=(RadioGroup)findViewById(R.id.sex);
        boy=(RadioButton)findViewById(R.id.boy);
        girl=(RadioButton)findViewById(R.id.girl);
        btn_subregist=(Button)findViewById(R.id.btn_submit);
        re_login=(TextView)findViewById(R.id.returen_login);
        boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boy.setTextColor(android.graphics.Color.parseColor("#ffffff"));
                girl.setTextColor(android.graphics.Color.parseColor("#B6B5B8"));
            }
        });
        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boy.setTextColor(android.graphics.Color.parseColor("#B6B5B8"));
                girl.setTextColor(android.graphics.Color.parseColor("#ffffff"));
            }
        });
    }

    private void submitinfo(){
        re_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_relogin=new Intent(Regist.this,Login.class);
                startActivity(intent_relogin);
                finish();
            }
        });
        btn_subregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final  String reg_email = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
                final  String reg_name = "^.{3,12}$";
                final  String reg_password = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,14}$";
                final  String reg_phone = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
                final  String reg_age = "^[0-9]*$";
                email_info=email.getText().toString();
                name_info=name.getText().toString();
                phone_info=phone.getText().toString();
                age_info=age.getText().toString();
                pwd_info=pwd.getText().toString();
                repwd_info=repwd.getText().toString();
                switch (sex.getCheckedRadioButtonId())
                {
                    case R.id.boy:
                        sex_info=boy.getText().toString();
                        break;
                    case R.id.girl:
                        sex_info=girl.getText().toString();
                        break;
                }
                Pattern pattern_email = Pattern.compile(reg_email);
                Matcher matcher_email = pattern_email.matcher(email_info);
                Pattern pattern_name = Pattern.compile(reg_name);
                Matcher matcher_name = pattern_name.matcher(name_info);
                Pattern pattern_pwd = Pattern.compile(reg_password);
                Matcher matcher_pwd = pattern_pwd.matcher(pwd_info);
                Pattern pattern_phone = Pattern.compile(reg_phone);
                Matcher matcher_phone = pattern_phone.matcher(phone_info);
                Pattern pattern_age = Pattern.compile(reg_age);
                Matcher matcher_age = pattern_age.matcher(age_info);

                if(email_info.equals("")||email_info==null)
                {
                    Toast.makeText(Regist.this,"邮箱不能为空",Toast.LENGTH_SHORT).show();
                }
                else if(name_info.equals("")||name_info==null)
                {
                    Toast.makeText(Regist.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
                }
                else if(pwd_info.equals("")||pwd_info==null)
                {
                    Toast.makeText(Regist.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }
                else if(repwd_info.equals("")||repwd_info==null)
                {
                    Toast.makeText(Regist.this,"确认密码不能为空",Toast.LENGTH_SHORT).show();
                }
                else if(phone_info.equals("")||phone_info==null)
                {
                    Toast.makeText(Regist.this,"手机号不能为空",Toast.LENGTH_SHORT).show();
                }
                else if(age_info.equals("")||age_info==null)
                {
                    Toast.makeText(Regist.this,"年龄不能为空",Toast.LENGTH_SHORT).show();
                }
               else if(sex_info==null)
                {
                    Toast.makeText(Regist.this,"请选择性别",Toast.LENGTH_SHORT).show();
                }
                else if (!matcher_email.matches())
                {
                    Toast.makeText(Regist.this,"邮箱输入不合法",Toast.LENGTH_SHORT).show();
                }
                else if (!matcher_name.matches())
                {
                    Toast.makeText(Regist.this,"用户名必须为3-12位",Toast.LENGTH_SHORT).show();
                }
                else if(!(pwd_info.equals(repwd_info)))
                {
                    Toast.makeText(Regist.this,"两次输入密码不匹配",Toast.LENGTH_SHORT).show();
                }
                else if (!matcher_pwd.matches())
                {
                    Toast.makeText(Regist.this,"密码必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-14之间",Toast.LENGTH_SHORT).show();
                }
                else if (!matcher_phone.matches())
                {
                    Toast.makeText(Regist.this,"手机号输入不合法",Toast.LENGTH_SHORT).show();
                }
                else if (!matcher_age.matches())
                {
                    Toast.makeText(Regist.this,"年龄输入不合法",Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(age_info)<1||Integer.parseInt(age_info)>120)
                {
                    Toast.makeText(Regist.this,"年龄输入不合法",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Regist.this,email_info+" "+name_info+" "+phone_info+" "+age_info+" "+sex_info,Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
