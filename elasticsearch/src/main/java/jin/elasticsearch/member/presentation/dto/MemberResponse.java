package jin.elasticsearch.member.presentation.dto;


import jin.elasticsearch.member.domain.MemberDocument;
import jin.elasticsearch.member.domain.MemberStatus;
import jin.elasticsearch.zone.Zone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class MemberResponse {


    private Long id;

    private String name;

    private int age;

    private MemberStatus status;

    private Zone zone;

    private String description;

    private LocalDateTime localDateTime;

    public static MemberResponse from(MemberDocument memberDocument) {
        return MemberResponse.builder()
                .id(memberDocument.getId())
                .age(memberDocument.getAge())
                .name(memberDocument.getName())
                .status(memberDocument.getStatus())
                .zone(memberDocument.getZone())
                .description(memberDocument.getDescription())
                .localDateTime(memberDocument.getCreatedAt())
                .build();
    }
}
