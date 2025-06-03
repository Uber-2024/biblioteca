package com.utorresa.biblioteca.models.dto;
import java.time.LocalDate;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Schema(description = "Esta es la solicitud para crear o actualizar un libro")
@Data
public class BookRequest {
    @Schema(description = "Título del libro", example = "El Señor de los Anillos")
    @NotBlank
    private String title;

    @Schema(description = "Autor del libro", example = "J.R.R. Tolkien")
    @NotBlank
    private String author;

    @Schema(description = "ISBN del libro", example = "978-1234567890")
    @NotBlank
    private String isbn;

    @Schema(description = "Género literario del libro", example = "Novela")
    @NotBlank
    private String genre;

    @Schema(description = "Fecha de publicación del libro", example = "1954-07-29")
    @NotNull
    private LocalDate publishedDate;

    @Schema(description = "Estado del libro", example = "AVAILABLE")
    @NotNull
    private String status;

    public enum Status {
        AVAILABLE,
        BORROWED,
        RESERVED
    }
}
