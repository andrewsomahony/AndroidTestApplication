package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrew.testapplication.R;

/**
 * Created by andrew on 5/21/17.
 */

public abstract class BaseFragment extends Fragment {
    protected int _layoutResourceID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(_layoutResourceID,
                container,
                false);
    }
}
