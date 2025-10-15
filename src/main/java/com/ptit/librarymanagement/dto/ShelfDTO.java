package com.ptit.librarymanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShelfDTO {
    private Integer id;

    @NotNull (message = "ShelfName không được để trống!")
    @NotBlank (message = "ShelfName không được để trống!")
    private String shelfName;

    @NotNull (message = "Location không được để trống!")
    @NotBlank (message = "Location không được để trống!")
    private String location;
    private List<BookDTO> books;

    @Override
    public String toString() {
        return this.getShelfName();
    }

    public Object[] getRow () {
        return new Object[] {id, shelfName, location};
    }
}
