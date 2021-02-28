package at.spengergasse.spengermed.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="at_attachment")
public class Attachment extends Element{
    public enum ContentCode{
        image, applicaion, multipart,message, audio, video, text, unknown, other
    }
    @Enumerated(EnumType.STRING)
    @Column(name="at_contenttype")
    private ContentCode contenttype;
    @Column(name="at_code")
    private LocalDate deceaseDateTime;
    public enum LanguageCode{
        ar("ar"), bn("bn"), cs("cs"), da("da"), de("de"), deat("de-AT"), dech("de-CH"), dede("de-DE"), el("el"), en("en"), enau("en-AU"), enca("en-CA"), engb("en-GB"), enin("en-IN"), ennz("en-NZ"), ensg("en-SG"), enus("en-US"), es("es"), esar("es-AR"), eses("es-ES"), esuy("es-UY"), fi("fi"), fr("fr"), frbe("fr-BE"), frch("fr-CH"), frfr("fr-FR"), fy("fy"), fynl("fy-NL"), hi("hi"), hr("hr"), it("it"), itch("it-CH"), itit("it-IT"), ja("ja"), ko("ko"), nl("nl"), nlbe("nl-BE"), nlnl("nl-NL"), no("no"), nono("no-NO"), pa("pa"), pl("pl"), pt("pt"), ptbr("pt-BR"), ru("ru"), ruru("ru-RU"), sr("sr"), srrs("sr-RS"), sv("sv"), svse("sv-SE"), te("te"), zh("zh"), zhch("zh-CH"), zhhk("zh-HK"), zhsg("sh-SG"), zhtw("zh-TW");

        private String value;

        private LanguageCode(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }

    }
    @Enumerated(EnumType.STRING)
    @Column(name="at_language")
    private LanguageCode language;

    @Column(name="at_title")
    private String title;

    @Column(name="at_url")
    private String url;

    @Column(name="at_data")
    private String data;

    @Column(name="at_hash")
    private String hash;

    @Column(name="at_size")
    private int size;

    @Column(name="at_creation")
    private LocalDate creation;


}
