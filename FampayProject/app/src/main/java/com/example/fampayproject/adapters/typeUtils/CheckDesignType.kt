package com.example.fampayproject.adapters.typeUtils

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fampayproject.adapters.CardGroupsAdapter
import com.example.fampayproject.models.CardGroup

//class to check design types
class CheckDesignType() {

    // function to check each kind of design type and get their layout managers from respective holders
    fun check(recyclerViewChild: CardGroup, designType: String, holder: CardGroupsAdapter.ViewHolder ): LinearLayoutManager {
        val cardgroupLayoutManager = when(designType){
            "HC1" ->{
                if(!recyclerViewChild.is_scrollable){
                    LinearLayoutManager(holder.recyclerView.context, LinearLayoutManager.VERTICAL, false)
                }else{
                    LinearLayoutManager(holder.recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
                }
            }
            "HC3" ->{
                if(!recyclerViewChild.is_scrollable){
                    LinearLayoutManager(holder.recyclerView.context, LinearLayoutManager.VERTICAL, false)
                }else{
                    LinearLayoutManager(holder.recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
                }
            }
            "HC5" ->{
                if(!recyclerViewChild.is_scrollable){
                    LinearLayoutManager(holder.recyclerView.context, LinearLayoutManager.VERTICAL, false)
                }else{
                    LinearLayoutManager(holder.recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
                }
            }
            "HC6" ->{
                if(!recyclerViewChild.is_scrollable){
                    LinearLayoutManager(holder.recyclerView.context, LinearLayoutManager.VERTICAL, false)
                }else{
                    LinearLayoutManager(holder.recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
                }
            }else -> {
                if(!recyclerViewChild.is_scrollable){
                    LinearLayoutManager(holder.recyclerView.context, LinearLayoutManager.VERTICAL, false)
                }else{
                    LinearLayoutManager(holder.recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
                }
            }
        }
        return cardgroupLayoutManager
    }
}