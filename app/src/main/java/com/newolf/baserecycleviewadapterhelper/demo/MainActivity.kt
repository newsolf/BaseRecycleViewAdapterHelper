package com.newolf.baserecycleviewadapterhelper.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newolf.baserecycleviewadapterhelper.demo.viewmodel.FunctionViewModel
import com.newolf.baserecycleviewadapterhelper.ui.FunctionAdapter
import com.newolf.baserecycleviewadapterhelper.ui.MultiDataAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var model: FunctionViewModel
    lateinit var mFunctionAdapter: FunctionAdapter
    lateinit var mMultiDataAdapter: MultiDataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(this.application)
        ).get(FunctionViewModel::class.java)

        initView()

//        loadData()

        onObserve()

        initListener()
    }


    private fun initView() {
        val gridLayoutManager = GridLayoutManager(this, 2)
        gridLayoutManager.orientation = RecyclerView.HORIZONTAL
        rvList.layoutManager = gridLayoutManager

        mFunctionAdapter = FunctionAdapter()

        val emptyView = View.inflate(this, R.layout.adapter_empty_view, null)

        emptyView.setOnClickListener { loadData() }

        mFunctionAdapter.setEmptyView(emptyView)

        rvList.adapter = mFunctionAdapter

        val manager = LinearLayoutManager(this)
        manager.orientation = RecyclerView.VERTICAL
        rvMultiList.layoutManager = manager

    }


    private fun loadData() {
        model.loadFunctionData()
    }

    private fun onObserve() {
        model.typeList.observe(this@MainActivity, Observer {
            mFunctionAdapter.setNewInstance(it.toMutableList())
        })

        model.multiData.observe(this@MainActivity, Observer {
            Log.e("wolf", "onObserve: " + it.size )
            mMultiDataAdapter = MultiDataAdapter(it)
            rvMultiList.adapter = mMultiDataAdapter
        })

    }


    private fun initListener() {
        mFunctionAdapter.setOnItemClickListener { _, _, position ->
            Log.e("wolf", "initListener: position = $position")
            if (position == 1) model.loadMultiData() else rvMultiList.adapter = MultiDataAdapter(
                listOf())
        }
    }
}