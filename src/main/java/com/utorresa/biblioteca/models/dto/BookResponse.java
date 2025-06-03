package com.utorresa.biblioteca.models.dto;

import java.time.LocalDate;

import lombok.Data;
import com.utorresa.biblioteca.models.entities.Book;

import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "Esta es la respuesta de la información completa del libro")

@Data
public class BookResponse {

    @Schema(description = "Identificador único del libro", example = "1")
    private Long bookId;

    @Schema(description = "Título del libro", example = "El Señor de los Anillos")
    private String title;

    @Schema(description = "Autor del libro", example = "J.R.R. Tolkien")
    private String author;

    @Schema(description = "ISBN del libro", example = "978-1234567890")
    private String isbn;

    @Schema(description = "Género literario del libro", example = "Novela")
    private String genre;

    @Schema(description = "Fecha de publicación del libro", example = "1954-07-29")
    private LocalDate publishedDate;   

    @Schema(description = "Estado del libro", example = "AVAILABLE")
    private Book.Status status;
    
    
}
