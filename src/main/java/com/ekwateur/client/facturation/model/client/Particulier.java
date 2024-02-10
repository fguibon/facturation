package com.ekwateur.client.facturation.model.client;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Particulier extends Client {
    private Civilite civilite;

    private String prenom;

    private String nom;

    public Particulier(String reference, Civilite civilite, String prenom, String nom) {
        super(reference);
        this.civilite = civilite;
        this.prenom = prenom;
        this.nom = nom;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Particulier that = (Particulier) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(civilite, that.civilite).append(prenom, that.prenom).append(nom, that.nom).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(civilite).append(prenom).append(nom).toHashCode();
    }
}
