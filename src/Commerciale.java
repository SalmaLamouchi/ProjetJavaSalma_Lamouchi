import java.util.Vector;
import java.util.Scanner;
import java.util.Date;

public class Commerciale {
    
    private Vector<Article> articles = new Vector<>();
    private Vector<Client> clients = new Vector<>();
    private Vector<Commande> commandes = new Vector<>();
    private Vector<Ligne> lignes = new Vector<>();

    
    private Scanner scanner = new Scanner(System.in);

    
    public void AjouterArticle() {
        System.out.println("Entrez la référence de l'article:");
        int reference = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Entrez la désignation de l'article:");
        String designation = scanner.nextLine();
        
        double prixUnitaire = 0;
        boolean prixValide = false;
        while (!prixValide) {
            try {
                System.out.println("Entrez le prix unitaire de l'article:");
                prixUnitaire = Double.parseDouble(scanner.nextLine());
                prixValide = true;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un prix valide.");
            }
        }

        System.out.println("Entrez la quantité en stock de l'article:");
        int quantiteStock = scanner.nextInt();

        Article nouvelArticle = new Article(reference, designation, prixUnitaire, quantiteStock);
        articles.add(nouvelArticle);
       
    }
    public void AfficherArticles() {
        if (articles.isEmpty()) {
            System.out.println("Aucun article disponible.");
        } else {
            System.out.println("--- Liste des Articles ---");
            for (Article article : articles) {
                article.Affiche();
                System.out.println("--------------------------");
                System.out.println("Taille: " + articles.size());

            }
        }
    }
    public void AfficherClients() {
        if (clients.isEmpty()) {
            System.out.println("Aucun client disponible.");
        } else {
            System.out.println("--- Liste des Clients ---");
            for (Client client : clients) {
                client.Affiche();
                System.out.println("--------------------------");
                System.out.println("Taille: " + clients.size());

            }
        }
    }

    public void SupprimerArticle() {
        if (articles.isEmpty()) {
            System.out.println("Aucun article à supprimer.");
            return;
        }

        System.out.println("Entrez la référence de l'article à supprimer:");
        int referenceToDelete = scanner.nextInt();
        boolean found = false;
        for (Article article : articles) {
            if (article.getReference() == referenceToDelete) {
                articles.remove(article);
                found = true;
                System.out.println("Article supprimé avec succès.");
                break; 
            }
        }
        if (!found) {
            System.out.println("Aucun article trouvé avec cette référence.");
        }
    }
   

 
    public void AjouterClient() {
        System.out.println("Entrez l'identifiant du client:");
        int ident = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Entrez le nom social du client:");
        String nomSocial = scanner.nextLine();
        System.out.println("Entrez l'adresse du client:");
        String adresse = scanner.nextLine();
        System.out.println("Entrez le chiffre d'affaire du client:");
        float chiffreAffaire = 0;

        boolean isValid = false;
        while (!isValid) {
            try {
                String input = scanner.nextLine();
                input = input.replace(',', '.');
                chiffreAffaire = Float.parseFloat(input);
                isValid = true;
                System.out.println("Client ajouté avec succès.");

            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un chiffre d'affaires valide:");
            }
        }

        Client nouveauClient = new Client(ident, nomSocial, adresse, chiffreAffaire);
        clients.add(nouveauClient);
    }

    public void SupprimerClient(int ident) {
        for (Client client : clients) {
            if (client.getIdent() == ident) {
                clients.remove(client);
                System.out.println("Client supprimé avec succès.");
                return; 
            }
        }
        System.out.println("Aucun client trouvé avec cet identifiant.");
    }


  

   public void PasserCommande(Commande c) {
        commandes.add(c);
    }

    public void AnnulerCommande(Commande c) {
        commandes.remove(c);
    }
    
    public void AfficherCommandes() {
        if (commandes.isEmpty()) {
            System.out.println("Aucune commande disponible.");
        } else {
            System.out.println("--- Liste des Commandes ---");
            for (Commande commande : commandes) {
                commande.afficherDetails(); 
                System.out.println("--------------------------");
            }
            System.out.println("Nombre de commandes : " + commandes.size());
        }
    }

    
    
    public static void main(String[] args) {
        Commerciale commerciale = new Commerciale();
        int choice;
        do {
            System.out.println("\n--- Menu Gestion Commerciale ---");
            System.out.println("1. Ajouter Article");
            System.out.println("2. Supprimer Article");
            System.out.println("3. Ajouter Client");
            System.out.println("4. Supprimer Client");
            System.out.println("5. Passer Commande");
            System.out.println("6. Annuler Commande");
            System.out.println("7. Afficher Liste des Articles");
            System.out.println("8. Afficher Liste des Clients");
            System.out.println("9. Afficher Liste des Commandes");

            System.out.println("0. Quitter");
            System.out.print("Entrez votre choix: ");
            choice = commerciale.scanner.nextInt();
            
            switch (choice) {
                case 1:
                    commerciale.AjouterArticle();
                    break;
                case 2:
                    commerciale.SupprimerArticle(); 
                    break;
                case 3:
                    commerciale.AjouterClient();
                    break;
                case 4:
                    if (!commerciale.clients.isEmpty()) {
                        System.out.println("Entrez l'identifiant du client à supprimer:");
                        int identClientToDelete = commerciale.scanner.nextInt();
                        commerciale.SupprimerClient(identClientToDelete);
                    } else {
                        System.out.println("Aucun client à supprimer.");
                    }
                    break;

                case 5:
                    if (!commerciale.clients.isEmpty() && !commerciale.articles.isEmpty()) {
                        if (!commerciale.articles.isEmpty()) {
                            Article articleCommande = commerciale.articles.get(0); // Sélectionnez le premier article disponible
                            int quantiteCommande = 1; // Par exemple, commandez une seule unité
                            
                            // Créer une nouvelle ligne de commande avec l'article et la quantité spécifiés
                            Ligne ligneCommande = new Ligne(null, articleCommande, quantiteCommande);
                            
                            // Ajouter la ligne de commande à la liste des lignes de commande
                            commerciale.lignes.add(ligneCommande);
                            
                            // Créer une nouvelle commande
                            Client client = new Client(1, "NomClient", "AdresseClient", 1000.0f);
                            Date dateComm = new Date(); 

                            // Créer une instance de Commande avec des valeurs fictives
                            Commande commande = new Commande(1, dateComm, client);
                            
                            // Passer la commande
                            commerciale.PasserCommande(commande);
                            
                            System.out.println("Commande passée avec succès.");
                        } else {
                            System.out.println("Aucun article disponible pour passer la commande.");
                        }
                    } else {
                        System.out.println("Impossible de passer une commande, clients ou articles non disponibles.");
                    }
                    break;

                case 6:
                    if (!commerciale.commandes.isEmpty()) {
                        Commande commandeAAnnuler = commerciale.commandes.get(0); 
                        
                        commerciale.AnnulerCommande(commandeAAnnuler);
                        
                        System.out.println("Commande annulée avec succès.");
                    } else {
                        System.out.println("Aucune commande disponible à annuler.");
                    }
                    break;

                               
                        
                case 7:
                    commerciale.AfficherArticles();
                    break;
                case 8:
                    commerciale.AfficherClients();
                    break;
                    
                case 9:
                    commerciale.AfficherCommandes();
                    break;
                case 0:
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Choix non valide, veuillez réessayer.");
            }
        } while (choice != 0);

       

        commerciale.scanner.close();
    }
}
