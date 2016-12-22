package tma.com.vn.movie.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

/**
 * Created by nguyenquocduy on 12/22/16.
 */
@Entity
@Table(name = "timeslot")
public class Timeslot {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "start_time")
    @Size(min = 1, max = 5)
    private String startTime;

    @NotNull
    @Column(name = "end_time")
    @Size(min = 1, max = 5)
    private String endTime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeslot")
    private Collection<ShowTiming> showTimings;

    public Timeslot() {
    }

    public Timeslot(Integer id) {
        this.id = id;
    }

    public Timeslot(Integer id, String startTime, String endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
        if (!(object instanceof Timeslot)) {
            return false;
        }
        Timeslot other = (Timeslot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return startTime;
    }
}
