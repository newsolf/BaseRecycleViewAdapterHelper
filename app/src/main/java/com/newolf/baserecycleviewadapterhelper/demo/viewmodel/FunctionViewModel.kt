package com.newolf.baserecycleviewadapterhelper.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.newolf.baserecycleviewadapterhelper.demo.entry.FunctionEntry

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2020/9/1
 * 描述:
 * 历史:<br/>
 * ================================================
 */
class FunctionViewModel :ViewModel(){
    val typeList = MutableLiveData<List<String>>()

    val multiData = MutableLiveData<List<FunctionEntry>>()




    fun loadFunctionData() {

        val data1 = "BaseQuickAdapter"
        val data2 = "BaseMultiItem\nQuickAdapter"

        typeList.value = listOf(data1,data2)
    }

    fun loadMultiData(){
        val dataList = ArrayList<FunctionEntry>()


        for (index in 1..20){
            if (index % 2 == 0){
                dataList.add(FunctionEntry(0,"第$index 个 Item" ))
            }else{
                dataList.add(FunctionEntry(index,"第$index 个 Item" ))
            }
        }

        multiData.value = dataList


    }

}