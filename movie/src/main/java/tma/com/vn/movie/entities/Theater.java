package tma.com.vn.movie.entities;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by nguyenquocduy on 12/22/16.
 */
@Entity
@Table(name = "theater")
public class Theater {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "capacity")
    private int capacity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theater")
    private Collection<ShowTiming> showTimings;

    public Theater() {
    }

    public Theater(Integer id) {
        this.id = id;
    }

    public Theater(Integer id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

//    @XmlTransient
    public Collection<ShowTiming> getShowTimings() {
        return showTimings;
    }

    public void setShowTimings(Collection<ShowTiming> showTimings) {
        this.showTimings = showTimings;
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
        if (!(object instanceof Theater)) {
            return false;
        }
        Theater other = (Theater) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Theater[id=" + id + "]";
    }
}
