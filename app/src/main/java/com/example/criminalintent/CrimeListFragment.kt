package com.example.criminalintent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "CrimeListFragment"
class CrimeListFragment : Fragment() {
    private lateinit var crimeRecyclerView: RecyclerView
    private val crimeListViewModel: CrimeListViewModel by lazy {
         ViewModelProvider(this).get(CrimeListViewModel::class.java)
    }
    override fun onCreate(savedInstanceState:
                          Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total crimes:${crimeListViewModel.crimes.size}")
    }
    companion object {
        fun newInstance(): CrimeListFragment {
            return CrimeListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(R.layout.fragment_crime_list,
                container, false)
        crimeRecyclerView =
            view.findViewById(R.id.crime_recycler_view) as RecyclerView
        crimeRecyclerView.layoutManager =
            LinearLayoutManager(context)
        return view
    }
    private inner class CrimeHolder(view: View)
        : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView =
            itemView.findViewById(R.id.crime_title)
        val dateTextView: TextView =
            itemView.findViewById(R.id.crime_date)

    }

}
