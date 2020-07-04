package com.josh.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode
public class TransactionDetails implements Serializable {

    private static final long serialVersionUID = 2152764460241618790L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;

    @NotEmpty(message= "The  name must not be null")
    private String name;
    @NotEmpty(message= "The  email must not be null")
    private String email;
    @NotEmpty(message= "The  phoneNo must not be null")
    private String phoneNo;
    private String currency;
    @NotEmpty(message= "The  Amount must not be null")
    private String Amount;
    @NotEmpty(message= "The  description must not be null")
    private String description;
    private String redirectUrl;
    private String webhookUrl;

}
