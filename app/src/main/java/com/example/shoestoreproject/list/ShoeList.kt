package com.example.shoestoreproject.list

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shoestoreproject.MainViewModel
//import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.shoestoreproject.R
import com.example.shoestoreproject.databinding.FragmentShoeListBinding


class ShoeList : Fragment() {
    private lateinit var viewModel : MainViewModel
    private lateinit var binding : FragmentShoeListBinding
    private lateinit var factory : ShoeFactory
    //Q: Need to select views from LinearLayout so I can reference them using the Floating Action Button
    //https://stackoverflow.com/questions/7552333/android-linearlayout-background-selector

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        binding.FABButton.setOnClickListener {view: View? ->  view?.findNavController()?.navigate(R.id.action_shoeList_to_shoeDetail) }

        val scoreFragmentArgs by navArgs<ShoeListArg>()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //Q: LiveData is reverting to its default value..
        //https://blog.mindorks.com/shared-viewmodel-in-android-shared-between-fragments potential solution but requires fragments to be added the
        //xml file, which may disrupt the NavHostFragment
        viewModel.saved.observe(viewLifecycleOwner, Observer { saved ->
            if (saved)
            {
                addCustomView()
            }
        })
        //binding.secondRowText.text = "Hello"


        return binding.root//inflater.inflate(R.layout.fragment_shoe_list, container, false)

    }

    fun addCustomView()
    {

        //https://stackoverflow.com/questions/6216547/android-dynamically-add-views-into-view
        val vi : LayoutInflater = this.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = vi.inflate(R.layout.customview, null)
        //adding a view to the LinearLayout
        //https://stackoverflow.com/questions/2395769/how-to-programmatically-add-views-to-views
        val myLayout: ScrollView = binding.shoeList
        //val addedItem  = view
        v.setLayoutParams(
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        )
        myLayout.addView(v)
    }

    override fun onAttach(context: Context) {
        if ()//resulting boolean is true, add viewGroup
        super.onAttach(context)
    }
}