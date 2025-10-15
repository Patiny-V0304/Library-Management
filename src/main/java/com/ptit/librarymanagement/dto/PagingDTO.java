package com.ptit.librarymanagement.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PagingDTO {
    private int limit;
    private int offset;

}
