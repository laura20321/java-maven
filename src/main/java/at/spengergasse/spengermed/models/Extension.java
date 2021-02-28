package at.spengergasse.spengermed.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="e_extension")
public class Extension extends Element{

    @Column(name="e_url")
    private String url;
    @Column(name="e_value")
    private String value;
}
