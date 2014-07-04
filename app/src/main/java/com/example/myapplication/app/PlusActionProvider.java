package com.example.myapplication.app;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class PlusActionProvider extends ActionProvider {

    private Context context;

    public PlusActionProvider(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View onCreateActionView() {
        return null;
    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        subMenu.add(context.getString(R.string.plus_group_chat))
                .setIcon(R.drawable.ic_action_group)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        return true;
                    }
                });
        subMenu.add(context.getString(R.string.plus_add_friend))
                .setIcon(R.drawable.ic_action_add_person)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        return false;
                    }
                });
        subMenu.add(context.getString(R.string.plus_take_photo))
                .setIcon(R.drawable.ic_action_camera)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
    }
    @Override
    public boolean hasSubMenu() {
        return true;
    }
}
