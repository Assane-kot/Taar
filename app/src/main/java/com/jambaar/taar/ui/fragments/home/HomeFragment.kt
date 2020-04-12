package com.jambaar.taar.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.jambaar.taar.R
import com.jambaar.taar.adapters.CategorieAdapter
import com.jambaar.taar.models.Categorie
import com.jambaar.taar.ui.fragments.chaussures.ChaussureFragment
import com.jambaar.taar.ui.fragments.model_coiffure.ModelCoiffureFragment
import com.jambaar.taar.ui.fragments.model_tailleur.ModelTailleurFragment
import com.jambaar.taar.ui.fragments.pret_a_porter.PretPorterFragment
import com.jambaar.taar.ui.fragments.sac.SacFragment
import com.jambaar.taar.ui.fragments.tissus.TissusFragment


/**
 * Ce fragment affiche les differentes categorie dans la page d'acceuil de l'application
 * ainsi que le menu et toutes les autres fonctionnalitees en fonction du role de
 * l'utilisateur connecte.
 */
class HomeFragment : Fragment() {

    private lateinit var gridView: GridView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        gridView = view.findViewById(R.id.gridview)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setHomeItems()
    }

    /**
     * Cette fonction cree les 6 categories de la page d'accueil
     * associe ces category a la classe CategorieAdapter pour les ajouter dynamiquement
     * dans le gridview de la page d'acceuil.
     * A la fin, setOnItemClickListener est applique dans le gidview pour remplacer le
     * fragment courant par cel selectionne par l'utilisateur.
     */
    private fun setHomeItems() {
        val modelTailleur = Categorie("model_tailleur", "Model Tailleur")
        val modelCoiffure = Categorie("model_coiffure", "Model Coiffure")
        val tissus = Categorie("tissus", "Tissus")
        val sac = Categorie("sac", "Sac")
        val pPorter = Categorie("pret_a_porter", "Prêt à Porter")
        val chaussures = Categorie("chaussures", "Chaussures")


        val categories = arrayOf(modelTailleur, modelCoiffure, pPorter, tissus, sac, chaussures)
        gridView.adapter = context?.let { CategorieAdapter(it, categories.toList()) }

        gridView.setOnItemClickListener { parent, view, position, id ->
            val item = categories[position]
            when (item.imageName) {
                "model_tailleur" -> replaceFragment(
                    ModelTailleurFragment(),
                    "ModelTailleurFragment"
                )
                "model_coiffure" -> replaceFragment(
                    ModelCoiffureFragment(),
                    "ModelCoiffureFragment"
                )
                "tissus" -> replaceFragment(TissusFragment(), "TissusFragment")
                "sac" -> replaceFragment(SacFragment(), "SacFragment")
                "pret_a_porter" -> replaceFragment(PretPorterFragment(), "PretPorterFragment")
                "chaussures" -> replaceFragment(ChaussureFragment(), "ChaussureFragment")
            }
        }
    }

    /**
     * Cette fonction remplace le fragment courant a celui selectionne par l'utilisateur
     * @param fragment
     * @param tag
     * @return Void
     */
    private fun replaceFragment(fragment: Fragment, tag: String) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_container, fragment, tag)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

}
