package modelo.entidades

import modelo.entidades.Alimento
import java.io.Serializable

data class Ingrediente(var alimento: Alimento, var cantidad:Double=alimento.cantidadTotal): Serializable{


}
