package com.example.stepan.myartgallery.adapters;
import android.content.*;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.stepan.myartgallery.R;
import com.example.stepan.myartgallery.activities.SpacePhotoActivity;
import com.example.stepan.myartgallery.models.SpacePhoto;

import java.util.ArrayList;

public class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder>  {

    @Override
    public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View photoView = inflater.inflate(R.layout.image_view, parent, false);
        ImageGalleryAdapter.MyViewHolder viewHolder = new ImageGalleryAdapter.MyViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ImageGalleryAdapter.MyViewHolder holder, int position) {

        SpacePhoto spacePhoto = mSpacePhotos.get(position);
        ImageView imageView = holder.mPhotoImageView;
        Glide.with(mContext)
                .load(spacePhoto.getUrl())
//                .placeholder(R.drawable.ic_cloud_off_red)
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return (mSpacePhotos.size());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mPhotoImageView;

        public MyViewHolder(View itemView) {

            super(itemView);
            mPhotoImageView = (ImageView) itemView.findViewById(R.id.iv_photo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION) {
                SpacePhoto spacePhoto = mSpacePhotos.get(position);
                Intent intent = new Intent(mContext, SpacePhotoActivity.class);
                intent.putExtra(SpacePhotoActivity.EXTRA_SPACE_PHOTO, spacePhoto);
                mContext.startActivity(intent);
            }
        }
    }

    private ArrayList<SpacePhoto> mSpacePhotos;
    private Context mContext;

    public ImageGalleryAdapter(Context context, ArrayList<SpacePhoto> spacePhotos) {
        mContext = context;
        mSpacePhotos = spacePhotos;
    }
}
