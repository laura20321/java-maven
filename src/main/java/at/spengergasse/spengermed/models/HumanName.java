package at.spengergasse.spengermed.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Builder
@AllArgsConstructor
@Table(name="hn_humanname")
public class HumanName  extends Element {
    public enum UseCode {usual, official, temp, nickname, anonymous, old, maiden}

    @Enumerated(EnumType.STRING)
    @Column(name = "hn_use")
    private UseCode use;

    @Column(name = "hn_text")
    private String text;

    @Column(name = "hn_family")
    private String family;

    @ElementCollection
    @CollectionTable(name="g_given_hn", joinColumns = @JoinColumn(name = "id"))
    private List<String> given;

    @ElementCollection
    @CollectionTable(name = "humanname_prefix", joinColumns = @JoinColumn(name = "id"))
    private List<String> prefix;

    @ElementCollection
    @CollectionTable(name = "humanname_surfix", joinColumns = @JoinColumn(name = "id"))
    private List<String> suffix = new ArrayList<>();

    @Embedded
    private Period period;
}