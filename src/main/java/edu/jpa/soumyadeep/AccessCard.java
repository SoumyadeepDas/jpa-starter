package edu.jpa.soumyadeep;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate issuedDate;
    private boolean isActive;
    private String firmwareVersion;

    @OneToOne(mappedBy = "accessCard")
    // This annotation indicates that the AccessCard is the inverse side of the relationship.
    // The mappedBy attribute specifies the field in the Employee class that owns the relationship. So JPA doesn't
    // need to fetch the AccessCard again as it is already fetched when the Employee is fetched.
    // This is useful to avoid cyclic dependency and unnecessary database calls.
    private Employee owner;


    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    @Override
    public String toString() {
        return "AccessCard{" +
                "id=" + id +
                ", issuedDate=" + issuedDate +
                ", isActive=" + isActive +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                '}';
    }
}
