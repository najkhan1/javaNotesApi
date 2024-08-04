package com.najkhan.javaNotesApi.model;

import com.najkhan.javaNotesApi.model.Status;
import lombok.Data;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Persistent
@Table
public class HealthCheckTable {
    @PrimaryKey
    private final String id;
    @CassandraType(type = CassandraType.Name.TEXT)
    private final Status status;
}

