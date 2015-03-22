package com.cyo.ex2_2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private List<team> list;
    private ListView listview;
    private TextView tv_num;
    private TextView tv_name;

    private class teamAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;

        public teamAdapter(Context context) {
            // teamList儲存ListView各列對應的資料
//            用list把資料物件包裝起來
            list = new ArrayList<>();
            list.add(new team(R.drawable.p1, 1, "巴爾的摩金鷹"));
            list.add(new team(R.drawable.p2, 2, "芝加哥白襪"));
            list.add(new team(R.drawable.p3, 3, "洛杉磯天使"));
            list.add(new team(R.drawable.p4, 4, "波士頓紅襪"));
            list.add(new team(R.drawable.p5, 5, "克里夫蘭印地安人"));
            list.add(new team(R.drawable.p6, 6, "奧克蘭運動家"));
            list.add(new team(R.drawable.p7, 7, "紐約洋基"));
            list.add(new team(R.drawable.p8, 8, "底特律老虎"));
            list.add(new team(R.drawable.p9, 9, "西雅圖水手"));
            list.add(new team(R.drawable.p10, 10, "坦帕灣光芒"));

//          ???????
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        // ListView總列數
        public int getCount() {
            return list.size();
        }


        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return list.get(position).getTeam_num();
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.listview, parent, false);
            }
            // 依照position取得teamList內的team物件
            //final???
            final team team = list.get(position);

            // 找到convertView子元件imageView，並指定欲顯示的圖檔
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            imageView.setImageResource(team.getTeam_pic());
            // 找到convertView子元件textView，並指定欲顯示的文字值
            tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            tv_num.setText(Integer.toString(team.getTeam_num()));
            tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            tv_name.setText(team.getTeam_name());

//          每次產生view時加入tv_num及tv_name的  ClickListener
            tv_num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, Integer.toString(team.getTeam_num())
                            , Toast.LENGTH_SHORT).show();
                }
            });
            tv_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, team.getTeam_name(), Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      設定contextview為activity_main
        setContentView(R.layout.activity_main);

        findViews();

    }

    public void findViews() {
        listview = (ListView) findViewById(R.id.listView);
//      livtview製造一個Adapter，並且傳入一個物件teamAdapter，該物件傳入MainActivity這個view
        listview.setAdapter(new teamAdapter(this));

//      建立ClickListener監聽listview
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String info = list.get(position).getTeam_num() + " " + list.get(position).getTeam_name();
//                字串透過onItemClick裡面參數position，陣列list中取得索引position的號碼、內容
                Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
//                讓字串跳出顯示
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
