import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Commande {
    // Attributs privés
    private int numcomm;
    private Date datecomm;
    private Client client;
    private Vector<Ligne> lignes = new Vector<>(); 

    // Constructeur paramétré
    public Commande(int numcomm, Date datecomm, Client client) {
        this.numcomm = numcomm;
        this.datecomm = datecomm;
        this.client = client;
    }

    // Accesseurs (getters et setters) publics
    public int getNumcomm() {
        return numcomm;
    }

    public void setNumcomm(int numcomm) {
        this.numcomm = numcomm;
    }

    public Date getDatecomm() {
        return datecomm;
    }

    public void setDatecomm(Date datecomm) {
        this.datecomm = datecomm;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void ajouterLigne(Ligne ligne) {
        lignes.add(ligne);
    }
    public void afficherDetails() {
        System.out.println("Numéro de commande : " + numcomm);
        System.out.println("Date de commande : " + datecomm);
        System.out.println("Client : " + client.getNomsocial());

        // Vérifiez si le vecteur lignes est null ou vide avant de l'afficher
        if (lignes != null && !lignes.isEmpty()) {
            System.out.println("Lignes de commande :");
            for (Ligne ligne : lignes) {
                System.out.println(ligne); // Assurez-vous que la classe Ligne a une méthode toString appropriée
            }
        } else {
            System.out.println("Aucune ligne de commande pour cette commande.");
        }
    }
    
}
