package com.leo.mylauncher;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class AppsActivity extends AppCompatActivity {

    private List<ResolveInfo> apps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps);

        loadApps();
        GridView gridview = findViewById(R.id.apps_list);
        gridview.setAdapter(new AppsAdapter());
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ResolveInfo info = apps.get(position);
                //该应用的包名
                String pkg = info.activityInfo.packageName;
                //应用的主activity类
                String cls = info.activityInfo.name;

                ComponentName componet = new ComponentName(pkg, cls);

                Intent i = new Intent();
                i.setComponent(componet);
                startActivity(i);
            }
        });
    }

    private void loadApps() {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        apps = getPackageManager().queryIntentActivities(mainIntent, 0);
    }

    public class AppsAdapter extends BaseAdapter {

        public AppsAdapter(){
        }

        @Override
        public int getCount() {
            return apps.size();
        }

        @Override
        public Object getItem(int i) {
            return apps.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView iv;

            if(view == null){
                iv = new ImageView(AppsActivity.this);
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                iv.setLayoutParams(new GridView.LayoutParams(100, 100));
            } else {
                iv = (ImageView) view;
            }
            ResolveInfo info = apps.get(i);
            iv.setImageDrawable(info.activityInfo.loadIcon(getPackageManager()));
            return iv;
        }
    }
}
