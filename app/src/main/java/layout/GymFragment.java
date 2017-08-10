package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.matthewlopes.pocketcoach.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GymFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GymFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GymFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GymFragment() {
        // Required empty public constructor
    }

    //When view is created, it creates a listener for each button
    //**Remember to implement view.OnClickListener in the fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gym, container, false);

        //Sets an onCLick Listener for contactButton
        Button contactButton = (Button)  view.findViewById(R.id.ContactButton);
        contactButton.setOnClickListener(this);

        //Sets an onCLick Listener for hoursButton
        Button hoursButton = (Button)  view.findViewById(R.id.HoursButton);
        hoursButton.setOnClickListener(this);

        //Sets an onCLick Listener for trainerButton
        Button trainerButton = (Button)  view.findViewById(R.id.TrainerButton);
        trainerButton.setOnClickListener(this);

        //Sets an onCLick Listener for mapButton
        Button mapButton = (Button)  view.findViewById(R.id.MapButton);
        mapButton.setOnClickListener(this);

        //Sets an onCLick Listener for storeButton
        Button storeButton = (Button)  view.findViewById(R.id.StoreButton);
        storeButton.setOnClickListener(this);

        //Sets an onCLick Listener for gymKeyButton
        Button gymKeyButton = (Button)  view.findViewById(R.id.GymKeyButton);
        gymKeyButton.setOnClickListener(this);

        //Sets an onCLick Listener for classesButton
        Button classesButton = (Button)  view.findViewById(R.id.ClassesButton);
        classesButton.setOnClickListener(this);

        return view;
    }

    //Responds to a click on a button
    @Override
    public void onClick(View view) {
        Fragment fragment;
        int id = view.getId();
        switch(id){
            case R.id.ContactButton:
                fragment = new ContactFragment();
                switchFragment(fragment);
                break;
            case R.id.HoursButton:
                fragment = new HoursFragment();
                switchFragment(fragment);
                break;
            case R.id.TrainerButton:
                fragment = new TrainerFragment();
                switchFragment(fragment);
                break;
            case R.id.MapButton:
                fragment = new MapFragment();
                switchFragment(fragment);
                break;
            case R.id.StoreButton:
                fragment = new StoreFragment();
                switchFragment(fragment);
                break;
            case R.id.GymKeyButton:
                fragment = new GymKeyFragment();
                switchFragment(fragment);
                break;
            case R.id.ClassesButton:
                fragment = new ClassesFragment();
                switchFragment(fragment);
                break;
        }
    }

    //Used to switch Fragments
    //**Remember to remove the onAttatch method in the fragments
    public void switchFragment(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contentLayout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GymFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GymFragment newInstance(String param1, String param2) {
        GymFragment fragment = new GymFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
