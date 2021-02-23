package com.meghdut.upsilent.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meghdut.upsilent.models.Cast;
import com.meghdut.upsilent.R;
import com.meghdut.upsilent.adapters.RecyclerViewAdapterTVShowCast;

import java.util.ArrayList;

/**
 * Created by KeshavAggarwal on 18/03/17.
 */

public class CastTVShowFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerViewAdapterTVShowCast recyclerViewAdapterTVShowCast;
    ArrayList<Cast> tvShowCastMain;
    TextView noCastTextView;
    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View v = inflater.inflate(R.layout.fragment_cast_tvshow, container, false);

        recyclerView = v.findViewById(R.id.tvShowCastRecyclerView);
        noCastTextView = v.findViewById(R.id.noCastTextView);
        tvShowCastMain = new ArrayList<>();

        return v;
    }


    public static CastTVShowFragment newInstance() {
        return new CastTVShowFragment();
    }

    public void setUIArguements(final Bundle args) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvShowCastMain = (ArrayList<Cast>) args.getSerializable("TV_SHOW_CAST");
                if (tvShowCastMain.size() == 0) {
                    noCastTextView.setVisibility(View.VISIBLE);
                    noCastTextView.setText("No cast is currently available for this show.");
                } else {

                    recyclerViewAdapterTVShowCast = new RecyclerViewAdapterTVShowCast(tvShowCastMain, context);
                    recyclerView.setAdapter(recyclerViewAdapterTVShowCast);

                    LinearLayoutManager verticalManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(verticalManager);
                }
            }
        });
    }

}


