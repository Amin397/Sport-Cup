package com.example.sportcup.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.sportcup.R;
import com.example.sportcup.adapters.Recycler_Items_Adapter;
import com.example.sportcup.models.Recycler_Items_Models;

import java.util.ArrayList;

public class AllItems extends Fragment {

    RecyclerView recy_allItems ;
    ArrayList<Recycler_Items_Models> items = new ArrayList<>();
    Recycler_Items_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_items , container , false);

        recy_allItems = (RecyclerView)view.findViewById(R.id.recycler_allitems_id);

        showItems();
        adapter = new Recycler_Items_Adapter(getActivity() , items);
        recy_allItems.setLayoutManager(new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL , false));
        recy_allItems.setAdapter(adapter);

        return view;
    }

    private void showItems() {
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
        items.add(new Recycler_Items_Models("besat" , "45.000" , "velenjak" , "4.2" ,R.drawable.image_recycler));
    }
}
