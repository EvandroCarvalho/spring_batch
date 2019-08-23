package com.spring.batch.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.spring.batch.Model.CepResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ServiceCep {
  private final String urlService = "https://viacep.com.br/ws/{cep}/json/";
  @Autowired
  private final RestTemplate restTemplate;
  private List<String> ceps = Arrays.asList("38400322", "38425381");

  public List<CepResponse> getCepDetails() {
    log.info("##Chamando serviço");
    return ceps.stream().map(cep -> CallViaCepService(cep)).collect(Collectors.toList());
  }

  private CepResponse CallViaCepService(String cep) {
    CepResponse cepResponseModel = null;
    try {
    ResponseEntity<CepResponse> response = restTemplate.getForEntity(urlService, CepResponse.class, cep);
    cepResponseModel = response.getBody();
    log.info("###Sucesso na consulta");
    } catch (Exception e) {
      log.info("###Houve um erro na consulta: \n" + e.getMessage());
    }
    return cepResponseModel;
  }

}
