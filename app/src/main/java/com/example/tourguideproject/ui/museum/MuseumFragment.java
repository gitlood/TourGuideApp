package com.example.tourguideproject.ui.museum;

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
import com.example.tourguideproject.databinding.FragmentMuseumBinding;

import java.util.ArrayList;

public class MuseumFragment extends Fragment {

    private FragmentMuseumBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MuseumViewModel museumViewModel =
                new ViewModelProvider(this).get(MuseumViewModel.class);

        binding = FragmentMuseumBinding.inflate(inflater, container, false);

        final TextView textView = binding.textMuseum;
        museumViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        View root = inflater.inflate(R.layout.place_list, container, false);
        loadContent(root);

        return root;
    }

    public void loadContent(View rootView) {
        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Whanganui Regional Museum",
                "Set in Pukenamu Queen’s Park, in the cultural heart of Whanganui, the Whanganui Regional Museum offers visitors a look into the hearts and minds of the people of Whanganui and their treasures.\n" +
                        " \n" +
                        "The Museum is famed for its Taonga M?ori Collection. You will see the exceptional creations of t?puna (ancestors) of Whanganui tangata whenua (indigenous people).\n" +
                        "The natural world of Whanganui and the development of a mature and sometimes controversial town are interpreted in a changing exhibition programme with a world-class collection.\n Entry is free.",
                "Queens Park\nWatt Street\nWhanganui 4500",
                R.raw.whanganuiregionalmuseum, " The Whanganui Regional Museum."));
        places.add(new Place("Quartz Museum of Studio Ceramics",
                "Quartz, Museum of Studio Ceramics is the only dedicated museum for studio ceramics in NZ and is the largest and most diverse public ceramic display.",
                "8 Bates Street\nWhanganui 4500",
                R.raw.quartzmuseum,
                "Quartz Museum of Studio Ceramics(Rick Rudd Building)"));
        places.add(new Place("Riverboat Museum",
                "The Riverboat Centre and Riverboat Museum is located within a turn of the century building that originally operated as a rowing facility.\n" +
                        "\n" +
                        "It is among one of the first architecturally designed rowing centres in New Zealand. You can still see the original W.R.C wooden letters, short for Wanganui Rowing Club, above the front door at the entrance to the building.\n" +
                        "\n" +
                        "The building was restored by community volunteers and turned into a wonderful workshop for the restoration of the Paddle Steamer Waimarie in the late 90’s and later became the Riverboat Centre and Riverboat Museum. ",
                "1A Taupo Quay\nWhanganui 4500",
                R.raw.riverboatcentre,
                "The RiverBoat Centre"));
        places.add(new Place("Whanganui Tramways Museum",
                "New Zealand's first horse tramway was established in 1862 in Nelson, followed by a steam tramway in 1871 in Thames. The first electric tramway came into service in 1900 (Māori Hill, Dunedin). The tram systems in the main centres, and in some smaller towns, were soon electrified. In December 1908  Wanganui became the first provincial town to have a tramway, with the first of 12 trams coming into service in 1909. By 1912 all twelve were in service. By the 1950s all systems were in the process of being replaced by trolleybuses or buses. Last day of trams in Wanganui for the 20th Century was 24th September 1950. Trams 8, 10 and 12 have survived. No.12 has been beautifully restored to her former glory and is now on display at the Wanganui Tramways Trust Shed at Moutoa Quay on the  Whanganui River.  No.12 was donated to the City of Wanganui after the body was privately restored in Auckland. The trust also plans to renovate Wanganui Tram No.8 and New Plymouth Birney No.8 which were both donated to them unrestored by the Wellington Tramway Museum.",
                "27 Moutoa Quay\nWhanganui 4500",
                R.raw.tram,
                "Tram Centre"));

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