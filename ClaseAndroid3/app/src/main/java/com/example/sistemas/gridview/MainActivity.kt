package com.example.sistemas.gridview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_entry.view.*

class MainActivity : AppCompatActivity() {

    var adapter : FoodAdapter? = null
    var foodsList = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        foodsList.add(Food("Durazno", R.drawable.durazno))
        foodsList.add(Food("Naranja", R.drawable.naranja))
        foodsList.add(Food("pera", R.drawable.pera))
        foodsList.add(Food("uva", R.drawable.uva))

        gvFoods.adapter = adapter
    }

    class FoodAdapter : BaseAdapter {

        var foodsList = ArrayList<Food>()
        var context: Context? = null

        constructor(context: Context, foodsList: ArrayList<Food>) : super(){
            this.context = context
            this.foodsList = foodsList
        }

        override fun getCount(): Int {
            return foodsList.size
        }

        override fun getItem(position: Int): Any {
            return foodsList[position]
        }

        override fun getItemId(position: Int): Long {
            return  position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = this.foodsList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.food_entry, null)
            foodView.imgFood.setImageResource(food.image!!)
            foodView.tvName.text = food.name!!
            return foodView
        }
    }
}
