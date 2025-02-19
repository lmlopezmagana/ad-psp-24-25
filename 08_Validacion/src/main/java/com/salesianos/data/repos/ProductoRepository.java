package com.salesianos.data.repos;

import com.salesianos.data.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductoRepository
        extends JpaRepository<Producto, Long>,
        JpaSpecificationExecutor<Producto> {
}
