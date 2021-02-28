package at.spengergasse.spengermed.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="n_narrative")
public class Narrative extends Element{

    public enum NarrativeCode{
        generated , extensions , additional , empty
    }
    @Column(name="n_status")
    private NarrativeCode status;

    @Column(name="n_div")
    private  String div;

}
