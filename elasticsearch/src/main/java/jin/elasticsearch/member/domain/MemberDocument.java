package jin.elasticsearch.member.domain;


import ch.qos.logback.core.status.Status;
import jakarta.persistence.Id;
import jin.elasticsearch.zone.Zone;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(indexName = "member")
@Mapping(mappingPath = "elastic/member-mapping.json")
@Setting(settingPath = "elastic/member-setting.json")
public class MemberDocument {


    @Id
    private Long id;

    private String name;

    private String nickname;

    private int age;

    private MemberStatus status;

    private Zone zone;

    private String description;

    @Field(type = FieldType.Date, format = {DateFormat.date_hour_minute_second_millis, DateFormat.epoch_millis)
    private LocalDateTime createdAt;

    public static MemberDocument from(Member member){
        return MemberDocument.builder()
                .id(member.getId())
                .name(member.getName())
                .nickname(member.getNickname())
                .age(member.getAge())
                .status(member.getStatus())
                .zone(member.getZone())
                .description(member.getDescription())
                .createdAt(member.getCreateAt())
                .build();
    }
}
