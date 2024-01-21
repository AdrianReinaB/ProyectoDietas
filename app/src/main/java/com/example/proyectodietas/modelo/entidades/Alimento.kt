package modelo.entidades

import java.io.Serializable

data class Alimento (var nombre: String,
                     var tipo:String="simple",
                     var grHC: Double=0.0,
                     var grLip:Double=0.0,
                     var grPro:Double=0.0): Serializable {
    var idAlimento=0
    var cantidadTotal=0.0
    var Kcal:Double=0.0
    //En Java equivale a escribir:
    //ArrayList<Ingrediente> ingredientes= new ArrayList<>();
    var ingredientes :MutableList<Ingrediente> = mutableListOf()

    init{
        if (tipo=="simple"||tipo=="procesado"){
            cantidadTotal=100.0
        }
        calculaKcal()
    }
    fun addIngrediente(ing: Ingrediente){
        ingredientes.add(ing)
        this.calculaCantidades(ing)
        this.calculaKcal()
    }


    fun recalcula(){
        this.cantidadTotal=0.0
        this.grHC=0.0
        this.grLip=0.0
        this.grPro=0.0
        for(ing in ingredientes){
            if (ing!=null) {
                this.calculaCantidades(ing)
                this.calculaKcal()
            }
        }
    }

    fun calculaKcal() {
        this.Kcal=(4*grHC+4*grPro+9*grLip)
    }

    private fun calculaCantidades(ing: Ingrediente){
        this.cantidadTotal+=ing.cantidad
        this.grHC+=ing.alimento.grHC*ing.cantidad/ing.alimento.cantidadTotal
        this.grLip+=ing.alimento.grLip*ing.cantidad/ing.alimento.cantidadTotal
        this.grPro+=ing.alimento.grPro*ing.cantidad/ing.alimento.cantidadTotal
    }
}