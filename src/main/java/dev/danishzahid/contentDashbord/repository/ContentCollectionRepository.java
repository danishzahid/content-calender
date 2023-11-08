package dev.danishzahid.contentDashbord.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.danishzahid.contentDashbord.model.Content;
import dev.danishzahid.contentDashbord.model.Status;
import dev.danishzahid.contentDashbord.model.Type;
import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;


@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    private void init(){
        Content content = new Content(01, "Blog", "blog", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, "");

        contentList.add(content);

    }

    
    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }


}
