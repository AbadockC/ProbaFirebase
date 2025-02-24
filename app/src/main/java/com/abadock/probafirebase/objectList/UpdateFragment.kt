package com.abadock.probafirebase.objectList

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abadock.probafirebase.R
import com.abadock.probafirebase.Recycler.MobleModel
import com.abadock.probafirebase.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {

    companion object {
        fun newInstance() = UpdateFragment()
    }

    private val viewModel: UpdateViewModel by viewModels()
    private val selectedMoble: MobleModel = UpdateViewModel.selectedMoble

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentUpdateBinding.inflate(inflater)

        binding.editTextNom.setText(selectedMoble.nom)
        binding.editTextPreu.setText(selectedMoble.preu.toString())

        binding.deleteButton.setOnClickListener(){
            viewModel.deleteProduct(findNavController(), requireContext())
        }

        binding.updateButton.setOnClickListener() {
            val nom = binding.editTextNom.text.toString()
            val preu = binding.editTextPreu.text.toString().toDouble()
            viewModel.updateProduct(nom, preu, findNavController(), requireContext())
        }

        return binding.root
    }
}