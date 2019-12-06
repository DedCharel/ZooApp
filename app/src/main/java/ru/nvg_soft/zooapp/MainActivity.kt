package ru.nvg_soft.zooapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimal = ArrayList<Animal>()
    var adapter: AnimalsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animal
        listOfAnimal.add(
            Animal("Baboon", "Baboon live in big place with tree", R.drawable.baboon, false))
        listOfAnimal.add(
            Animal("Bulldog", "Bulldog live in big place with tree", R.drawable.bulldog, true))
        listOfAnimal.add(
            Animal("Panda", "Panda live in big place with tree", R.drawable.panda, false))
        listOfAnimal.add(
            Animal("Swallow", "Swallow live in big place with tree", R.drawable.swallow_bird, false))
        listOfAnimal.add(
            Animal("Tiger", "Tiger live in big place with tree", R.drawable.white_tiger, true))
        listOfAnimal.add(
            Animal("Zebra", "Zebra live in big place with tree", R.drawable.zebra, false))

        adapter = AnimalsAdapter(this, listOfAnimal)
        lvAnimal.adapter = adapter
    }

    class AnimalsAdapter:BaseAdapter{
        var listOfAnimals = ArrayList<Animal>()
        var context:Context? = null
        constructor(context:Context, listOfAnimals:ArrayList<Animal>){
            this.listOfAnimals = listOfAnimals
            this.context = context

        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimals[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView:View?=null
            if (animal.isKiller == true) {
             myView = inflater.inflate(R.layout.animal_killer_ticket, null)}
            else{
            myView = inflater.inflate(R.layout.animal_ticket, null)}
            myView.tvName.text = animal.name!!
            myView.tvDescription.text = animal.des!!
            myView.ivAnimal.setImageResource(animal.image!!)
            return myView

        }

        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }
    }
}
