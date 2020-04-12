package com.jambaar.taar.models

data class CommandeTailleur(
    var idCommande: String,
    var idTailleur: String,
    var idClient: String,
    var statut: String,
    var avance: Double,
    var restant: Double,
    var dateLivraison: String,
    var nomTissu: String,
    var nomModel: String,
    var mesures: HashMap<String, Double>
)
