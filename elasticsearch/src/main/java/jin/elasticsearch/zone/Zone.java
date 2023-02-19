package jin.elasticsearch.zone;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Zone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mainZone;

    private String subZone;



    public static Zone of(String mainZone, String subZone){
        return Zone.builder()
                .mainZone(mainZone)
                .subZone(subZone)
                .build();
    }

}
