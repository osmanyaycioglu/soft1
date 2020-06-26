package soft.train.spring.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "adres")
public class Address {

    @Id
    @GeneratedValue
    private long addressId;

    @Column(name = "sehir",
            length = 50)
    private String city;
    private String town;
    private String addressDesc;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,
               cascade = { CascadeType.ALL })
    @JoinColumn(name = "kisi_id")
    private Person person;

    public String getCity() {
        return this.city;
    }

    public void setCity(final String cityParam) {
        this.city = cityParam;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(final String townParam) {
        this.town = townParam;
    }

    public String getAddressDesc() {
        return this.addressDesc;
    }

    public void setAddressDesc(final String addressDescParam) {
        this.addressDesc = addressDescParam;
    }

    public long getAddressId() {
        return this.addressId;
    }

    public void setAddressId(final long addressIdParam) {
        this.addressId = addressIdParam;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(final Person personParam) {
        this.person = personParam;
    }
}
