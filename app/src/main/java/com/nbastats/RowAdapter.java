package com.nbastats;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kevin_maussion on 09/04/2016.
 */
public class RowAdapter extends ArrayAdapter<Row> {


        public RowAdapter(Context context, List<Row> row) {
            super(context, 0, row);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout,parent, false);
            }

            RowViewHolder viewHolder = (RowViewHolder) convertView.getTag();
            if(viewHolder == null){
                viewHolder = new RowViewHolder();
                viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
                viewHolder.text = (TextView) convertView.findViewById(R.id.text);
                viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
                convertView.setTag(viewHolder);
            }

            //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
            Row row = getItem(position);

            //il ne reste plus qu'à remplir notre vue
            viewHolder.pseudo.setText(row.getPseudo());
            viewHolder.text.setText(row.getText());
            viewHolder.avatar.setImageDrawable(new ColorDrawable(row.getColor()));

            return convertView;
        }

        private class RowViewHolder{
            public TextView pseudo;
            public TextView text;
            public ImageView avatar;
        }
}

