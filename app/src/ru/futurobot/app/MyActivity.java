package ru.futurobot.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MyActivity extends Activity {

    final static String[] URLS = {"http://s7.pikabu.ru/post_img/2014/06/30/6/1404118161_10878986.png"
            , "http://s6.pikabu.ru/post_img/2014/06/30/7/1404125579_215142753.jpg"
            , "http://s6.pikabu.ru/post_img/2014/06/30/10/1404142645_1942854338.jpg"
            , "http://s4.pikabu.ru/post_img/2014/06/30/8/1404131590_778435710.png"
            , "http://s5.pikabu.ru/post_img/2014/06/30/8/1404131422_693514769.jpg"
            , "http://s4.pikabu.ru/post_img/2014/06/30/7/1404125620_437109483.jpg"
            , "http://s4.pikabu.ru/post_img/2014/06/30/7/1404122332_619950040.jpg"};


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView list = (ListView) findViewById(android.R.id.list);

        list.setAdapter(new MyAdapter(this, URLS));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url = URLS[i];
                Intent intent = new Intent(MyActivity.this, ImageBrowser.class);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }

    private class MyAdapter implements ListAdapter {

        final Context context;
        final String[] items;

        public MyAdapter(Context context, String[] items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override
        public boolean isEnabled(int i) {
            return true;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public int getCount() {
            return this.items.length;
        }

        @Override
        public String getItem(int i) {
            return this.items[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, viewGroup, false);

            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getItem(position));

            return view;
        }

        @Override
        public int getItemViewType(int i) {
            return 1;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }
}
