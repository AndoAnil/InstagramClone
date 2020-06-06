package com.example.instagramclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
     SearchView searchView;
     ListView searchList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.search_fragment,container,false);
        searchView=(SearchView) view.findViewById(R.id.searchView);
        searchList=(ListView) view.findViewById(R.id.searchList);
        List<String> listSearch=new ArrayList<>();
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,listSearch);
        return  view;
    }
}
