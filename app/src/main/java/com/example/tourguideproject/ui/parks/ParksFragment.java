package com.example.tourguideproject.ui.parks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tourguideproject.Place;
import com.example.tourguideproject.PlaceAdapter;
import com.example.tourguideproject.R;
import com.example.tourguideproject.databinding.FragmentParksBinding;

import java.util.ArrayList;

public class ParksFragment extends Fragment {

    private FragmentParksBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ParksViewModel parksViewModel =
                new ViewModelProvider(this).get(ParksViewModel.class);

        binding = FragmentParksBinding.inflate(inflater, container, false);

        final TextView textView = binding.textParks;
        parksViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        View root = inflater.inflate(R.layout.place_list, container, false);
        loadContent(root);

        return root;
    }

    public void loadContent(View rootView) {
        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Rotokawau/Virginia Lake Reserve",
                "Rotokawau Virginia Lake provides an historic lakeside setting where you can picnic or take a 25-minute woodland walk around the lake to see the statue of Tainui, a band rotunda, twin bridges, rose and wisteria pergolas and various wildfowl species such as white swans.",
                "110 Great North Road\nSt Johns Hill\nWhanganui 4500",
                R.raw.virginialake,
                "Virginia Lake"));
        places.add(new Place("Kowhai Park Family Playground",
                "This fantastic park and playground keeps families entertained for hours. With classic favourites and modern updates to the playground's equipment, Kowhai Park is a memory-maker and multi-generational pleaser.\n" +
                        "\n" +
                        "This huge riverside park has entertained and delighted children over the decades and is one of the top family attractions in Whanganui. A must for families with young children and a favourite for all. Parents who played there while young bring their children back to experience the same fun they had at Kowhai Park.",
                "Whanganui East\nWhanganui 4500",
                R.raw.kowhaipark,
                "Kowhai Park"));
        places.add(new Place("Springvale Park",
                "Springvale Park is an 11-hectare complex, with multi-use amenities for cricket, rugby, Rippa Rugby, rugby league and touch rugby.\n" +
                        "\n" +
                        "It includes the Splash Centre, which has lane swimming, a lazy river, spa pools, learners’ and toddlers’ pools, a sauna, two giant hydroslides and an indoor rowing and fitness centre.\n" +
                        "\n" +
                        "Adjacent to the Splash Centre is the Springvale Bike Park, which has a learners’ track for young riders with miniature roads and signage. The bike park also has pump tracks for teen riders wanting more of a challenge.",
                "220 London Street\nSpringvale\nWhanganui 4501",
                R.raw.springvalepark,
                "Springvale Park Bike Track"));
        places.add(new Place("Peat Park",
                "Peat Park is an established park with wide open spaces and large trees at the base of Christie’s Hill on Peat Street, Aramoho.\n" +
                        "\n" +
                        "In 1911 the park was gifted to the children of Whanganui by David Peat, who believed that schools did not provide adequately for children to play. It has picnic tables and two play areas, with a climbing frame for older children. This park offers the unique opportunity to get up close with deer.",
                "17 Peat Street\nAramoho\nWhanganui 4500",
                R.raw.peatpark,
                "Peat Park Playground"));
        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}