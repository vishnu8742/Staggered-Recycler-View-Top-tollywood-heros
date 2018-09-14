package com.example.anon.tolly10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final int NUM_COLUMNS = 2;

    private ArrayList<String> ImageUrls = new ArrayList<>();
    private ArrayList<String> ImageNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBitMaps();
    }

    private void initBitMaps(){
        Log.d(TAG, "initBitMaps: BitMaps Adding");

        ImageUrls.add("https://akm-img-a-in.tosshub.com/indiatoday/images/story/201701/chiru-story_647_012017103838.jpg");
        ImageNames.add("Chiranjeevi");

        ImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Mahesh_Babu_in_Spyder_%28cropped%29.jpg/220px-Mahesh_Babu_in_Spyder_%28cropped%29.jpg");
        ImageNames.add("Mahesh Babu");

        ImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Pawan2.jpg/220px-Pawan2.jpg");
        ImageNames.add("Pawan Kalyan");

        ImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/Prabhas_at_MAMI_18th_Mumbai_film_festival.jpg/240px-Prabhas_at_MAMI_18th_Mumbai_film_festival.jpg");
        ImageNames.add("Prabhas");

        ImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Priyanka_Chopra_%26_Ram_Charan_at_Promotion_of_%27Zanjeer%27_on_Jhalak_Dikhhla_Jaa.jpg/220px-Priyanka_Chopra_%26_Ram_Charan_at_Promotion_of_%27Zanjeer%27_on_Jhalak_Dikhhla_Jaa.jpg");
        ImageNames.add("Ram Charan");

        ImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Allu_Arjun_at_62nd_Filmfare_awards_south.jpg/220px-Allu_Arjun_at_62nd_Filmfare_awards_south.jpg");
        ImageNames.add("Allu Arjun");

        ImageUrls.add("https://yt3.ggpht.com/a-/AN66SAzNa_9kq8_3c8I_2jXlZjhCaAGPjMytabo3Ww=s900-mo-c-c0xffffffff-rj-k-no");
        ImageNames.add("Jr NTR");

        ImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/TeachAIDS_2010_India_Launch_15.jpg/220px-TeachAIDS_2010_India_Launch_15.jpg");
        ImageNames.add("Nagarjuna");

        ImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Vijay_Deverakonda_at_NOTA_pressmeet.jpg/220px-Vijay_Deverakonda_at_NOTA_pressmeet.jpg");
        ImageNames.add("Vijay Devarakonda");

        ImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Balakrishna_sketch_picture.jpg/220px-Balakrishna_sketch_picture.jpg");
        ImageNames.add("Bala Krishna");

    intRecyclerView();
    }

    private void intRecyclerView(){
        Log.d(TAG, "intRecyclerView: Recycler View Initiated");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, ImageUrls, ImageNames);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
