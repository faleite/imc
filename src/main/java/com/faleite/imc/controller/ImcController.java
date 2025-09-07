package com.faleite.imc.controller;

import com.faleite.imc.dto.ImcRequest;
import com.faleite.imc.dto.ImcResponse;
import com.faleite.imc.service.ImcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imc")
public class ImcController {

    private final ImcService imcService;

    public ImcController(ImcService imcService) {
        this.imcService = imcService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<ImcResponse> calculate(@RequestBody ImcRequest request){
        return ResponseEntity.ok(imcService.calculateIMC(request));
    }

    @GetMapping("/last-result")
    public ResponseEntity<ImcResponse> getLastResult(){

        ImcResponse lastResult = imcService.getLastResult();
        if (lastResult == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lastResult);
    }
}
