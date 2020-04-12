package com.jambaar.taar.ui.fragments.chaussures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jambaar.taar.R

/**
 * A simple [Fragment] subclass.
 */
class ChaussureFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chaussure, container, false)
    }

}
