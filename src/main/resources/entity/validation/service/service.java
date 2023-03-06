package entity.validation.service;

import com.example.entity.ProductEntity;
import com.example.exception.NotFoundException;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

public class service implements service {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity getByID(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id " + id));
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductEntity update(ProductEntity productEntity) {
        ProductEntity existingProduct = productRepository.findById(productEntity.getId())
                .orElseThrow(() -> new NotFoundException("Product not found with id " + productEntity.getId()));

        existingProduct.setName(productEntity.getName());
        existingProduct.setDescription(productEntity.getDescription());
        existingProduct.setStock(productEntity.getStock());
        existingProduct.setPrice(productEntity.getPrice());

        return productRepository.save(existingProduct);
    }
}
