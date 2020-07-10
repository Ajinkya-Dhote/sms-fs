package in.ajinkyadhote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ajinkyadhote.model.SmsData;

public interface SmsDataRepository extends JpaRepository<SmsData, Integer>{

}
