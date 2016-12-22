package tma.com.vn.movie.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by nguyenquocduy on 12/22/16.
 */
@Entity
@Table(name = "showtimings")
public class ShowTiming {
    @Id
    @NotNull
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "day")
    private int day;

    @ManyToOne(optional = false)
    @JoinColumn(name = "timeslot_id", referencedColumnName = "id")
    private Timeslot timeslot;

    @ManyToOne(optional = false)
    @JoinColumn(name = "theater_id", referencedColumnName = "id")
    private Theater theater;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    public ShowTiming() {
    }

    public ShowTiming(Integer id) {
        this.id = id;
    }

    public ShowTiming(Integer id, int day) {
        this.id = id;
        this.day = day;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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
        if (!(object instanceof ShowTiming)) {
            return false;
        }
        ShowTiming other = (ShowTiming) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return movie.getName() + ", " + timeslot.getStartTime();
    }
}
