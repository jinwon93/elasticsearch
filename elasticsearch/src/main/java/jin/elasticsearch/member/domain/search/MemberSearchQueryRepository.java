package jin.elasticsearch.member.domain.search;



import jin.elasticsearch.config.ElasticsearchOperations;
import jin.elasticsearch.member.domain.MemberDocument;
import jin.elasticsearch.member.presentation.dto.SearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;

import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;


import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MemberSearchQueryRepository {

    private final ElasticsearchOperations operations;


    public List<MemberDocument> findByCondition(SearchCondition searchCondition, Pageable pageable) {
        CriteriaQuery query = createConditionCriteriaQuery(searchCondition).setPageable(pageable);

        SearchHits<MemberDocument> search = operations.search(query, MemberDocument.class);
        return search.stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }


    private CriteriaQuery createConditionCriteriaQuery(SearchCondition searchCondition) {
        CriteriaQuery query = new CriteriaQuery(new Criteria());

        if (searchCondition == null)
            return query;

        if (searchCondition.getId() != null)
            query.addCriteria(Criteria.where("id").is(searchCondition.getId()));

        if(searchCondition.getAge() > 0)
            query.addCriteria(Criteria.where("age").is(searchCondition.getAge()));

        if(StringUtils.hasText(searchCondition.getName()))
            query.addCriteria(Criteria.where("name").is(searchCondition.getName()));

        if(StringUtils.hasText(searchCondition.getNickname()))
            query.addCriteria(Criteria.where("nickname").is(searchCondition.getNickname()));

        if(searchCondition.getZoneId() != null)
            query.addCriteria(Criteria.where("zone.id").is(searchCondition.getZoneId()));

        if(searchCondition.getStatus() != null)
            query.addCriteria(Criteria.where("status").is(searchCondition.getStatus()));

        return query;
    }




}

