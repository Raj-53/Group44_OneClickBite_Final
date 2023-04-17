package com.example.oneclickbite;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment {
    Intent iZomato, iSwiggy, choose;
    String detected_food_label;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button btnCook, btnOrder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderFragment() {
        // Required empty public constructor
    }

    // Setter method to set the detected_food_label value
    public void setDetectedFoodLabel(String detected_food_label) {
        this.detected_food_label = detected_food_label;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        btnCook = view.findViewById(R.id.btnCook);
        btnOrder = view.findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager pm = requireActivity().getPackageManager();
//                check if zomato is installed
                iZomato = pm.getLaunchIntentForPackage("com.application.zomato");
                if (iZomato == null) {
                    // zomato app is not installed, open the play store for download
                    iZomato = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.application.zomato"));
                }else{
                    // zomato is already installed
                    iZomato.setPackage("com.application.zomato");
                }

                // check if Swiggy is installed
                iSwiggy = pm.getLaunchIntentForPackage("in.swiggy.android");
                if (iSwiggy == null) {
                    iSwiggy = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=in.swiggy.android"));
                }else{
                    iSwiggy.setPackage("in.swiggy.android");
                }

                    choose = Intent.createChooser(iZomato, "Choose an app to order food: ");
                    choose.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{iZomato, iSwiggy});
                    choose.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(choose);
            }
        });

        btnCook.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VarietyActivity.class);
                intent.putExtra("food",detected_food_label);
//                Toast.makeText(getActivity(), detected_food_label, Toast.LENGTH_SHORT).show();
                startActivity(intent);


            }
        });

        return view;

    }
}