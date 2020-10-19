package com.example.level3_task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_portal.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
const val REQ_PORTAL_KEY = "req_portal"
const val BUNDLE_PORTAL_KEY = "bundle_portal"
const val REQ_URL_KEY = "req_URL"
const val BUNDLE_URL_KEY = "bundle_URL"


class AddPortalFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddPortal.setOnClickListener {
            onAddPortal()
        }
    }

    private fun onAddPortal(){
        val portalTitle = etPortalTitle.text.toString()
        val portalWeb = etWeb.text.toString()

        var portal = Portal(portalTitle, portalWeb)

        if (portalTitle.isNotBlank() && portalWeb.isNotBlank()){
            setFragmentResult(REQ_PORTAL_KEY, bundleOf(Pair(BUNDLE_PORTAL_KEY, portal)))
            findNavController().popBackStack()
        }else{
            Toast.makeText(
                activity,
                R.string.empty_et, Toast.LENGTH_SHORT
            ).show()
        }
    }
}