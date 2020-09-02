package com.newolf.baserecycleviewadapterhelper.demo.entry

import com.newolf.library.adapt.base.entity.MultiItemEntity

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
data class FunctionEntry (val type:Int, val name:String ):MultiItemEntity {

   companion object{
       const val TYPE_TEXT = 0
       const val TYPE_IMAGE = 1
   }



    override val itemType: Int
        get()  = if (type == 0) TYPE_IMAGE else TYPE_TEXT
}
