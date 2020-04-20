package com.example.mainscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class fxListviewAdapter extends BaseAdapter { //커스텀 리스트뷰 어댑터를 만들기 위해 BaseAdapter를 상속받는다.

    public ArrayList<fxListviewItem> fxItemList = new ArrayList<fxListviewItem>(); //데이터를 제공해줄 리스트

    @Override
    public int getCount() {
        return fxItemList.size();
    } //리스트뷰 아이템 개수

    @Override
    public Object getItem(int position) {
        return fxItemList.get(position);
    } //item은 리스트의 position자리에 있는 값을 받아오면 됨

    @Override
    public long getItemId(int position) {
        return position;
    } //각 아이템의 id는 position 값이다.

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //아이템마다 적용될 layout을 적용해준다.
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview, parent, false);
        } //뷰가 비어있으면 listview라는 레이아웃을 적용시켜라

        TextView tv_element = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tv_grage = (TextView) convertView.findViewById(R.id.tv_grade);
        ImageView iv_fx = (ImageView) convertView.findViewById(R.id.iv_fx);

        fxListviewItem fxitem = fxItemList.get(position); //fxitem은 데이터 제공 리스트의 position 자리 값이다.

        tv_element.setText(fxitem.getTitle());
        tv_grage.setText(fxitem.getGrade());
        iv_fx.setImageResource(fxitem.getImage());
        //fxListviewItem 클라쓰에 있는 메서드를 통해 title, grade 값을 받아오고 textview 설정

        return convertView;
    }

    public void additem (String text1, String text2, int image) { //additem 메서드 정의
        fxListviewItem item = new fxListviewItem();
        item.setTitle(text1);
        item.setGrade(text2);
        item.setImage(image);

        fxItemList.add(item);
    }
}
