package com.abadock.probafirebase.objectList

import android.content.Context
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.abadock.probafirebase.R
import com.abadock.probafirebase.databinding.FragmentObjectsListBinding

class ObjectsListFragment : Fragment() {

    companion object {
        fun newInstance() = ObjectsListFragment()
    }

    private val viewModel: ObjectsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMobles()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentObjectsListBinding.inflate(inflater)

        viewModel.getMobles()

        binding.recycler.layoutManager = LinearLayoutManager(context)

        viewModel.mobles.observe(viewLifecycleOwner) {

            val adapter = viewModel.getAdapter(findNavController())
            binding.recycler.adapter = adapter
        }

        binding.newButton.setOnClickListener() {
            findNavController().navigate(R.id.action_objectsListFragment_to_insertFragment)
        }

        return binding.root
    }
}