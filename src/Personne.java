
public abstract class Personne {

	protected int ident;
	protected String  nomsocial;
	protected String adresse;
	
	protected int getIdent() {
		return ident;
	}

	protected void setIdent(int ident) {
		this.ident = ident;
	}

	protected String getNomsocial() {
		return nomsocial;
	}

	protected void setNomsocial(String nomsocial) {
		this.nomsocial = nomsocial;
	}

	protected String getAdresse() {
		return adresse;
	}

	protected void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	protected Personne(int ident, String nomsocial, String adresse) {
		super();
		this.ident = ident;
		this.nomsocial = nomsocial;
		this.adresse = adresse;
	}
	
	public String toString() {
		return "ident"+this.ident+"nomsocial"+this.nomsocial+"adresse"+this.adresse;
	}

	public void Affiche() {
		System.out.println("id:"+ ident+"\n"+"nom:"+nomsocial+"\n"+"adresse"+adresse);

	}
	
}
