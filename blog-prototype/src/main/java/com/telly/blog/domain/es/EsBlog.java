package com.telly.blog.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Blog 文档.
 */
@Document(indexName = "blog",type = "blog")// 文档
public class EsBlog implements Serializable {
    // 序列化
    private static final long serialVersionUID = 1L;

    // 文章 id
    @Id // 主键
    private String id;
    // 文章标题
    private String title;
    // 文章摘要
    private String summary;
    // 文章内容
    private String content;

    /**
     * 无参构造函数，JPA规范要求，防止直接使用
     */
    protected EsBlog(){
    }

    /**
     * 带参数的构造函数
     * @param title
     * @param summary
     * @param content
     */
    public EsBlog(String title,String summary,String content){
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("EsBlog[id='%s',title='%s',summary='%s',content='%s']",
                id,title,summary,content);
    }
}
