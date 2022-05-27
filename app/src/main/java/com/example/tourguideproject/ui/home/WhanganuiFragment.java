package com.example.tourguideproject.ui.home;

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
import com.example.tourguideproject.databinding.FragmentWhanganuiBinding;

import java.util.ArrayList;

public class WhanganuiFragment extends Fragment {

    private FragmentWhanganuiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WhanganuiViewModel whanganuiViewModel =
                new ViewModelProvider(this).get(WhanganuiViewModel.class);

        binding = FragmentWhanganuiBinding.inflate(inflater, container, false);

        final TextView textView = binding.textWhanganui;
        whanganuiViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        View root = inflater.inflate(R.layout.place_list, container, false);
        loadContent(root);

        return root;
    }

    public void loadContent(View rootView) {
        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Whanganui(Wanganui)", "Whanganui (/ˈhwɒŋənuːi/;[3] Māori: [ˀwaŋanui]), also spelled Wanganui,[4] is a city in the Manawatū-Whanganui region of New Zealand. The city is located on the west coast of the North Island at the mouth of the Whanganui River, New Zealand's longest navigable waterway. Whanganui is the 19th most-populous urban area in New Zealand and the second-most-populous in Manawatū-Whanganui, with a population of 42,300 as of June 2021.\n" +
                "\n" +
                "Whanganui is the ancestral home of Te Āti Haunui-a-Pāpārangi and other Whanganui Māori tribes. The New Zealand Company began to settle the area in 1840, establishing its second settlement after Wellington. In the early years most European settlers came via Wellington. Whanganui greatly expanded in the 1870s, and freezing works, woollen mills, phosphate works and wool stores were established in the town. Today, much of Whanganui's economy relates directly to the fertile and prosperous farming hinterland.\n" +
                "\n" +
                "Like several New Zealand urban areas, it was officially designated a city until an administrative reorganisation in 1989, and is now run by a District Council. Although the city was called Wanganui from 1854, in February 2009, the New Zealand Geographic Board recommended the spelling be changed to \"Whanganui\". In December 2009, the government decided that, while either spelling was acceptable, Crown agencies would use the Whanganui spelling.\n" +
                "\n" +
                "On 17 November 2015, Land Information New Zealand (LINZ) announced that Wanganui District would be renamed Whanganui District.[6] This changed the official name of the District Council, and, because Whanganui is not a city but a district, it changed the official name of the urban area as well.",
                "http://www.whanganui.govt.nz/",
                R.raw.whanganui,
                "From atop the Durie Hill War Memorial Tower, a view early morning of the Whanganui River, to the northwest, and Dublin Street Bridge. City Bridge is just to the left and out of shot, the CBD and Memorial gardens just over the river, Whanganui, NZ."));

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