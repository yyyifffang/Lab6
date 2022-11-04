package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    class Data{
        int photo;
        String name;
    }

    public class  MyAdapter extends BaseAdapter{ //繼承baseadapter
        private  MainActivity.Data[] data; //保存在myadapter之中的資料來源
        private int view; //保存在myadapter之中的畫面
        //透過建構子儲存資料來源與畫面到myadapter
        public MyAdapter (MainActivity.Data[] data, int view){
            this.data = data;
            this.view = view;
        }
        //回傳資料來源筆數
        @Override
        public int getCount() {
            return data.length;
        }
        //回傳某筆項目
        @Override
        public Object getItem(int position) {
            return  data[position];
        }
        //回傳某筆項目ID
        @Override
        public long getItemId(int position) {
            return 0;
        }
        //取得畫面元件
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //取得xml畫面
            convertView = getLayoutInflater().inflate(view,parent,false);
            //連接textview元件
            TextView name = convertView.findViewById(R.id.name);
            //根據position把字串顯示到textview
            name.setText(data[position].name);
            //連接imageview元件
            ImageView imageView = convertView.findViewById(R.id.imageView);
            //根據position把圖片顯示到imageview
            imageView.setImageResource(data[position].photo);
            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //第一步：建立資料來源，用陣列方式宣告自行設計的類別，並為陣列的每個內容填入要顯示的資料
        String[] transNameArray = new String[]{"腳踏車","機車","汽車","巴士"};
        int[] transPhotoIdArray = new int[]{R.drawable.trans1,R.drawable.trans2,R.drawable.trans3,R.drawable.trans4};
        Data[] transDate = new Data[transNameArray.length];
        for(int i=0;i<transDate.length;i++){
            transDate[i] = new Data(); //java物件導向的特性，每個陣列物件都必須要產生實體
            transDate[i].name = transNameArray[i];
            transDate[i].photo = transPhotoIdArray[i];
        }
        //第二步：建立myadapter物件，並放入transdata與trans_list.xml
        MyAdapter transAdapter = new MyAdapter(transDate,R.layout.trans_list);
        //第三步：連接spinner元件，並連接myadapter
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(transAdapter);

        //第一步：建立資料來源(字串)
        String[] messageArray = new String[]{"訊息1","訊息2","訊息3","訊息4","訊息5","訊息6"};
        //第二步：建立adapter物件，並放入字串與simple_list_item_1.xml
        ArrayAdapter<String> messageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,messageArray);
        //第三步：連接listview元件，並連接adapter
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(messageAdapter);

        //第一步：建立資料來源，用陣列方式宣告自行設計的類別，並為陣列的每個內容填入要顯示的資料
        String[] cubeeNameArray = new String[]{"哭哭","發抖","再見","生氣","昏倒","竊笑","很棒","你好","驚嚇","大笑"};
        int[] cubeePhotoIdArray = new int[]{R.drawable.cubee1,R.drawable.cubee2,R.drawable.cubee3,
                R.drawable.cubee4,R.drawable.cubee5,R.drawable.cubee6,R.drawable.cubee7,R.drawable.cubee8,R.drawable.cubee9,R.drawable.cubee10};
        Data[] cubeeData = new Data[cubeePhotoIdArray.length];
        for(int i=0;i<cubeeData.length;i++){
            cubeeData[i] = new Data();
            cubeeData[i].name = cubeeNameArray[i];
            cubeeData[i].photo = cubeePhotoIdArray[i];
        }
        //第二步：建立Myapdater物件，並放入cubeedata與cubee_list.xml
        MyAdapter cubeeAdapter = new MyAdapter(cubeeData,R.layout.cubee_list);
        //第三步：連接gridview元件，並連接myadpater
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(cubeeAdapter);
        gridView.setNumColumns(3);

    }
}