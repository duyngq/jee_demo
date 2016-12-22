package tma.com.vn.movie.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by nguyenquocduy on 12/22/16.
 */
@Entity
@Table(name = "movies")
public class Movie implements Serializable {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 50)

    @Column(name = "name")
    private String name;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "actors")
    private String actors;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private Collection<ShowTiming> showTimings;

    public Movie() {
    }

    public Movie(Integer id) {
        this.id = id;
    }

    public Movie(Integer id, String name, String actors) {
        this.id = id;
        this.name = name;
        this.actors = actors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
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
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
