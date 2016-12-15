package com.example.michis.sliderreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    SliderLayout sliderLayout;
    HashMap<String,String> Hash_file_maps ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Hash_file_maps = new HashMap<>();

        sliderLayout = (SliderLayout)findViewById(R.id.slider);

            //I would like to parse these array list into the slider in the same order sequence

            Hash_file_maps.put("Face One", "https://s30.postimg.org/lcmlpquw1/img1.jpg");

            Hash_file_maps.put("Face Two", "https://s30.postimg.org/mg6q1pfj5/img2.jpg");

            Hash_file_maps.put("Face Three", "https://s30.postimg.org/3p4srjkyp/img3.jpg");

            Hash_file_maps.put("Face Four", "https://s30.postimg.org/iz4nyqggx/img4.jpg");

            Hash_file_maps.put("Face Five", "https://s30.postimg.org/n9jbublk1/img5.jpg");

            Hash_file_maps.put("Face Six", "https://s30.postimg.org/g7le84hy9/img6.jpg");

            Hash_file_maps.put("Face Seven", "https://s30.postimg.org/u2joqlcdd/img7.jpg");

            Hash_file_maps.put("Face Eight", "https://s30.postimg.org/llk6fo7oh/img8.jpg");

            Hash_file_maps.put("Face Nine", "https://s30.postimg.org/wzbb4m7kx/img9.jpg");

        for(String name : Hash_file_maps.keySet()){


            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.FitCenterCrop)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }


        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Stack);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.stopAutoCycle();
        sliderLayout.addOnPageChangeListener(this);


    }
    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}


    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}



}
