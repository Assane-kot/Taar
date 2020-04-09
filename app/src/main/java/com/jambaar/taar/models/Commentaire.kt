package com.jambaar.taar.models

data class Commentaire(
    var idCommentaire: String,
    var idUtilisateur: String,
    var idModel: String,
    var note: String,
    var like: Int,
    var imageUri: String
) {

}
