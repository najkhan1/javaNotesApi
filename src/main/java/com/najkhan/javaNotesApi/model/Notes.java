package com.najkhan.javaNotesApi.model;

import com.najkhan.javaNotesApi.model.responses.NoNoteResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Builder
@Table
public class Notes {
    @PrimaryKeyColumn(
            name = "email",
            ordinal = 1,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING)
    private String email;

    @PrimaryKeyColumn(
            name = "title",
            ordinal = 2,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING)
    private String title;

    private String note;
}
