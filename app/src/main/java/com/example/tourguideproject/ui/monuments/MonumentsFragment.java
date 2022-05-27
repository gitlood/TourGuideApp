package com.example.tourguideproject.ui.monuments;

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
import com.example.tourguideproject.databinding.FragmentMonumentsBinding;

import java.util.ArrayList;

public class MonumentsFragment extends Fragment {

    private FragmentMonumentsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MonumentsViewModel monumentsViewModel =
                new ViewModelProvider(this).get(MonumentsViewModel.class);

        binding = FragmentMonumentsBinding.inflate(inflater, container, false);

        final TextView textView = binding.textMonuments;
        monumentsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        View root = inflater.inflate(R.layout.place_list, container, false);
        loadContent(root);

        return root;
    }

    public void loadContent(View rootView) {
        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Durie Hill Tower",
                "The Durie Hill Memorial Tower was opened in 1925 to commemorate (as the plaque reads) the 513 young people from Wanganui and district who died in WWI. The tower is built of local shellrock.",
                "2 Tower Crescent\nDurie Hill\nWhanganui 4500",
                R.raw.duriehill, " The Durie Hill Tower."));
        places.add(new Place("Watt Fountain",
                "The Watt Fountain is a memorial to Whanganui first Mayor, William Hogg Watt. Mayor Watt famously instigated the change in name from Petre to Wanganui, and donated Westmere Lake to the city. The fountain symbolises the gratitude of the city for the lake as a water supply.",
                "Victoria Ave, Wanganui 4500",
                R.raw.memorialfountain,
                "The Watt Fountain."));
        places.add(new Place("Whanganui War Memorial Centre",
                "The Whanganui War Memorial Centre is an architecturally significant building that is listed as one of the top modernist buildings in the world. This beautiful and practical building offers great versatility for hosting events.\n" +
                        "\n" +
                        "About the Whanganui War Memorial Centre\n" +
                        "Built in 1960, the Whanganui War Memorial Centre is a living memorial to the 375 servicemen and women from Whanganui who lost their lives during World War II. It features a Book of Remembrance, an antique artillery gun and a stained glass window based on Laurence Byron’s ‘Poem for the Fallen’.\n" +
                        "\n" +
                        "In 1961 the building was awarded a gold medal from the New Zealand Institute of Architects. The Whanganui War Memorial Centre is listed as one of the top 1,000 modernist buildings in the world and the top 50 in the southern hemisphere.",
                "Watt Street\nWhanganui 4500",
                R.raw.warmemorialhall,
                "The War Memorial Hall."));
        places.add(new Place("Moutoa Gardens",
                "For 79 days between February and May 1995, Whanganui Māori and supporters occupied Pākaitore, otherwise known as Moutoa Gardens, beside the river in Whanganui city, as a sign of frustration over the lack of progress towards a settlement of Whanganui River Treaty of Waitangi claim issues. This occupation was resolved peaceably, and a tripartite agreement with government and local government has since been signed.",
                "Victoria Ave, Wanganui 4500",
                R.raw.moutoagardens,
                "The Moutoa Gardens Statue."));
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