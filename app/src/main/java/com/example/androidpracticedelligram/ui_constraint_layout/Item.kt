package com.example.androidpracticedelligram.ui_constraint_layout

class Item(private var name:String, private var price: String, private var offer: String, private var image: Int) {
    fun getName(): String { return name  }
    fun getPrice(): String { return price  }
    fun getOffer(): String { return offer  }
    fun getImage(): Int { return image  }
}