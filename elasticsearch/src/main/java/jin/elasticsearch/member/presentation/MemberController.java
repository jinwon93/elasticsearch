package jin.elasticsearch.member.presentation;


import jin.elasticsearch.member.application.MemberService;
import jin.elasticsearch.member.presentation.dto.MemberResponse;
import jin.elasticsearch.member.presentation.dto.MemberSaveAllRequest;
import jin.elasticsearch.member.presentation.dto.MemberSaveRequest;
import jin.elasticsearch.member.presentation.dto.SearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {



    private final MemberService memberService;

    public  ResponseEntity<Void> saveAll(@RequestBody MemberSaveAllRequest memberSaveRequest) {
        memberService.saveAllMember(memberSaveRequest);
        return  ResponseEntity.ok().build();

    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>> searchByName(SearchCondition searchCondition , Pageable pageable) {
        return ResponseEntity.ok(memberService.searchByCondition(searchCondition , pageable));
    }

    @GetMapping("/members/nickname/startwith")
    public ResponseEntity<List<MemberResponse>> findByStartWithNickname(@RequestParam String nickname  , Pageable pageable) {
        return ResponseEntity.ok(memberService.findByStarWithNickname(nickname , pageable));
    }
}
