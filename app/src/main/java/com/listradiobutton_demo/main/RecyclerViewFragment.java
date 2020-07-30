package com.listradiobutton_demo.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.listradiobutton_demo.R;
import com.listradiobutton_demo.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by sonu on 08/02/17.
 */
public class RecyclerViewFragment extends Fragment {

    private Context context;
    private RecyclerViewAdapter adapter;
    private ArrayList<String> arrayList;

    public RecyclerViewFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_view_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateRecyclerView(view);
        onClickEvent(view);
    }

    private void populateRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();
        for (int i = 1; i <= 50; i++)
            arrayList.add("RecyclerView Items " + i);//Adding items to recycler view

        adapter = new RecyclerViewAdapter(context, arrayList);
        recyclerView.setAdapter(adapter);
    }

    private void onClickEvent(View view) {
        view.findViewById(R.id.show_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get the selected position
                adapter.getSelectedItem();
            }
        });
        view.findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Delete the selected position
                adapter.deleteSelectedPosition();
            }
        });

    }
}
