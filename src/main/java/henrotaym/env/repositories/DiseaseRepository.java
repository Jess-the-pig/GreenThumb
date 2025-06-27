package henrotaym.env.repositories;

import henrotaym.env.entities.Disease;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, BigInteger> {}
