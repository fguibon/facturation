package com.ekwateur.client.facturation.model.client;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Professionnel extends Client {

    private String siret;
    private String raison;
    private Long chiffreAffaire;

    public Professionnel(String reference, String siret, String raison, Long chiffreAffaire) {
        super(reference);
        this.siret = siret;
        this.raison = raison;
        this.chiffreAffaire = chiffreAffaire;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public Long getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(Long chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Professionnel that = (Professionnel) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(siret, that.siret).append(raison, that.raison).append(chiffreAffaire, that.chiffreAffaire).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(siret).append(raison).append(chiffreAffaire).toHashCode();
    }
}
