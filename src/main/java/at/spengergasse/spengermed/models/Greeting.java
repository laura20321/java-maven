package at.spengergasse.spengermed.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private  String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

}
