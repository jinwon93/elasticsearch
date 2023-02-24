package jin.elasticsearch.member.domain.search;

import jin.elasticsearch.member.domain.Member;
import jin.elasticsearch.member.domain.MemberDocument;
import jin.elasticsearch.member.domain.MemberStatus;
import jin.elasticsearch.zone.Zone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.assertj.core.api.Assertions.*;



@SpringBootTest
class MemberSearchQueryRepositoryTest {



    @Autowired
    MemberSearchRepository memberSearchRepository;


    @Test
    void test() throws Exception{
        //given
        MemberDocument memberDocument = MemberDocument.from(
                Member.builder()
                        .id(1L)
                        .name("choi")
                        .nickname("backtony")
                        .age(27)
                        .status(MemberStatus.WAIT)
                        .zone(Zone.builder().id(1L).mainZone("경기도").subZone("안양시").build())
                        .build());

        //when
        memberSearchRepository.save(memberDocument);

        //then
        MemberDocument result = memberSearchRepository.findById(1L).get();
        assertThat(result.getId()).isEqualTo(memberDocument.getId());


}