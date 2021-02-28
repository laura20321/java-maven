package at.spengergasse.spengermed.models;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table (name="pro_procedure")
public class Procedure extends DomainResource{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "i_pro_fk", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<>();

    public enum StatusCode{
        preparation("preparation"), inprogress("in-progress"), notdone("not-done"), onhold("on-hold"), stopped("stopped"), completed("completed"), enteredinerror("entered-in-error"), unknown("unknown");
        private String value;

        private StatusCode(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }
    @Enumerated(EnumType.STRING)
    @Column(name="pro_status")
    private StatusCode status;


    @Column(name="pro_statusWhy")
    private String statusWhy; //Kein CC weil ich es nicht geschafft habe keine Fehler zu bekommen....

    @Column(name="pro_performedAge")
    private LocalDate performedAge;

    @Column(name="pro_performedRange")
    private int performedRange;
}
