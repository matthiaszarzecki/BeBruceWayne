package com.elaydis.bebrucewayne.christmas_tree_lighting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elaydis.bebrucewayne.endings.BadEndingFragment;
import com.elaydis.bebrucewayne.MainActivity;
import com.elaydis.bebrucewayne.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChristmasTreeFirstSceneFragment extends Fragment {

    public ChristmasTreeFirstSceneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_christmas_tree_first_scene, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);

        super.onDestroyView();
    }


    @OnClick(R.id.button_option_1)
    public void optionOneClicked() {
        ((MainActivity) getActivity()).raiseSuspicionLevel(0);
        checkSuspicionLevel();
    }

    @OnClick(R.id.button_option_2)
    public void optionTwoClicked() {
        ((MainActivity) getActivity()).raiseSuspicionLevel(200);
        checkSuspicionLevel();
    }

    @OnClick(R.id.button_option_3)
    public void optionThreeClicked() {
        ((MainActivity) getActivity()).raiseSuspicionLevel(250);
        checkSuspicionLevel();
    }

    @OnClick(R.id.button_option_4)
    public void optionFourClicked() {
        ((MainActivity) getActivity()).raiseSuspicionLevel(333);
        checkSuspicionLevel();
    }


    private void checkSuspicionLevel() {
        int suspicionLevel = ((MainActivity) getActivity()).getSuspicionLevel();

        if (suspicionLevel < 999) {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new ChristmasTreeSecondSceneFragment())
                    .addToBackStack(ChristmasTreeFirstSceneFragment.class.getSimpleName())
                    .commit();
        } else {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new BadEndingFragment())
                    .addToBackStack(ChristmasTreeFirstSceneFragment.class.getSimpleName())
                    .commit();
        }
    }

}

