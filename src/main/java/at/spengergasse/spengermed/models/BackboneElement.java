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
@Builder
@Table(name="bbe_backboneelement")
public class BackboneElement extends Element {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "e_bbe_fk", referencedColumnName = "id")
    private List<Extension> modifierExtension = new ArrayList<>();



}
