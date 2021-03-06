package com.yupog2003.tripdiary.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;

import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.yupog2003.tripdiary.data.documentfile.DocumentFile;

import java.io.IOException;

public class MyImageDecoder implements ImageDecoder {
    private final BaseImageDecoder m_imageUriDecoder;
    Bitmap playBitmap;
    Context context;

    public MyImageDecoder(Context context, BaseImageDecoder imageUriDecoder) {
        if (imageUriDecoder == null) {
            throw new NullPointerException("Image decoder can't be null");
        }
        this.context = context;
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inSampleSize = 2;
        playBitmap = BitmapFactory.decodeResource(context.getResources(), android.R.drawable.ic_media_play, o);
        m_imageUriDecoder = imageUriDecoder;
    }

    @Override
    public Bitmap decode(ImageDecodingInfo info) throws IOException {
        if (TextUtils.isEmpty(info.getImageKey())) {
            return null;
        }
        String cleanedUriString = info.getImageUri();
        if (FileHelper.isVideo(cleanedUriString)) {
            return makeVideoThumbnail((DocumentFile[]) info.getExtraForDownloader(), info.getTargetSize(), cleanedUriString);
        } else {
            return centerCrop(m_imageUriDecoder.decode(info), info.getTargetSize());
        }
    }

    private Bitmap makeVideoThumbnail(DocumentFile[] files, ImageSize targetSize, String filePath) {
        if (filePath == null || files == null) {
            return null;
        }
        try {
            int targetWidth = targetSize.getWidth();
            int targetHeight = targetSize.getHeight();
            DocumentFile videoFile = FileHelper.findfile(files, filePath.substring(filePath.lastIndexOf("/") + 1));
            if (videoFile == null) return null;
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(context, videoFile.getUri());
            Bitmap thumbnail = mmr.getFrameAtTime();
            if (thumbnail == null) return null;
            float scale = Math.max(
                    ((float) targetWidth) / ((float) thumbnail.getWidth()),
                    ((float) targetHeight) / ((float) thumbnail.getHeight())
            );
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(thumbnail,
                    (int) (((float) thumbnail.getWidth()) * scale),
                    (int) (((float) thumbnail.getHeight()) * scale),
                    false
            );
            thumbnail.recycle();
            Bitmap croppedBitmap = centerCrop(scaledBitmap, targetSize);
            if (croppedBitmap == null) return null;
            int resultWidth = croppedBitmap.getWidth();
            int resultHeight = croppedBitmap.getHeight();
            int playBitmapWidth = playBitmap.getWidth();
            int playBitmapHeight = playBitmap.getHeight();
            if (resultWidth >= playBitmapWidth && resultHeight >= playBitmapHeight) {
                Canvas canvas = new Canvas(croppedBitmap);
                canvas.drawBitmap(playBitmap, (resultWidth - playBitmapWidth) / 2, (resultHeight - playBitmapHeight) / 2, null);
            }
            return croppedBitmap;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Bitmap centerCrop(Bitmap bitmap, ImageSize targetSize) {
        try {
            int targetWidth = targetSize.getWidth();
            int targetHeight = targetSize.getHeight();
            int decodedWidth = bitmap.getWidth();
            int decodedHeight = bitmap.getHeight();
            Bitmap result;
            if (decodedWidth > decodedHeight) {
                result = Bitmap.createBitmap(bitmap, (decodedWidth - targetWidth) / 2, 0, targetWidth, decodedHeight);
            } else {
                result = Bitmap.createBitmap(bitmap, 0, (decodedHeight - targetHeight) / 2, decodedWidth, targetHeight);
            }
            bitmap.recycle();
            return result;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }
}