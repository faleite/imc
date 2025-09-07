package com.faleite.imc.service;

import com.faleite.imc.dto.ImcRequest;
import com.faleite.imc.dto.ImcResponse;
import com.faleite.imc.storage.LastResultStorage;
import com.faleite.imc.util.ImcCalculator;
import org.springframework.stereotype.Service;

@Service
public class ImcService {

    private final LastResultStorage lastResultStorage;

    public ImcService(LastResultStorage lastResultStorage) {
        this.lastResultStorage = lastResultStorage;
    }

    public ImcResponse calculateIMC(ImcRequest request){
        double alturaCm = ImcCalculator.calcularAlturaCm(request.altura());
        double pesoIdeal = ImcCalculator.calcularPesoIdeal(alturaCm, request.peso());
        double imc = ImcCalculator.calcularIMC(request.altura(), request.peso());
        String interpretacao = ImcCalculator.interpretarIMC(imc);

        ImcResponse response = new ImcResponse(imc, interpretacao, pesoIdeal, alturaCm);
        lastResultStorage.saveResult(response);
        return response;
    }

    public ImcResponse getLastResult(){
        return lastResultStorage.getResult();
    }
}
