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
@Table (name="pr_practitioner")
@Builder
public class Practitioner extends DomainResource{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "i_pr_fk", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<>();

    @Column(name="pr_active")
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hn_pratictioner_fk", referencedColumnName = "id")
    private List<HumanName> name = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_pr_id", referencedColumnName = "id")
    private List<ContactPoint> telecom = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "a_pratictioner_fk", referencedColumnName = "id")
    private List<Address> address = new ArrayList<>();

    public enum GenderCode{
        male, female, other, unknown
    }

    @Enumerated(EnumType.STRING)
    @Column(name="pr_gender")
    private GenderCode gender;

    @Column(name="pr_birthdate")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "at_pratictioner_fk", referencedColumnName = "id")
    private List<Attachment> photo = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "q_pratictioner_fk", referencedColumnName = "id")
    private List<Qualifictaion> qualification = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cc_pratictioner_fk", referencedColumnName = "id")
    private List<CodeableConcept> communication = new ArrayList<>();

}