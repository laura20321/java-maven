package at.spengergasse.spengermed.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="c_coding")
public class Coding extends Element{
    @Column(name = "c_system")
    private String system;
    @Column(name = "c_version")
    private String version;
    @Column(name = "c_code")
    private String code;
    @Column(name = "c_display")
    private String display;
    @Column(name = "c_userSelected")
    private boolean userSelected;
}
