package com.example.alertdialog_text;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import static androidx.core.os.LocaleListCompat.create;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Popup1();
            }
        });



        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Popup2();
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Popup3();
            }
        });



        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Popup4();
            }
        });


        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Popup5();
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Popup6();
            }
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Popup7();
            }
        });

    }

    private void Popup1() {
        //创建弹窗构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("这个是标题！")
                .setMessage("信息内容...(2s后自动消失)")
                //点击窗口以外的区域，窗口消失 (默认为true)
                .setCancelable(false);
        //创建弹窗
        final AlertDialog dlg = builder.create();
        //窗口显示
        dlg.show();
        //时间线程，2s后执行里面的代码
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                //窗口消失
                dlg.dismiss();
            }
        }, 2000);
    }



    private void Popup2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("窗口二")
                .setMessage("点击按钮才消失")
                //点击窗口以外的区域，窗口消失 (默认为true)
                .setCancelable(false)
                //点击按钮，自动调用 dismiss()，弹窗消失
                .setPositiveButton("点我点我", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "窗口消失", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
    }



    private void Popup3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("窗口三")
                .setMessage("你喜欢吃苹果吗？")
                //点击窗口以外的区域，窗口消失 (默认为true)
                .setCancelable(false)
                //点击其中一个按钮才消失弹窗
                //一般有三个 Button类型：位置、命名不同，但方法一样
                // PositiveButton（确定，位置在最右边）,NegativeButton（否定，位置在最右边的左边）,NeutralButton（中立，位置在最左边）
                .setPositiveButton("喜欢", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你喜欢吃苹果", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("不喜欢", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"你不喜欢吃苹果",Toast.LENGTH_SHORT).show();
                    }
                }).setNeutralButton("不清楚", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"你纠结了",Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
    }





    private void Popup4() {
        // 创建弹窗构建器
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        // 注：必须在 window.setContentView之前 show, 否则会崩
        dialog.show();
        //点击窗口以外的区域，窗口消失 (默认为true)
        dialog.setCancelable(false);
        // 弹窗获取自定义的布局
        dialog.getWindow().setContentView(R.layout.activity_dialog1);

        //* 这里设置了，就显示这里的文字。把这段代码隐蔽就显示 xml那边的文字
        EditText dialogMessage =  dialog.findViewById(R.id.message); //*
//        dialogMessage.setText("信息内容...(这里是java)"); //*

        TextView tvDetermine =  dialog.findViewById(R.id.determine);
        //点击确定, 对话框才消失
        tvDetermine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //窗口消失
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "你点击了确定", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void Popup5() {
        // 创建字符串数组作为弹出菜单列表里的文本
        final String[] item = new String[]{"one","two","three","four","five"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // 点击窗口以外的区域，窗口消失 (默认为true)
        builder.setCancelable(false);
        // 设置弹出窗口标题
        builder.setTitle("选择其中一个");
        builder.setItems(item, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //gender[which]: 为输出文本，传入数组 items（一定要写后面的which序号）
                Toast.makeText(MainActivity.this, item[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }




    private void Popup6() {
        final String[] item = new String[]{"one", "two", "three", "four","five"};
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("选择其中一个")
                // checkedItem,默认选择：0表示选中第一个（以此类推）
                .setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你单选了" + item[which], Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", null)
                .create();
        alertDialog.show();
    }




    private void Popup7() {
        // 创建数据
        final String[] item = new String[]{"one", "two", "three", "four","five"};
        // 创建对话框构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("可以选择一个或多个")
                .setMultiChoiceItems(item,
                        // 列表里有几个 item，这里的数组长度几个就有几个，true为默认勾选，false则默认不勾选
                        new boolean[]{true, false, false, true, false},
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                // TODO Auto-generated method stub
                                if (isChecked) {
                                    Toast.makeText(MainActivity.this, item[which], Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", null)
                .create();
        builder.create().show();
    }







}