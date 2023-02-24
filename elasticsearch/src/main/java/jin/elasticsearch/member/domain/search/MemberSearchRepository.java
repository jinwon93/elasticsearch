package jin.elasticsearch.member.domain.search;


import jin.elasticsearch.member.domain.MemberDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberSearchRepository extends ElasticsearchRepository<MemberDocument , Long> {

    List<MemberDocument> findByAge(int age);

    List<MemberDocument> findByNickname(String nickname , Pageable pageable);
}
