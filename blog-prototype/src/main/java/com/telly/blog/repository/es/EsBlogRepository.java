package com.telly.blog.repository.es;

import com.telly.blog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * EsBlog Repository 接口.
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {
    /**
     * 分页查询博客（去重）
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(
            String title, String summary, String content,
            Pageable pageable);
}
