package hapybdaymachi.blueangel.com.hapybdaymachi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Ashith VL on 12/20/2016.
 */

public class ImagesQuotesAdapter extends BaseAdapter {

    private final Context mContext;
    private final ImagesQuotes[] imagesQuotes;

    // 1
    public ImagesQuotesAdapter(Context context, ImagesQuotes[] imagesQuotes) {
        this.mContext = context;
        this.imagesQuotes = imagesQuotes;
    }

    // 2
    @Override
    public int getCount() {
        return imagesQuotes.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ImagesQuotes imagesQuote = imagesQuotes[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.single_item, null);

            final ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

            final ViewHolder viewHolder = new ViewHolder(imageView);
            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder)convertView.getTag();

        //viewHolder.imageView.setImageResource(imagesQuote.getImages());
        //picasoo
        Picasso.with(mContext).load(imagesQuote.getImages()).resize(300,200).centerCrop().into(viewHolder.imageView);

        return convertView;
    }

    public class ViewHolder {
        private final ImageView imageView;

        public ViewHolder(ImageView imageView) {
            this.imageView = imageView;
        }
    }

}