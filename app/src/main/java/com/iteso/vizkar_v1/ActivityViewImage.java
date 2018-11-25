package com.iteso.vizkar_v1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Switch;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.github.chrisbanes.photoview.PhotoView;
import com.iteso.vizkar_v1.tools.Constant;

public class ActivityViewImage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);
        Fresco.initialize(this);

        PhotoView photoView = findViewById(R.id.photo_view);

        //Para fresco
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.photo_view_fresco);
        Uri uri ;


        Intent intent = getIntent();
        int intentInt = intent.getIntExtra("imagen",100);


        switch(intentInt)
        {
            case Constant.TYPE_COORDENADA_BIG_PIC:
                //Uri.parse("https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
                photoView.setImageResource(R.drawable.tecate_coordenada_cartel);break;
            case Constant.TYPE_PALNORTE_BIG_PIC:
                photoView.setImageResource(R.drawable.pal_norte1); break;
            case Constant.TYPE_UNKNOWS_BIG_PIC:
                photoView.setImageResource(R.drawable.sad_emoji); break;
                default:
                    photoView.setImageResource(R.drawable.sad_emoji); break;
        }


    }

}
