package com.example.fampayproject.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fampayproject.R
import com.example.fampayproject.adapters.typeUtils.CheckDesignType
import com.example.fampayproject.models.Card
import com.example.fampayproject.models.CardGroup


class CardGroupsAdapter(private val activity: Activity,private val cardGroups: ArrayList<CardGroup>): RecyclerView.Adapter<CardGroupsAdapter.ViewHolder>(){

    //we will create multiple recycler views so we use a viewPool
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardGroupsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_as_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CardGroupsAdapter.ViewHolder, position: Int) {

        // get each card groups as cardGroup
        val recyclerViewChild = cardGroups[position]
        val designType = recyclerViewChild.design_type

        //check for design type
        val checkDesignType = CheckDesignType()
        val cardGroupLayoutManager = checkDesignType.check(recyclerViewChild,designType,holder)

        //set respective cardGroup adapters
        setCardGroupAdapter(holder, cardGroupLayoutManager, designType, recyclerViewChild)
    }

    override fun getItemCount(): Int {

        //return the number of cardGroups present
        return cardGroups.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        //initialise the parent recycler view
        val recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view_as_item)
    }


    //we will create children of each cardGroup and set it to the adapter
    private fun setCardGroupAdapter(holder: ViewHolder, cardGroupLayoutManager: LinearLayoutManager, designType: String, recyclerViewChild: CardGroup){
        holder.recyclerView.apply {
            layoutManager = cardGroupLayoutManager

            //set the adapter
            adapter = CardGroupAdapter(recyclerViewChild.cards as ArrayList<Card>, (designType[2]-'0'), activity)

            setRecycledViewPool(viewPool)
        }
    }

    //add the received cardGroup List to the constructor
    fun addCards(cards: ArrayList<CardGroup>){
        this.cardGroups.apply {
            clear()
            addAll(cards)
        }
    }
}
