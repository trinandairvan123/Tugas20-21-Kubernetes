package controller;

import com.mafr.productservice.dto.ResponseDTO;
import com.mafr.productservice.entity.ProductEntity;
import com.mafr.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class Controller {
    private final ServiceProduct service;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<ProductEntity>>> getAll() {
        ResponseDTO<List<ProductEntity>> response = new ResponseDTO<>(HttpStatus.OK, service.getAll());
        log.info("Product Success");
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
