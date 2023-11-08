package dev.danishzahid.contentDashbord.repository;


import org.springframework.data.repository.ListCrudRepository;

import dev.danishzahid.contentDashbord.model.Content;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content,Integer> {

    List<Content> findAllByContentType(String type);
}