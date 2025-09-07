package com.faleite.imc.storage;

import com.faleite.imc.dto.ImcResponse;
import org.springframework.stereotype.Component;

@Component
public class LastResultStorage {

    private ImcResponse lastResult;

    public void saveResult(ImcResponse response){
        this.lastResult = response;
    }

    public ImcResponse getResult(){
        return lastResult;
    }
}
