package ru.gb.gbspringrest.entity;


import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.gb.gbspringrest.entity.enums.Status;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cart")
@EntityListeners(AuditingEntityListener.class)
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name ="cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
