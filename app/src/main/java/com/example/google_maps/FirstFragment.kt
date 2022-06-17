package com.example.Google_maps


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.Google_maps.apis.university
import com.example.google_maps.R
import com.example.google_maps.databinding.FragmentFirstBinding
import com.example.university_locations.adapters.RecyclerViewAdapter

import com.google.android.gms.maps.model.LatLng

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }



    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

// getting the recyclerview by its id
        val recyclerview = binding.recyclerview

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this.context)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<university>()

        // Hard Coded university objects into data list
        data.add(university("University of Kelaniya", LatLng(6.9739,79.9157)))
        data.add(university("University of Colombo", LatLng(6.9000,79.8588)))
        data.add(university("University of Peradeniya", LatLng(7.2549,80.5974)))
        data.add(university("Sri Lanka Law College", LatLng(6.9356,79.8598)))
        data.add(university("University of Jaffna", LatLng(9.6849,80.0220)))
        data.add(university("Rajarata University of Sri Lanka", LatLng(8.3608,80.5033)))
        data.add(university("Wayamba University of Sri Lanka", LatLng(7.3226,79.9882)))
        data.add(university("Sabaragamuwa University of Sri Lanka", LatLng(6.7146,80.7872)))
        data.add(university("University of Sri Jayewardenepura", LatLng(6.8528,79.9036)))
        data.add(university("South Eastern University of Sri Lanka", LatLng(7.2970,81.8500)))
        data.add(university("Uva Wellassa University of Sri Lanka", LatLng(6.9819,81.0763)))
        data.add(university("University of Moratuwa", LatLng(6.7951,79.9009)))

        // This will pass the ArrayList to our Adapter
        val adapter = RecyclerViewAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter


        adapter.clickEvent.subscribe{

            setFragmentResult("requestKey", bundleOf("selectedNameKey" to it, "data" to data))
            findNavController().navigate(R.id.action_FirstFragment_to_MapsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}