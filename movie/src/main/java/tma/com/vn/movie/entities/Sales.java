package tma.com.vn.movie.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by nguyenquocduy on 12/22/16.
 */
@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "amount")
    private double amount;


    public Sales() {
    }

    public Sales(Integer id) {
        this.id = id;
    }

    public Sales(Integer id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sales[id=" + id + "]";
    }

}
