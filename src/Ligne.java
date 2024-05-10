public class Ligne {
    // Attributs privés
    private Commande commande;
    private Article article;
    private int quantitecomm;

    // Constructeur paramétré
    public Ligne(Commande commande, Article article, int quantitecomm) {
        this.commande = commande;
        this.article = article;
        this.quantitecomm = quantitecomm;
    }

    // Accesseurs (getters et setters) publics
    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantitecomm() {
        return quantitecomm;
    }

    public void setQuantitecomm(int quantitecomm) {
        this.quantitecomm = quantitecomm;
    }
    
    public void afficherDetails() {
        System.out.println("Référence de l'article : " + article.getReference());
        System.out.println("Désignation de l'article : " + article.getDesignation());
        System.out.println("Quantité commandée : " + quantitecomm);
        System.out.println("Montant total de la ligne : " + article.getPrixUnitaire() * quantitecomm);
    }
}
