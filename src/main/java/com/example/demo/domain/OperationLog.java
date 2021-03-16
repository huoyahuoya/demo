package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "OperationLog")
public class OperationLog {
    @Id
    @Column(length = 10)
    @SequenceGenerator(name = "operationLog", sequenceName = "SZ_OPERATION_LOG_SEQUENCE", allocationSize = 1,initialValue = 1)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ops_time", nullable = false)
    private Date opsTime = new Date();

    @Column(name = "str")
    private String str;

}
