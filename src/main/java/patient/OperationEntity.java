package patient;

import javax.persistence.*;

/**
 * Created by SkaaRJ on 12.11.2017.
 */
@Entity
@Table(name = "operation", schema = "perinitial")
public class OperationEntity {
    private int idPatient;
    private String stitches;
    private String hematom;
    private String veins;
    private String fluid;
    private String alien;
    private String stitchesAdd;
    private String hematomAdd;
    private String fluidAdd;
    private String veinsAdd;

    @Id
    @Column(name = "ID_PATIENT")
    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    @Basic
    @Column(name = "Stitches")
    public String getStitches() {
        return stitches;
    }

    public void setStitches(String stitches) {
        this.stitches = stitches;
    }

    @Basic
    @Column(name = "Hematom")
    public String getHematom() {
        return hematom;
    }

    public void setHematom(String hematom) {
        this.hematom = hematom;
    }

    @Basic
    @Column(name = "Veins")
    public String getVeins() {
        return veins;
    }

    public void setVeins(String veins) {
        this.veins = veins;
    }

    @Basic
    @Column(name = "Fluid")
    public String getFluid() {
        return fluid;
    }

    public void setFluid(String fluid) {
        this.fluid = fluid;
    }

    @Basic
    @Column(name = "Alien")
    public String getAlien() {
        return alien;
    }

    public void setAlien(String alien) {
        this.alien = alien;
    }

    @Basic
    @Column(name = "StitchesAdd")
    public String getStitchesAdd() {
        return stitchesAdd;
    }

    public void setStitchesAdd(String stitchesAdd) {
        this.stitchesAdd = stitchesAdd;
    }

    @Basic
    @Column(name = "HematomAdd")
    public String getHematomAdd() {
        return hematomAdd;
    }

    public void setHematomAdd(String hematomAdd) {
        this.hematomAdd = hematomAdd;
    }

    @Basic
    @Column(name = "FluidAdd")
    public String getFluidAdd() {
        return fluidAdd;
    }

    public void setFluidAdd(String fluidAdd) {
        this.fluidAdd = fluidAdd;
    }

    @Basic
    @Column(name = "VeinsAdd")
    public String getVeinsAdd() {
        return veinsAdd;
    }

    public void setVeinsAdd(String veinsAdd) {
        this.veinsAdd = veinsAdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationEntity that = (OperationEntity) o;

        if (idPatient != that.idPatient) return false;
        if (stitches != null ? !stitches.equals(that.stitches) : that.stitches != null) return false;
        if (hematom != null ? !hematom.equals(that.hematom) : that.hematom != null) return false;
        if (veins != null ? !veins.equals(that.veins) : that.veins != null) return false;
        if (fluid != null ? !fluid.equals(that.fluid) : that.fluid != null) return false;
        if (alien != null ? !alien.equals(that.alien) : that.alien != null) return false;
        if (stitchesAdd != null ? !stitchesAdd.equals(that.stitchesAdd) : that.stitchesAdd != null) return false;
        if (hematomAdd != null ? !hematomAdd.equals(that.hematomAdd) : that.hematomAdd != null) return false;
        if (fluidAdd != null ? !fluidAdd.equals(that.fluidAdd) : that.fluidAdd != null) return false;
        if (veinsAdd != null ? !veinsAdd.equals(that.veinsAdd) : that.veinsAdd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPatient;
        result = 31 * result + (stitches != null ? stitches.hashCode() : 0);
        result = 31 * result + (hematom != null ? hematom.hashCode() : 0);
        result = 31 * result + (veins != null ? veins.hashCode() : 0);
        result = 31 * result + (fluid != null ? fluid.hashCode() : 0);
        result = 31 * result + (alien != null ? alien.hashCode() : 0);
        result = 31 * result + (stitchesAdd != null ? stitchesAdd.hashCode() : 0);
        result = 31 * result + (hematomAdd != null ? hematomAdd.hashCode() : 0);
        result = 31 * result + (fluidAdd != null ? fluidAdd.hashCode() : 0);
        result = 31 * result + (veinsAdd != null ? veinsAdd.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OperationEntity{" +
                "idPatient=" + idPatient +
                ", stitches='" + stitches + '\'' +
                ", hematom='" + hematom + '\'' +
                ", veins='" + veins + '\'' +
                ", fluid='" + fluid + '\'' +
                ", alien='" + alien + '\'' +
                ", stitchesAdd='" + stitchesAdd + '\'' +
                ", hematomAdd='" + hematomAdd + '\'' +
                ", fluidAdd='" + fluidAdd + '\'' +
                ", veinsAdd='" + veinsAdd + '\'' +
                '}';
    }
}
