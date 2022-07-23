package com.example.fampayproject.adapters
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.net.Uri
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.text.set
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fampayproject.R

import com.example.fampayproject.models.Card

class CardGroupAdapter(private val cards: ArrayList<Card>, private val type: Int, private val activity: Activity): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        //inflate the layouts as per the type value
        when (type) {
            1 -> {
                return ViewHolder1(
                    LayoutInflater.from(parent.context).inflate(R.layout.hc1_layout, parent, false)
                )
            }
            3 -> {
                return ViewHolder3(
                    LayoutInflater.from(parent.context).inflate(R.layout.hc3_layout, parent, false)
                )
            }
            5 -> {
                return ViewHolder5(
                    LayoutInflater.from(parent.context).inflate(R.layout.hc5_layout, parent, false)
                )
            }
            6 -> {
                return ViewHolder6(
                    LayoutInflater.from(parent.context).inflate(R.layout.hc6_layout, parent, false)
                )
            }
            else -> {
                return ViewHolder9(
                    LayoutInflater.from(parent.context).inflate(R.layout.hc9_layout, parent, false)
                )
            }
        }
    }

    //binding the positon with the holders
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        //bind the position to the viewHolders as per the type
        when (type) {
            1 -> {
                (holder as ViewHolder1).bind(position)
            }
            3 -> {
                (holder as ViewHolder3).bind(position)
            }
            5 -> {
                (holder as ViewHolder5).bind(position)
            }
            6 -> {
                (holder as ViewHolder6).bind(position)
            }
            9 -> {
                (holder as ViewHolder9).bind(position)
            }
        }
    }

    //get the item size in the list
    override fun getItemCount(): Int {
        return cards.size
    }


    //----------> [FEATURE ADD] to implement remove but donot appear again
    //implement the remove item method
    private fun removeItem(position: Int) {
        cards.removeAt(position)
        notifyItemRemoved(position)
    }


    //the respective viewHolder inner classes

    //viewHolder class for HC1
    private inner class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title_hc1)
        val image: ImageView = itemView.findViewById(R.id.image_hc1)
        val cardView: CardView = itemView.findViewById(R.id.cardview_hc1)
        val description: TextView = itemView.findViewById(R.id.description_hc1)

        // add a bind method
        fun bind(position: Int) {

            //set all attributes as per data received
            val item = cards[position]

            val util = Utils()
            util.loadIcon(item, image)
            util.onClick(item, itemView)
            util.formatText(item, title)
            util.formatDescription(item, description)

            //Set the Background Colour
            if (item.bg_color != null) {
                cardView.setCardBackgroundColor(Color.parseColor(item.bg_color))
            }
        }
    }

    //viewHolder class for HC3
    private inner class ViewHolder3(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title_hc3)
        val desc: TextView = itemView.findViewById(R.id.description_hc3)
        val image: ImageView = itemView.findViewById(R.id.image_hc3)
        val relativeLayout: RelativeLayout = itemView.findViewById(R.id.relative_layout_hc3)
        val sliding: LinearLayout = itemView.findViewById(R.id.sliding_hc3)
        val remind: LinearLayout = itemView.findViewById(R.id.remind_hc3)
        val dismiss: LinearLayout = itemView.findViewById(R.id.dismiss_hc3)
        val button: Button = itemView.findViewById(R.id.action_hc3)


        //add a bind method
        fun bind(position: Int) {
            //set all attributes as per data received
            val item = cards[position]

            val util = Utils()
            util.loadImage(item, image)
            title.text = item.title
            util.formatText(item, title)
            util.formatDescription(item, desc)
            util.buttonChanges(item, button)
            util.slidingFeature(position, itemView, sliding, remind, dismiss, relativeLayout, item)

            //set background colour of relative layout
            relativeLayout.setBackgroundColor(Color.parseColor(item.bg_color))


        }
    }

    //viewHolder class for HC5
    private inner class ViewHolder5(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardview_hc5)
        val icon: ImageView = itemView.findViewById(R.id.image_hc5)

        //add bind method
        fun bind(position: Int) {

            //set all attributes as per data received
            val item = cards[position]

            //setBackgroundColour
            cardView.setCardBackgroundColor(Color.parseColor(item.bg_color))

            val util = Utils()
            util.loadImage(item, icon)
            util.onClick(item, itemView)

        }
    }

    //viewHolder class for HC6
    private inner class ViewHolder6(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.name_hc6)
        val icon: ImageView = itemView.findViewById(R.id.image_hc6)
        val description: TextView = itemView.findViewById(R.id.description_hc6)


        fun bind(position: Int) {
            //get the item
            val item = cards[position]

            val util = Utils()
            util.formatText(item, title)
            util.formatDescription(item, description)
            util.loadIcon(item, icon)
            util.onClick(item, itemView)

        }
    }

    //viewHolder class for HC9
    private inner class ViewHolder9(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image_hc9)
        val card: CardView = itemView.findViewById(R.id.cardview_hc9)
        fun bind(position: Int) {

            val item = cards[position]

            val util = Utils()
            util.loadImage(item, image)
            util.onClick(item, itemView)

            //make width and height dynamic
            val params = card.layoutParams
            params.width = (item.bg_image.aspect_ratio * params.height).toInt()
            card.layoutParams = params
        }
    }


    //get all the utilities function.
    private inner class Utils() {

        //remove an item from hc3 type
        fun slidingFeature(
            position: Int,
            itemView: View,
            sliding: LinearLayout,
            remind: LinearLayout,
            dismiss: LinearLayout,
            relativeLayout: RelativeLayout,item: Card
        ) {

            //<--DIFFERENT FEATURE-->slide to show the remove or dismiss feature
            itemView.setOnLongClickListener {
                if (sliding.visibility == View.VISIBLE) {
                    sliding.visibility = View.GONE
                } else {
                    sliding.visibility = View.VISIBLE
                }
                true
            }

            //clicklistener for remind
            remind.setOnClickListener {
                removeItem(position)
                relativeLayout.visibility = View.GONE

                Toast.makeText(activity, "Will Remind Later!", Toast.LENGTH_SHORT).show()
            }

            //clicklistener for dismiss
            dismiss.setOnClickListener {
                removeItem(position)
                relativeLayout.visibility = View.GONE

                Toast . makeText (activity, "Dismissed!", Toast.LENGTH_SHORT
                ).show()
            }
        }

        //if a cta is envoked
        fun buttonChanges(item: Card, button: Button) {

            //assumed that there is one button but this can be multiple and can be done with an adapter
            val cta = item.cta[0]

            button.setText(cta.text)
            button.setTextColor(Color.parseColor(cta.text_color))
            button.setBackgroundColor(Color.parseColor(cta.bg_color))
            if (!item.is_disabled) {
                button.setOnClickListener {
                    activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(cta.url)))
                }
            }
        }

        //if item has an attached url and it is enabled then
        fun onClick(item: Card, itemView: View) {
            if (!item.is_disabled) {
                itemView.setOnClickListener {
                    activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(item.url)))
                }
            }
        }

        //to load the images via glide
        fun loadImage(item: Card, image: ImageView) {
            Glide.with(activity).load(item.bg_image.image_url).into(image)
        }

        //to load icon via glide
        fun loadIcon(item: Card, image: ImageView) {
            Glide.with(activity).load(item.icon.image_url).into(image)
        }

        //change the title as per the entities
        fun formatText(item: Card, title: TextView) {

            if (item.formatted_title == null) {
                title.setText(item.title);
                return
            } else {

                //no need of parsing if both are the same
                if(item.formatted_title.text== item.title){
                    title.setText(item.title);
                    return
                }

                //if there is need of some alignment
                if (item.formatted_title.align != null) {
                    when (item.formatted_title.align) {
                        "left" -> title.gravity = Gravity.LEFT
                        "right" -> title.gravity = Gravity.RIGHT
                        "center" -> title.gravity = Gravity.CENTER
                    }
                }

                //if there is a formatted title present but there are not entities
                if (item.formatted_title.entities.size == 0) {
                    title.setText(item.title);
                    return
                } else {

                    val toParse = item.title
                    val ssb = SpannableStringBuilder(toParse)

                    var j = 0
                    var k = 0
                    var m = 0

                    while (j < toParse.length && k < item.formatted_title.text.length) {

                        var end = 0

                        if (toParse[j] != item.formatted_title.text[k]) {
                            end = item.formatted_title.entities[m].text.length


                            //format Colour
                            if (item.formatted_title.entities[m].color != null) {
                                val color =
                                    ForegroundColorSpan(Color.parseColor(item.formatted_title.entities[m].color))
                                ssb.setSpan(
                                    color,
                                    j,
                                    j + end,
                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                )

                            }

                            //format the style
                            if (item.formatted_title.entities[m].font_style != null) {
                                if (item.formatted_title.entities[m].font_style == "italic") {
                                    val italic = StyleSpan(Typeface.ITALIC)
                                    ssb.setSpan(
                                        italic,
                                        j,
                                        j + end,
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                    )
                                } else {
                                    val underline = UnderlineSpan()
                                    ssb.setSpan(
                                        underline,
                                        j,
                                        j + end,
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                    )
                                }
                            }

                            //enable click
                            if (item.formatted_title.entities[m].url != null) {
                                ssb[j..j + end] = object : ClickableSpan() {
                                    override fun onClick(p0: View) {
                                        activity.startActivity(
                                            Intent(
                                                Intent.ACTION_VIEW,
                                                Uri.parse(item.formatted_title.entities[m].url)
                                            )
                                        )
                                    }
                                }
                            }
                            title.setText(ssb)
                            title.movementMethod = LinkMovementMethod.getInstance()

                            k += 2
                            j += end
                            m += 1
                        } else {
                            j += 1
                            k += 1

                        }
                    }
                }
            }
        }


        //change the description as per the entity
        fun formatDescription(item:Card, descp: TextView){


                if (item.formatted_description == null) {
                    descp.setText(item.description);
                    return
                } else {

                    //no need of parsing if both are the same
                    if(item.formatted_description.text== item.description){
                        descp.setText(item.title);
                        return
                    }

                    //if there is need of some alignment
                    if (item.formatted_description.align != null) {
                        when (item.formatted_description.align) {
                            "left" -> descp.gravity = Gravity.LEFT
                            "right" -> descp.gravity = Gravity.RIGHT
                            "center" -> descp.gravity = Gravity.CENTER
                        }
                    }

                    //if there is a formatted description present but there are not entities
                    if (item.formatted_description.entities.size == 0) {
                        descp.setText(item.description);
                        return
                    } else {

                        val toParse = item.description
                        val ssb = SpannableStringBuilder(toParse)

                        var j = 0
                        var k = 0
                        var m = 0

                        while (j < toParse.length && k < item.formatted_description.text.length) {

                            var end = 0

                            if (toParse[j] != item.formatted_description.text[k]) {
                                end = item.formatted_description.entities[m].text.length


                                //format Colour
                                if (item.formatted_description.entities[m].color != null) {
                                    val color =
                                        ForegroundColorSpan(Color.parseColor(item.formatted_description.entities[m].color))
                                    ssb.setSpan(
                                        color,
                                        j,
                                        j + end,
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                    )

                                }

                                //format the style
                                if (item.formatted_description.entities[m].font_style != null) {
                                    if (item.formatted_description.entities[m].font_style == "italic") {
                                        val italic = StyleSpan(Typeface.ITALIC)
                                        ssb.setSpan(
                                            italic,
                                            j,
                                            j + end,
                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                        )
                                    } else {
                                        val underline = UnderlineSpan()
                                        ssb.setSpan(
                                            underline,
                                            j,
                                            j + end,
                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                        )
                                    }
                                }

                                //enable click
                                if (item.formatted_description.entities[m].url != null) {
                                    ssb[j..j + end] = object : ClickableSpan() {
                                        override fun onClick(p0: View) {
                                            activity.startActivity(
                                                Intent(
                                                    Intent.ACTION_VIEW,
                                                    Uri.parse(item.formatted_description.entities[m].url)
                                                )
                                            )
                                        }
                                    }
                                }
                                descp.setText(ssb)
                                descp.movementMethod = LinkMovementMethod.getInstance()

                                k += 2
                                j += end
                                m += 1
                            } else {
                                j += 1
                                k += 1

                            }
                        }
                    }
                }
        }
    }
}
