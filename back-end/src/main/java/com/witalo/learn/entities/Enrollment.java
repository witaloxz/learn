package com.witalo.learn.entities;

import com.witalo.learn.entities.pk.EnrollmentPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrolMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refundMoment;
    private Boolean available;
    private Boolean onlyUpdate;

    public Enrollment() {
    }

    public Enrollment(User user, Offer offer, Boolean onlyUpdate, Boolean available, Instant refundMoment, Instant enrolMoment) {
        id.setUser(user);
        id.setOffer(offer);
        this.onlyUpdate = onlyUpdate;
        this.available = available;
        this.refundMoment = refundMoment;
        this.enrolMoment = enrolMoment;
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

    public Instant getEnrolMoment() {
        return enrolMoment;
    }

    public void setEnrolMoment(Instant enrolMoment) {
        this.enrolMoment = enrolMoment;
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
}
