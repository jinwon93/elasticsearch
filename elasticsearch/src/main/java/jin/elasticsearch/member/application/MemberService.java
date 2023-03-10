package jin.elasticsearch.member.application;


import jin.elasticsearch.member.domain.Member;
import jin.elasticsearch.member.domain.MemberDocument;
import jin.elasticsearch.member.domain.MemberRepository;
import jin.elasticsearch.member.domain.search.MemberSearchQueryRepository;
import jin.elasticsearch.member.domain.search.MemberSearchRepository;
import jin.elasticsearch.member.presentation.dto.MemberResponse;
import jin.elasticsearch.member.presentation.dto.MemberSaveAllRequest;
import jin.elasticsearch.member.presentation.dto.SearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {


    private final MemberRepository memberRepository;
    private final MemberSearchRepository memberSearchRepository;
    private final MemberSearchQueryRepository memberSearchQueryRepository;


    @Transactional
    public void saveAllMember(MemberSaveAllRequest memberSaveAllRequest) {
        List<Member> memberList =
                memberSaveAllRequest.getMemberSaveRequests().stream().map(Member::from).collect(Collectors.toList());
        memberRepository.saveAll(memberList);
    }


    @Transactional
    public  void  saveAllMemberDocuments() {
        List<MemberDocument> memberDocumentList
                = memberRepository.findAll().stream().map(MemberDocument::from).collect(Collectors.toList());
        memberSearchRepository.saveAll(memberDocumentList);
    }

    public List<MemberResponse> findByNickname(String nickname , Pageable pageable) {
        return memberSearchRepository.findByNickname(nickname , pageable)
                .stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }


    public List<MemberResponse> findByAge(int age) {
        return memberSearchRepository.findByAge(age)
                .stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }


    public List<MemberResponse> searchByCondition(SearchCondition searchCondition, Pageable pageable) {
        return memberSearchQueryRepository.findByCondition(searchCondition , pageable)
                .stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }


    public List<MemberResponse> findByStarWithNickname(String nickname, Pageable pageable) {
        return memberSearchQueryRepository.findByStartWithNickname(nickname , pageable)
                .stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }

    public List<MemberResponse> findByMatchesDescription(String description, Pageable pageable) {
        return memberSearchQueryRepository.findByMatchesDescription(description , pageable)
                .stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }


    public List<MemberResponse> findByContainsDescription(String description, Pageable pageable) {
        return memberSearchQueryRepository.findByContainsDescription(description , pageable)
                .stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }
}
