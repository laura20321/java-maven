package at.spengergasse.spengermed.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="cc_codeableconcept")
public class CodeableConcept extends Element {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_cc_id", referencedColumnName = "id")
    private List<Coding> coding;

    @Column(name = "cc_text")
    private String text;
}
