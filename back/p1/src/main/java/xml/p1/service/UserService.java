package xml.p1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xml.p1.dto.KorisnikDTO;

@Service
public class UserService {


    @Autowired
    private RestTemplate restTemplate;

    public boolean authorizeUser(String token, boolean shouldBeSluzbenik) throws Exception {
        final String uri = "http://localhost:8089/auth/get/" + token;
        ResponseEntity<KorisnikDTO> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        KorisnikDTO korisnikDTO = responseEntity.getBody();
        if (korisnikDTO != null) {
            return korisnikDTO.isSluzbenik() == shouldBeSluzbenik;
        }
        throw new Exception("Session ended!");
    }

}
