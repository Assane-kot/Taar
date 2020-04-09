package com.jambaar.taar.models

data class Model(
    var idModel: String,
    var idProprietaire: String,
    var nom: String,
    var categorie: String,
    var imageUri: String,
    var commentaires: List<Commentaire>
) {

}
