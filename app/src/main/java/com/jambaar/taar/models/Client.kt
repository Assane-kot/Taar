package com.jambaar.taar.models

data class Client(
    var idClient: String,
    var nom: String,
    var imageUri: String,
    var adresse: String,
    var telephone: String,
    var email: String,
    var favoris: List<String>,
    var commandes: List<CommandeTailleur>
)
