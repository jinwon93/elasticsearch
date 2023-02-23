package jin.elasticsearch.member.presentation.dto;


import jin.elasticsearch.member.domain.MemberStatus;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class SearchCondition {


    private Long id;

    private  String name;

    private String nickname;

    private int age;

    private MemberStatus status;

    private  Long zoneId;
}
