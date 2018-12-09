package systemKadrowy;

public class Kierownik extends Pracownik {

	private double pensja;
	private double procentPremii;
	private double dodatekKierowniczy;
	private String numerTelefonu;
	private String numerTelefonuKom�rkowego;
	private int numerPokoju;
	private String nazwaDzialu;
	
	public Kierownik() {
		super();
		
	}

	public Kierownik(String imie, String nazwisko, int rokUrodzenia) {
		super(imie, nazwisko, rokUrodzenia);
	}

	public Kierownik(String imie, String nazwisko, int rokUrodzenia, double pensja, double procentPremii, double dodatekKierowniczy, String numerTelefonu,
			String numerTelefonuKom�rkowego, int numerPokoju, String nazwaDzialu) {
		super(imie, nazwisko, rokUrodzenia);
		this.pensja = pensja;
		this.procentPremii = procentPremii;
		this.dodatekKierowniczy = dodatekKierowniczy;
		this.numerTelefonu = numerTelefonu;
		this.numerTelefonuKom�rkowego = numerTelefonuKom�rkowego;
		this.numerPokoju = numerPokoju;
		this.nazwaDzialu = nazwaDzialu;
	}
	
	public double obliczPensje() {
		return pensja + procentPremii * pensja + dodatekKierowniczy;
	}

	public double getPensja() {
		return pensja;
	}

	public void setPensja(double pensja) {
		this.pensja = pensja;
	}

	public double getProcentPremii() {
		return procentPremii;
	}

	public void setProcentPremii(double procentPremii) {
		this.procentPremii = procentPremii;
	}

	public double getDodatekKierowniczy() {
		return dodatekKierowniczy;
	}

	public void setDodatekKierowniczy(double dodatekKierowniczy) {
		this.dodatekKierowniczy = dodatekKierowniczy;
	}

	public String getNumerTelefonu() {
		return numerTelefonu;
	}

	public void setNumerTelefonu(String numerTelefonu) {
		this.numerTelefonu = numerTelefonu;
	}

	public String getNumerTelefonuKom�rkowego() {
		return numerTelefonuKom�rkowego;
	}

	public void setNumerTelefonuKom�rkowego(String numerTelefonuKom�rkowego) {
		this.numerTelefonuKom�rkowego = numerTelefonuKom�rkowego;
	}

	public int getNumerPokoju() {
		return numerPokoju;
	}

	public void setNumerPokoju(int numerPokoju) {
		this.numerPokoju = numerPokoju;
	}

	public String getNazwaDzialu() {
		return nazwaDzialu;
	}

	public void setNazwaDzialu(String nazwaDzialu) {
		this.nazwaDzialu = nazwaDzialu;
	}

	@Override
	public String toString() {
		return "PracownikFizyczny ["+ super.toString() + ", pensja= " + pensja + ", procentPremii= " + procentPremii + ", dodatekKierowniczy= "
				+ dodatekKierowniczy + ", numerTelefonu=" + numerTelefonu + ", numerTelefonuKom�rkowego="
				+ numerTelefonuKom�rkowego + ", numerPokoju=" + numerPokoju + ", nazwaDzialu=" + nazwaDzialu + ", pencja calkowita= " + obliczPensje() +"]";
	}
	
	
	
}
