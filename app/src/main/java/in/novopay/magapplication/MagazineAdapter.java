package in.novopay.magapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.List;

import in.novopay.magapplication.model.Collection1;

/**
 * Created by bupeshkumar on 8/7/15.
 */
public class MagazineAdapter extends BaseAdapter{

    List<Collection1> magazineList ;
    WeakReference<Context> contextWeakReference;

    public MagazineAdapter(Context context, List<Collection1> magazineList) {
        this.magazineList = magazineList;
        this.contextWeakReference = new WeakReference<Context>(context) ;
    }



    @Override
    public int getCount() {
        return magazineList.size();
    }

    @Override
    public Collection1 getItem(int position) {
        return magazineList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        ImageView magazineCover;
        TextView magazineTitle;
        TextView magazineDescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(contextWeakReference.get());
            view = layoutInflater.inflate(R.layout.list_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.magazineTitle = (TextView) view.findViewById(R.id.magazine_title);
            viewHolder.magazineDescription = (TextView) view.findViewById(R.id.magazine_description);
            viewHolder.magazineCover = (ImageView) view.findViewById(R.id.magazine_cover);

            view.setTag(viewHolder);
        }

        if (viewHolder == null) {
            viewHolder = (ViewHolder) view.getTag();
        }

        Collection1 collection1 = getItem(position);

        viewHolder.magazineTitle.setText(collection1.getMagazinename().getText());
        Picasso
                .with(contextWeakReference.get())
                .load(collection1.getMagazinephoto().getSrc())
                .into(viewHolder.magazineCover);
        viewHolder.magazineDescription.setText(collection1.getMagazinedesc());
        return view;

    }
}
