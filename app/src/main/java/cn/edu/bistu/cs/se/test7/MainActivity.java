package cn.edu.bistu.cs.se.test7;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
   // private static final String TAG="TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) this.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("请正确输入账号和密码！")//显示的消息内容
                            .setTitle("Attention");//对话框标题

                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "已确认", Toast.LENGTH_LONG).show();

                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MainActivity.this, "已取消", Toast.LENGTH_LONG).show();

                                }
                    });
                    builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "已忽略", Toast.LENGTH_LONG).show();

                        }

                    });
                    builder.show();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();

                view = inflater.inflate(R.layout.login_dialog,null);
                editText1 = (EditText)view.findViewById(R.id.editTextUserId);
                editText2 = (EditText)view.findViewById(R.id.editTextPwd);

                builder.setView(inflater.inflate(R.layout.login_dialog, null))
                        .setTitle("Login")
                        // Add action buttons
                        .setPositiveButton(R.string.login,new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int id) {
//                                Log.i(TAG, String.valueOf(editText1));
                                if (editText1.getText().toString().equals("abc") && editText2.getText().toString().equals("123")){
                                    Toast.makeText(MainActivity.this,"Login",Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(MainActivity.this,"Not Login",Toast.LENGTH_LONG).show();
                                }

                            }
                        })
                        .setNegativeButton(R.string.cancel,new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });

                builder.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
