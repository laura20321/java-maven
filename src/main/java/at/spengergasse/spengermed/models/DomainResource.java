package at.spengergasse.spengermed.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class DomainResource extends Resource{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dr_n_id", referencedColumnName = "id")
    private Narrative text;
}
