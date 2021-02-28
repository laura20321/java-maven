package at.spengergasse.spengermed.models;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
@Entity
@NoArgsConstructor
@Setter@Getter
@AllArgsConstructor
@Table (name="p_patient")
@Builder
public class Patient extends DomainResource{
    public enum GenderCode{
        male, female, other, unknown
    }
    @Enumerated(EnumType.STRING)
    @Column(name="p_gender")
    private GenderCode gender;

    @Column(name="p_birthdate")
    private LocalDate birthDate;

    @Column(name="p_active")
    private boolean active;

    @Column(name="p_deceasedboolean")
    private boolean deceasedBoolean;

    @Column(name="p_deceaseddatetime")
    private LocalDate deceasedDateTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "i_p_fk", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hn_patient_fk", referencedColumnName = "id")
    private List<HumanName> name = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_p_id", referencedColumnName = "id")
    private List<ContactPoint> telecom = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "a_patient_fk", referencedColumnName = "id")
    private List<Address> address = new ArrayList<>();

}
