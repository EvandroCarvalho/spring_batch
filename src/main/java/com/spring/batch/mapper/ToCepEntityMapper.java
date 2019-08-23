package com.spring.batch.mapper;

import com.spring.batch.Entity.Cep;
import com.spring.batch.Model.CepResponse;

/**
 * @author Evandro Carvalho
 */
public class ToCepEntityMapper {

    public static Cep convertToCep(CepResponse cepResponse) {
        return Cep.builder()
                .bairro(cepResponse.getBairro())
                .cep(cepResponse.getCep())
                .complemento(cepResponse.getComplemento())
                .gia(cepResponse.getGia())
                .ibge(cepResponse.getIbge())
                .localidade(cepResponse.getLocalidade())
                .logradouro(cepResponse.getLogradouro())
                .uf(cepResponse.getUf())
                .unidade(cepResponse.getUnidade())
                .build();
    }
}
