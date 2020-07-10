package in.ajinkyadhote.service;

import java.util.List;
import java.util.Optional;

import in.ajinkyadhote.model.SmsData;

public interface SmsService {
	
	List<SmsData> findAll();
	
	Optional<SmsData> find(Integer id);

	SmsData add(SmsData data);

	List<SmsData> add(List<SmsData> data);



}
