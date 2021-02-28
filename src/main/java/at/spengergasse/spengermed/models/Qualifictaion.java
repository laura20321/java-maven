package at.spengergasse.spengermed.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Table(name="q_qualification")
public class Qualifictaion extends BackboneElement{
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "i_bbe_fk", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "q_code", referencedColumnName = "id")
    private List<CodeableConcept> code = new ArrayList<>();

    @Embedded
    private Period period;
}
