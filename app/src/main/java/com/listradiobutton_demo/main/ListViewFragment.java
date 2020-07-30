package com.listradiobutton_demo.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.listradiobutton_demo.R;
import com.listradiobutton_demo.adapter.GridListAdapter;

import java.util.ArrayList;

/**
 * Created by sonu on 08/02/17.
 */
public class ListViewFragment extends Fragment {
    private Context context;
    private GridListAdapter adapter;
    private ArrayList<String> arrayList;

    public ListViewFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_view_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadListView(view);
        onClickEvent(view);
    }

    private void loadListView(View view) {
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        arrayList = new ArrayList<>();
        for (int i = 1; i <= 50; i++)
            arrayList.add("ListView Items " + i);

        adapter = new GridListAdapter(context, arrayList, true);
        listView.setAdapter(adapter);
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
