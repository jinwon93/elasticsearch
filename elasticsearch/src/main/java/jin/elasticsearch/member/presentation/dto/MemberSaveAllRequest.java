package jin.elasticsearch.member.presentation.dto;


import lombok.Getter;

import java.util.List;

@Getter
public class MemberSaveAllRequest {


    private List<MemberSaveRequest> memberSaveRequests;
}
