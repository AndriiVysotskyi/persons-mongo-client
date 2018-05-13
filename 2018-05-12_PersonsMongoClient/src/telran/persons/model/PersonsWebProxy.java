package telran.persons.model;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import telran.persons.api.PersonsApiConstants;
import telran.persons.dao.IPersonsDao;
import telran.persons.dto.NamesBox;
import telran.persons.dto.Person;

public class PersonsWebProxy implements IPersonsDao {
	RestTemplate restTemplate = new RestTemplate();
	String url;
	HttpHeaders headers = new HttpHeaders();

	public PersonsWebProxy(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HttpHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}

	@Override
	public boolean addPerson(Person person) {
		HttpEntity<Person> postEntity = new HttpEntity<>(person, headers);
		ResponseEntity<Boolean> response = restTemplate.exchange(url + PersonsApiConstants.ADD_PERSON, HttpMethod.POST,
				postEntity, Boolean.class);
		return response.getBody();
	}

	@Override
	public Person getPerson(int id) {
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Person> response = restTemplate.exchange(url + PersonsApiConstants.GET_PERSON + "?" + "id=" + id,
				HttpMethod.GET, requestEntity, Person.class);
		return response.getBody();
	}

	@Override
	public boolean updateName(int id, String newName) {
		HttpEntity<NamesBox> postEntity = new HttpEntity<NamesBox>(new NamesBox(id, newName), headers);
		ResponseEntity<Boolean> response = restTemplate.exchange(url + PersonsApiConstants.UPDATE_NAME, HttpMethod.POST,
				postEntity, Boolean.class);
		return response.getBody();
	}

	@Override
	public boolean removePerson(int id) {
		HttpEntity<Integer> postEntity = new HttpEntity<Integer>(id, headers);
		ResponseEntity<Boolean> response = restTemplate.exchange(url + PersonsApiConstants.REMOVE_PERSON,
				HttpMethod.POST, postEntity, Boolean.class);
		return response.getBody();
	}

}
