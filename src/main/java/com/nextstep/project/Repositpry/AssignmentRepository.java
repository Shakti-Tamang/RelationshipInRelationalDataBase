package com.nextstep.project.Repositpry;

import com.nextstep.project.model.AssignmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentModel,Integer> {
}
