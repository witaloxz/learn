package com.witalo.learn.entities;

import com.witalo.learn.entities.pk.EnrollmentPK;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrollMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refundMoment;
    private Boolean available;
    private Boolean onlyUpdate;

    @ManyToMany(mappedBy = "enrollmentsDone")
    private Set<Lesson> lessonsDone = new HashSet<>();

    @OneToMany(mappedBy = "enrollment")
    private List<Deliver> deliveries = new ArrayList<>();

    public Enrollment() {
    }

    public Enrollment(User user, Offer offer, Boolean onlyUpdate, Boolean available, Instant refundMoment, Instant enrolMoment) {
        id.setUser(user);
        id.setOffer(offer);
        this.onlyUpdate = onlyUpdate;
        this.available = available;
        this.refundMoment = refundMoment;
        this.enrollMoment = enrolMoment;
    }

   public User getStudent() {
        return id.getUser();
   }

   public void seStudent(User user){
        id.setUser(user);
   }

   public Offer getOffer(){
        return id.getOffer();
   }

   public void setOffer(Offer offer){
        id.setOffer(offer);
   }

    public Instant getEnrollMoment() {
        return enrollMoment;
    }

    public void setEnrollMoment(Instant enrollMoment) {
        this.enrollMoment = enrollMoment;
    }

    public Instant getRefundMoment() {
        return refundMoment;
    }

    public void setRefundMoment(Instant refundMoment) {
        this.refundMoment = refundMoment;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getOnlyUpdate() {
        return onlyUpdate;
    }

    public void setOnlyUpdate(Boolean onlyUpdate) {
        this.onlyUpdate = onlyUpdate;
    }

    public Set<Lesson> getLessonsDone() {
        return lessonsDone;
    }

    public List<Deliver> getDeliveries() {
        return deliveries;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
