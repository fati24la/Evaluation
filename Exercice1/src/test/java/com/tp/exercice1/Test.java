package com.tp.exercice1;

import com.tp.exercice1.classes.Categorie;
import com.tp.exercice1.classes.Commande;
import com.tp.exercice1.classes.LigneCommande;
import com.tp.exercice1.classes.Produit;
import com.tp.exercice1.dao.CategorieDao;
import com.tp.exercice1.dao.CommandeDao;
import com.tp.exercice1.dao.LigneCommandeDao;
import com.tp.exercice1.dao.ProduitDao;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        CategorieDao categorieDao = new CategorieDao();
        ProduitDao produitDao = new ProduitDao();
        CommandeDao commandeDao = new CommandeDao();
        LigneCommandeDao ligneDao = new LigneCommandeDao();

        // --- Catégories ---
        Categorie cat1 = new Categorie("Informatique");
        Categorie cat2 = new Categorie("Électroménager");
        Categorie cat3 = new Categorie("Téléphonie");
        categorieDao.create(cat1);
        categorieDao.create(cat2);
        categorieDao.create(cat3);

        // --- Produits ---
        Produit p1 = new Produit("Ordinateur HP", 7500.0, cat1);
        Produit p2 = new Produit("Imprimante Epson", 1200.0, cat1);
        Produit p3 = new Produit("Réfrigérateur LG", 5500.0, cat2);
        Produit p4 = new Produit("Télévision Samsung", 4500.0, cat2);
        Produit p5 = new Produit("iPhone 15", 10000.0, cat3);
        Produit p6 = new Produit("Samsung Galaxy S23", 8500.0, cat3);

        produitDao.create(p1);
        produitDao.create(p2);
        produitDao.create(p3);
        produitDao.create(p4);
        produitDao.create(p5);
        produitDao.create(p6);

        // --- Commandes ---
        Commande cmd1 = new Commande(new Date());
        Commande cmd2 = new Commande(new Date(System.currentTimeMillis() - 86400000L)); // hier
        Commande cmd3 = new Commande(new Date(System.currentTimeMillis() - 2*86400000L)); // avant-hier
        commandeDao.create(cmd1);
        commandeDao.create(cmd2);
        commandeDao.create(cmd3);

        // --- Lignes de commande ---
        ligneDao.create(new LigneCommande(2, p1, cmd1));
        ligneDao.create(new LigneCommande(1, p2, cmd1));
        ligneDao.create(new LigneCommande(3, p3, cmd2));
        ligneDao.create(new LigneCommande(1, p4, cmd2));
        ligneDao.create(new LigneCommande(2, p5, cmd3));
        ligneDao.create(new LigneCommande(1, p6, cmd3));

        System.out.println("✅ Exemple de données ajoutées avec succès !");
    }
}