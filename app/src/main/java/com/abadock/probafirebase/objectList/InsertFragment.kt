package com.abadock.probafirebase.objectList

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abadock.probafirebase.R
import com.abadock.probafirebase.databinding.FragmentInsertBinding

class InsertFragment : Fragment() {

    companion object {
        fun newInstance() = InsertFragment()
    }

    private val viewModel: InsertViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInsertBinding.inflate(inflater)

        binding.insertButton.setOnClickListener{
            val nom = binding.editTextNom.text.toString()
            var preu = binding.editTextPreu.text.toString()
            if (preu.isNotEmpty()) {
                if(nom.isNotEmpty()){
                    viewModel.newMoble(nom, preu.toDouble(), findNavController(), requireContext())
                }
            }

        }

        binding.returnButton.setOnClickListener{
            findNavController().navigate(R.id.action_insertFragment_to_objectsListFragment)
        }

        return binding.root
    }
}