package in.ajinkyadhote.service;

import java.util.List;

import in.ajinkyadhote.model.SmsData;

public interface SmsService {

	SmsData add(SmsData data);

	List<SmsData> add(List<SmsData> data);

}
