package com.jambaar.taar.models

data class Proprietaire(
    var id: String,
    var nom: String,
    var nomAtelier: String,
    var imageUri: String,
    var adresse: String,
    var telephone: String,
    var email: String,
    var commande: List<CommandeTailleur>
) {

}