package in.ajinkyadhote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ajinkyadhote.model.SmsData;
import in.ajinkyadhote.repository.SmsDataRepository;

@Service
public class SmsServiceImpl implements SmsService {
	
	@Autowired
	private SmsDataRepository repository;

	@Override
	public SmsData add(SmsData data) {
		return repository.save(data);
	}

	@Override
	public List<SmsData> add(List<SmsData> data) {
		return repository.saveAll(data);
	}

}
