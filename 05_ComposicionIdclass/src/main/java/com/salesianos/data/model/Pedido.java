package com.salesianos.data.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    @Builder.Default
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private String cliente;

    @OneToMany(
            mappedBy = "pedido",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private List<LineaPedido> lineasPedido = new ArrayList<>();

    // Helpers

    public void addLineaPedido(LineaPedido lineaPedido) {
        lineasPedido.add(lineaPedido);
        lineaPedido.setPedido(this);
    }

    public void removeLineaPedido(LineaPedido lineaPedido) {
        lineasPedido.remove(lineaPedido);
        //lineaPedido.setPedido(null); // No es necesaria gracias a orphanRemoval
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Pedido pedido = (Pedido) o;
        return getId() != null && Objects.equals(getId(), pedido.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
