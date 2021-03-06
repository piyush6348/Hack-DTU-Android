package com.hackdtu.healthhistory.model;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hackdtu.healthhistory.R;
import com.hackdtu.healthhistory.activity.DiseaseListActivity;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by Nimit Agg on 11-02-2017.
 */

@Layout(R.layout.drawer_item)
public class DrawerMenuItem {

    public static final int DRAWER_MENU_ITEM_PROFILE = 1;
    public static final int DRAWER_MENU_ITEM_REQUESTS = 2;
    public static final int DRAWER_MENU_ITEM_GROUPS = 3;
    public static final int DRAWER_MENU_ITEM_MESSAGE = 4;


    private int mMenuPosition;
    private Context mContext;
    private DrawerCallBack mCallBack;

    @View(R.id.itemNameTxt)
    private TextView itemNameTxt;

    @View(R.id.itemIcon)
    private ImageView itemIcon;

    public DrawerMenuItem(Context context, int menuPosition) {
        mContext = context;
        mMenuPosition = menuPosition;
    }

    @Resolve
    private void onResolved() {
        switch (mMenuPosition){
            case DRAWER_MENU_ITEM_PROFILE:
                itemNameTxt.setText("Disease History");
                itemNameTxt.setOnClickListener(new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View view) {
                        mContext.startActivity(new Intent(mContext, DiseaseListActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    }
                });
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.ic_launcher));
                break;
            case DRAWER_MENU_ITEM_REQUESTS:
                itemNameTxt.setText("Sugar Level History");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.ic_launcher));
            break;
            case DRAWER_MENU_ITEM_GROUPS:
                itemNameTxt.setText("Blood Pressure History");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.ic_launcher));
                break;
            case DRAWER_MENU_ITEM_MESSAGE:
                itemNameTxt.setText("Additional notes");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.ic_launcher));
                break;
        }
    }

    @Click(R.id.mainView)
    private void onMenuItemClick(){
        switch (mMenuPosition){
            case DRAWER_MENU_ITEM_PROFILE:
               // Toast.makeText(mContext, "Profile", Toast.LENGTH_SHORT).show();

                if(mCallBack != null)
                    //mContext.startActivity(new Intent(mContext, DiseaseListActivity.class));
                    mCallBack.onProfileMenuSelected();
                break;
            case DRAWER_MENU_ITEM_REQUESTS:
               // Toast.makeText(mContext, "Requests", Toast.LENGTH_SHORT).show();
                if(mCallBack != null)mCallBack.onRequestMenuSelected();
                break;
            case DRAWER_MENU_ITEM_GROUPS:
             //   Toast.makeText(mContext, "Groups", Toast.LENGTH_SHORT).show();
                if(mCallBack != null)mCallBack.onGroupsMenuSelected();
                break;
            case DRAWER_MENU_ITEM_MESSAGE:
                Toast.makeText(mContext, "Messages", Toast.LENGTH_SHORT).show();
                if(mCallBack != null)mCallBack.onMessagesMenuSelected();
                break;
        }
    }

    public void setDrawerCallBack(DrawerCallBack callBack) {
        mCallBack = callBack;
    }

    public interface DrawerCallBack{
        void onProfileMenuSelected();
        void onRequestMenuSelected();
        void onGroupsMenuSelected();
        void onMessagesMenuSelected();
    }
}