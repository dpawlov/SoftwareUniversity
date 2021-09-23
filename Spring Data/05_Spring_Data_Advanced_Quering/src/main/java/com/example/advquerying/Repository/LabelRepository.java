package com.example.advquerying.Repository;

import com.example.advquerying.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Long> {
    // works as findById but does not return Optional , but Label, what we need
    Label findOneById(Long id);
}
