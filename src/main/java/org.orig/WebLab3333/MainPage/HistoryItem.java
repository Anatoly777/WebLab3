package org.orig.WebLab3333.MainPage;


import javax.persistence.*;

@Entity
@Table(name = "shot_history")
public class HistoryItem {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "entity_id_seq"
    )
    @SequenceGenerator(
            name = "entity_id_seq",
            sequenceName = "global_id_sequence",
            allocationSize = 1
    )
    @Column(
            name = "id",
            unique = true,
            updatable = false,
            nullable = false
    )
    private Long id;
    @Column(name="x")
    private Double x;
    @Column(name="y")
    private Double y;
    @Column(name="r")
    private Double r;
    @Column(name="ishit")
    private Boolean isHit;
    @Column(name = "session_id")
    private String sessionId;


    public HistoryItem(String sessionId, Double x, Double y, Double r, Boolean isHit){
        this.x = x;
        this.y = y;
        this.r = r;
        this.isHit = isHit;
        this.sessionId = sessionId;


    }

    public HistoryItem() {

    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Boolean getHit() {
        return isHit;
    }

    public void setHit(Boolean hit) {
        isHit = hit;
    }


}
