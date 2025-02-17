package com.abadock.probafirebase.objectList

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abadock.probafirebase.R
import com.abadock.probafirebase.databinding.FragmentObjectsListBinding

class ObjectsListFragment : Fragment() {

    companion object {
        fun newInstance() = ObjectsListFragment()
    }

    private val viewModel: ObjectsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentObjectsListBinding.inflate(inflater)

        val adapter = viewModel.getAdapter()

        binding.recycler.adapter = adapter

        return binding.root
    }
}