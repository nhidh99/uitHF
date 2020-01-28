package tacos.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Entity
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(name = "delivery_name")
    private String name;

    @NotBlank(message = "Street is required")
    @Column(name = "delivery_street")
    private String street;

    @NotBlank(message = "City is required")
    @Column(name = "delivery_city")
    private String city;

    @NotBlank(message = "State is required")
    @Column(name = "delivery_state")
    private String state;

    @NotBlank(message = "Zip code is required")
    @Column(name = "delivery_zip")
    private String zip;

    @CreditCardNumber(message = "Not a valid card number")
    @Column(name = "cc_number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Must be formatted MM/YY")
    @Column(name = "cc_expiration")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    @Column(name = "cc_cvv")
    private String ccCVV;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "taco_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "taco_id"))
    private List<Taco> tacos;
}