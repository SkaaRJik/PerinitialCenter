package model.patient;

import javax.persistence.*;
import java.sql.Date;

/**
 * Рус:
 * <p>
 * Отображение таблицы 'patient' реляционной базы данных в виде объекта в программе.
 * <p>
 * Eng:
 * <p>
 * Object-relational mapping between database's table 'patient' and this program.
 */
@Entity
@Table(name = "patient", schema = "perinitial")
public class PatientEntity {
    private int id;
    private Date dateDoc;
    private String secondname;
    private int age;
    private Integer mass;
    private Date dateParturion;
    private String firstname;
    private String thirdname;
    private String anamnes;
    private int lenght;
    private int frontBack;
    private int transverse;
    private String state;
    private String contour;
    private String echo;
    private String cavity;
    private String conclusion;
    private String doctor;
    private String uterusPosition;
    private String content;
    private String miometrics;
    private String miometricsAdd;
    private String echoAdd;
    private String contentAdd;
    private String conclusionAdd;
    private String cavityAdd;
    private OperationEntity operationByOperation;

    @Override
    public String toString() {
        return "PatientEntity{" +
                "id=" + id +
                ", dateDoc=" + dateDoc +
                ", secondname='" + secondname + '\'' +
                ", age=" + age +
                ", mass=" + mass +
                ", dateParturion=" + dateParturion +
                ", firstname='" + firstname + '\'' +
                ", thirdname='" + thirdname + '\'' +
                ", anamnes='" + anamnes + '\'' +
                ", lenght=" + lenght +
                ", frontBack=" + frontBack +
                ", transverse=" + transverse +
                ", state='" + state + '\'' +
                ", contour='" + contour + '\'' +
                ", echo='" + echo + '\'' +
                ", cavity='" + cavity + '\'' +
                ", conclusion='" + conclusion + '\'' +
                ", doctor='" + doctor + '\'' +
                ", uterusPosition='" + uterusPosition + '\'' +
                ", content='" + content + '\'' +
                ", miometrics='" + miometrics + '\'' +
                ", miometricsAdd='" + miometricsAdd + '\'' +
                ", echoAdd='" + echoAdd + '\'' +
                ", contentAdd='" + contentAdd + '\'' +
                ", conclusionAdd='" + conclusionAdd + '\'' +
                ", cavityAdd='" + cavityAdd + '\'' +
                ", operationByOperation=" + operationByOperation +
                '}';
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Date_doc")
    public Date getDateDoc() {
        return dateDoc;
    }

    public void setDateDoc(Date dateDoc) {
        this.dateDoc = dateDoc;
    }

    @Basic
    @Column(name = "Secondname")
    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    @Basic
    @Column(name = "Age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "Mass")
    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    @Basic
    @Column(name = "Date_parturion")
    public Date getDateParturion() {

        return dateParturion;
    }

    public void setDateParturion(Date dateParturion) {
        this.dateParturion = dateParturion;
    }

    @Basic
    @Column(name = "Firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "Thirdname")
    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    @Basic
    @Column(name = "Anamnes")
    public String getAnamnes() {
        return anamnes;
    }

    public void setAnamnes(String anamnes) {
        this.anamnes = anamnes;
    }

    @Basic
    @Column(name = "Lenght")
    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    @Basic
    @Column(name = "Front_back")
    public int getFrontBack() {
        return frontBack;
    }

    public void setFrontBack(int frontBack) {
        this.frontBack = frontBack;
    }

    @Basic
    @Column(name = "Transverse")
    public int getTransverse() {
        return transverse;
    }

    public void setTransverse(int transverse) {
        this.transverse = transverse;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "Contour")
    public String getContour() {
        return contour;
    }

    public void setContour(String contour) {
        this.contour = contour;
    }

    @Basic
    @Column(name = "Echo")
    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

    @Basic
    @Column(name = "Cavity")
    public String getCavity() {
        return cavity;
    }

    public void setCavity(String cavity) {
        this.cavity = cavity;
    }

    @Basic
    @Column(name = "Conclusion")
    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Basic
    @Column(name = "Doctor")
    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Basic
    @Column(name = "UterusPosition")
    public String getUterusPosition() {
        return uterusPosition;
    }

    public void setUterusPosition(String uterusPosition) {
        this.uterusPosition = uterusPosition;
    }

    @Basic
    @Column(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "Miometrics")
    public String getMiometrics() {
        return miometrics;
    }

    public void setMiometrics(String miometrics) {
        this.miometrics = miometrics;
    }

    @Basic
    @Column(name = "MiometricsAdd")
    public String getMiometricsAdd() {
        return miometricsAdd;
    }

    public void setMiometricsAdd(String miometricsAdd) {
        this.miometricsAdd = miometricsAdd;
    }

    @Basic
    @Column(name = "EchoAdd")
    public String getEchoAdd() {
        return echoAdd;
    }

    public void setEchoAdd(String echoAdd) {
        this.echoAdd = echoAdd;
    }

    @Basic
    @Column(name = "ContentAdd")
    public String getContentAdd() {
        return contentAdd;
    }

    public void setContentAdd(String contentAdd) {
        this.contentAdd = contentAdd;
    }

    @Basic
    @Column(name = "ConclusionAdd")
    public String getConclusionAdd() {
        return conclusionAdd;
    }

    public void setConclusionAdd(String conclusionAdd) {
        this.conclusionAdd = conclusionAdd;
    }

    @Basic
    @Column(name = "CavityAdd")
    public String getCavityAdd() {
        return cavityAdd;
    }

    public void setCavityAdd(String cavityAdd) {
        this.cavityAdd = cavityAdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientEntity that = (PatientEntity) o;

        if (id != that.id) return false;
        if (age != that.age) return false;
        if (lenght != that.lenght) return false;
        if (frontBack != that.frontBack) return false;
        if (transverse != that.transverse) return false;
        if (dateDoc != null ? !dateDoc.equals(that.dateDoc) : that.dateDoc != null) return false;
        if (secondname != null ? !secondname.equals(that.secondname) : that.secondname != null) return false;
        if (mass != null ? !mass.equals(that.mass) : that.mass != null) return false;
        if (dateParturion != null ? !dateParturion.equals(that.dateParturion) : that.dateParturion != null)
            return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (thirdname != null ? !thirdname.equals(that.thirdname) : that.thirdname != null) return false;
        if (anamnes != null ? !anamnes.equals(that.anamnes) : that.anamnes != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (contour != null ? !contour.equals(that.contour) : that.contour != null) return false;
        if (echo != null ? !echo.equals(that.echo) : that.echo != null) return false;
        if (cavity != null ? !cavity.equals(that.cavity) : that.cavity != null) return false;
        if (conclusion != null ? !conclusion.equals(that.conclusion) : that.conclusion != null) return false;
        if (doctor != null ? !doctor.equals(that.doctor) : that.doctor != null) return false;
        if (uterusPosition != null ? !uterusPosition.equals(that.uterusPosition) : that.uterusPosition != null)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (miometrics != null ? !miometrics.equals(that.miometrics) : that.miometrics != null) return false;
        if (miometricsAdd != null ? !miometricsAdd.equals(that.miometricsAdd) : that.miometricsAdd != null)
            return false;
        if (echoAdd != null ? !echoAdd.equals(that.echoAdd) : that.echoAdd != null) return false;
        if (contentAdd != null ? !contentAdd.equals(that.contentAdd) : that.contentAdd != null) return false;
        if (conclusionAdd != null ? !conclusionAdd.equals(that.conclusionAdd) : that.conclusionAdd != null)
            return false;
        if (cavityAdd != null ? !cavityAdd.equals(that.cavityAdd) : that.cavityAdd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateDoc != null ? dateDoc.hashCode() : 0);
        result = 31 * result + (secondname != null ? secondname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (mass != null ? mass.hashCode() : 0);
        result = 31 * result + (dateParturion != null ? dateParturion.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (thirdname != null ? thirdname.hashCode() : 0);
        result = 31 * result + (anamnes != null ? anamnes.hashCode() : 0);
        result = 31 * result + lenght;
        result = 31 * result + frontBack;
        result = 31 * result + transverse;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (contour != null ? contour.hashCode() : 0);
        result = 31 * result + (echo != null ? echo.hashCode() : 0);
        result = 31 * result + (cavity != null ? cavity.hashCode() : 0);
        result = 31 * result + (conclusion != null ? conclusion.hashCode() : 0);
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (uterusPosition != null ? uterusPosition.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (miometrics != null ? miometrics.hashCode() : 0);
        result = 31 * result + (miometricsAdd != null ? miometricsAdd.hashCode() : 0);
        result = 31 * result + (echoAdd != null ? echoAdd.hashCode() : 0);
        result = 31 * result + (contentAdd != null ? contentAdd.hashCode() : 0);
        result = 31 * result + (conclusionAdd != null ? conclusionAdd.hashCode() : 0);
        result = 31 * result + (cavityAdd != null ? cavityAdd.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Operation", referencedColumnName = "ID_PATIENT")
    public OperationEntity getOperationByOperation() {
        return operationByOperation;
    }

    public void setOperationByOperation(OperationEntity operationByOperation) {
        this.operationByOperation = operationByOperation;
    }
}
