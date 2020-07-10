package in.ajinkyadhote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ajinkyadhote.model.SmsData;
import in.ajinkyadhote.repository.SmsDataRepository;

@Service
public class SmsServiceImpl implements SmsService {
	
	@Autowired
	private SmsDataRepository repository;
	
	@Override
	public List<SmsData> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Optional<SmsData> find(Integer id) {
		return repository.findById(id);
	}

	@Override
	public SmsData add(SmsData data) {
		return repository.save(data);
	}

	@Override
	public List<SmsData> add(List<SmsData> data) {
		return repository.saveAll(data);
	}

	@Override
	public SmsData update(SmsData data) {
		SmsData tempData = repository.getOne(data.getId());
		tempData.setCity(data.getCity());
		tempData.setColor(data.getColor());
		tempData.setPrice(data.getPrice());
		tempData.setStartDate(data.getStartDate());
		tempData.setEndDate(data.getEndDate());
		return repository.save(tempData);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
