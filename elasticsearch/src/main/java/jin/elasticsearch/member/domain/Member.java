package jin.elasticsearch.member.domain;


import jakarta.persistence.*;
import jakarta.transaction.Status;
import jdk.jshell.Snippet;
import jin.elasticsearch.datatime.BaseEntity;
import jin.elasticsearch.member.presentation.dto.MemberSaveRequest;
import jin.elasticsearch.zone.Zone;
import lombok.*;
import org.apache.logging.log4j.util.Timer;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nickname;

    private int age;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    private String description;



    public static Member from(MemberSaveRequest memberSaveRequest) {

        return Member.builder()
                .name(memberSaveRequest.getName())
                .nickname(memberSaveRequest.getNickname())
                .age(memberSaveRequest.getAge())
                .status(MemberStatus.WAIT)
                .zone(Zone.builder().id(memberSaveRequest.getZoneId()).build())
                .description(memberSaveRequest.getDescription())
                .build();
    }
}

