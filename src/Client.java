
public class Client extends Personne {
		private float chiffreaffaire;

		public Client(int ident, String nomsocial, String adresse, float chiffreaffaire) {
			super(ident, nomsocial, adresse);
			this.chiffreaffaire = chiffreaffaire;
		}

		public float getChiffreaffaire() {
			return chiffreaffaire;
		}

		public void setChiffreaffaire(float chiffreaffaire) {
			this.chiffreaffaire = chiffreaffaire;
		}
		@Override
		public void Affiche() {
		    // Appel à la méthode Affiche de la super-classe
		    super.Affiche();
		    
		    // Affichage des informations spécifiques au client
		    System.out.println("Chiffre d'affaire : " + chiffreaffaire);
		}

}
