package fr.traitement.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Nutriment {
	
	@Column(name="energie100g", nullable=false)
	private double energie100g;
	
	@Column(name="graisse100Gg", nullable=false)
	private double graisse100g;
	
	@Column(name="sucres100g", nullable=false)
	private double sucres100g;
	
	@Column(name="fibres100g", nullable=false)
	private double fibres100g;
	
	@Column(name="proteines100g", nullable=false)
	private double proteines100g;
	
	@Column(name="sel100g", nullable=false)
	private double sel100g;
	
	@Column(name="vitA100g", nullable=false)
	private double vitA100g;
	
	@Column(name="vitD100g", nullable=false)
	private double vitD100g;
	
	@Column(name="vitE100g", nullable=false)
	private double vitE100g;
	
	@Column(name="vitK100g", nullable=false)
	private double vitK100g;
	
	@Column(name="vitC100g", nullable=false)
	private double vitC100g;
	@Column(name="vitB1100g", nullable=false)
	private double vitB1100g;
	
	@Column(name="vitB2100g", nullable=false)
	private double vitB2100g;
	
	@Column(name="vitPP100g", nullable=false)
	private double vitPP100g;
	
	@Column(name="vitB6100g", nullable=false)
	private double vitB6100g;
	
	@Column(name="vitB9100g", nullable=false)
	private double vitB9100g;
	
	@Column(name="vitB12100g", nullable=false)
	private double vitB1200g;
	
	@Column(name="calcium100g", nullable=false)
	private double calcium100g;
	
	@Column(name="magnesium100g", nullable=false)
	private double magnesium100g;
	
	@Column(name="iron100g", nullable=false)
	private double iron100g;
	
	@Column(name="fer100g", nullable=false)
	private double fer100g;
	
	@Column(name="betaCarotene100g", nullable=false)
	private double betaCarotene100g;
	
	@Column(name="presenceHuilePalme", nullable=false)
	private boolean presenceHuilePalme;
	
	public Nutriment() {}
	
	public Nutriment(double energie100g, double graisse100g, double sucres100g, double fibres100g, double proteines100g,
			double sel100g, double vitA100g, double vitD100g, double vitE100g, double vitK100g, double vitC100g,
			double vitB1100g, double vitB2100g, double vitPP100g, double vitB6100g, double vitB9100g, double vitB1200g,
			double calcium100g, double magnesium100g, double iron100g, double fer100g, double betaCarotene100g,
			boolean presenceHuilePalme) {
		this.energie100g = energie100g;
		this.graisse100g = graisse100g;
		this.sucres100g = sucres100g;
		this.fibres100g = fibres100g;
		this.proteines100g = proteines100g;
		this.sel100g = sel100g;
		this.vitA100g = vitA100g;
		this.vitD100g = vitD100g;
		this.vitE100g = vitE100g;
		this.vitK100g = vitK100g;
		this.vitC100g = vitC100g;
		this.vitB1100g = vitB1100g;
		this.vitB2100g = vitB2100g;
		this.vitPP100g = vitPP100g;
		this.vitB6100g = vitB6100g;
		this.vitB9100g = vitB9100g;
		this.vitB1200g = vitB1200g;
		this.calcium100g = calcium100g;
		this.magnesium100g = magnesium100g;
		this.iron100g = iron100g;
		this.fer100g = fer100g;
		this.betaCarotene100g = betaCarotene100g;
		this.presenceHuilePalme = presenceHuilePalme;
	}
	
	public double getEnergie100g() {
		return energie100g;
	}
	public void setEnergie100g(double energie100g) {
		this.energie100g = energie100g;
	}
	public double getGraisse100g() {
		return graisse100g;
	}
	public void setGraisse100g(double graisse100g) {
		this.graisse100g = graisse100g;
	}
	public double getSucres100g() {
		return sucres100g;
	}
	public void setSucres100g(double sucres100g) {
		this.sucres100g = sucres100g;
	}
	public double getFibres100g() {
		return fibres100g;
	}
	public void setFibres100g(double fibres100g) {
		this.fibres100g = fibres100g;
	}
	public double getProteines100g() {
		return proteines100g;
	}
	public void setProteines100g(double proteines100g) {
		this.proteines100g = proteines100g;
	}
	public double getSel100g() {
		return sel100g;
	}
	public void setSel100g(double sel100g) {
		this.sel100g = sel100g;
	}
	public double getVitA100g() {
		return vitA100g;
	}
	public void setVitA100g(double vitA100g) {
		this.vitA100g = vitA100g;
	}
	public double getVitD100g() {
		return vitD100g;
	}
	public void setVitD100g(double vitD100g) {
		this.vitD100g = vitD100g;
	}
	public double getVitE100g() {
		return vitE100g;
	}
	public void setVitE100g(double vitE100g) {
		this.vitE100g = vitE100g;
	}
	public double getVitK100g() {
		return vitK100g;
	}
	public void setVitK100g(double vitK100g) {
		this.vitK100g = vitK100g;
	}
	public double getVitC100g() {
		return vitC100g;
	}
	public void setVitC100g(double vitC100g) {
		this.vitC100g = vitC100g;
	}
	public double getVitB1100g() {
		return vitB1100g;
	}
	public void setVitB1100g(double vitB1100g) {
		this.vitB1100g = vitB1100g;
	}
	public double getVitB2100g() {
		return vitB2100g;
	}
	public void setVitB2100g(double vitB2100g) {
		this.vitB2100g = vitB2100g;
	}
	public double getVitPP100g() {
		return vitPP100g;
	}
	public void setVitPP100g(double vitPP100g) {
		this.vitPP100g = vitPP100g;
	}
	public double getVitB6100g() {
		return vitB6100g;
	}
	public void setVitB6100g(double vitB6100g) {
		this.vitB6100g = vitB6100g;
	}
	public double getVitB9100g() {
		return vitB9100g;
	}
	public void setVitB9100g(double vitB9100g) {
		this.vitB9100g = vitB9100g;
	}
	public double getVitB1200g() {
		return vitB1200g;
	}
	public void setVitB1200g(double vitB1200g) {
		this.vitB1200g = vitB1200g;
	}
	public double getCalcium100g() {
		return calcium100g;
	}
	public void setCalcium100g(double calcium100g) {
		this.calcium100g = calcium100g;
	}
	public double getMagnesium100g() {
		return magnesium100g;
	}
	public void setMagnesium100g(double magnesium100g) {
		this.magnesium100g = magnesium100g;
	}
	public double getIron100g() {
		return iron100g;
	}
	public void setIron100g(double iron100g) {
		this.iron100g = iron100g;
	}
	
	public double getFer100g() {
		return fer100g;
	}
	public void setFer100g(double fer100g) {
		this.fer100g = fer100g;
	}
	public double getBetaCarotene100g() {
		return betaCarotene100g;
	}
	public void setBetaCarotene100g(double betaCarotene100g) {
		this.betaCarotene100g = betaCarotene100g;
	}
	public boolean getPresenceHuilePalme() {
		return presenceHuilePalme;
	}
	public void setPresenceHuilePalme(boolean presenceHuilePalme) {
		this.presenceHuilePalme = presenceHuilePalme;
	}

	@Override
	public String toString() {
		return "Nutriment [energie100g=" + energie100g + ", graisse100g=" + graisse100g + ", sucres100g=" + sucres100g
				+ ", fibres100g=" + fibres100g + ", proteines100g=" + proteines100g + ", sel100g=" + sel100g
				+ ", vitA100g=" + vitA100g + ", vitD100g=" + vitD100g + ", vitE100g=" + vitE100g + ", vitK100g="
				+ vitK100g + ", vitC100g=" + vitC100g + ", vitB1100g=" + vitB1100g + ", vitB2100g=" + vitB2100g
				+ ", vitPP100g=" + vitPP100g + ", vitB6100g=" + vitB6100g + ", vitB9100g=" + vitB9100g + ", vitB1200g="
				+ vitB1200g + ", calcium100g=" + calcium100g + ", magnesium100g=" + magnesium100g + ", iron100g="
				+ iron100g + ", fer100g=" + fer100g + ", betaCarotene100g=" + betaCarotene100g + ", presenceHuilePalme="
				+ presenceHuilePalme + "]";
	}
	
	
}
