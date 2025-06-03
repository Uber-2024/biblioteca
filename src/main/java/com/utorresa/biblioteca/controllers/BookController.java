package com.utorresa.biblioteca.controllers;
import com.utorresa.biblioteca.models.dto.BookRequest;
import com.utorresa.biblioteca.models.dto.BookResponse;
import com.utorresa.biblioteca.services.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Libros", description = "Operaciones relacionadas con el préstamo de los libros")
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @Operation(summary = "Obtener todos los libros")
    @ApiResponse(responseCode = "200", description = "Lista de libros obtenida correctamente")
    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Operation(summary = "Buscar libros por título")
    @ApiResponse(responseCode = "200", description = "Lista de libros filtrada por título")
    @GetMapping("/buscar")
    public List<BookResponse> getBooksByTitle(
            @Parameter(description = "Título del libro a buscar", example = "El Señor de los Anillos")
            @RequestParam("title") String title) {
        return bookService.getBooksByTitle(title);
    }

    @Operation(summary = "Obtener libro por ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Libro encontrado"),
        @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @GetMapping("/{id}")
    public BookResponse getBookById(
            @Parameter(description = "ID del libro", example = "1")
            @PathVariable Long id) {
        return bookService.getOne(id);
    }

    @Operation(summary = "Crear un nuevo libro")
    @ApiResponse(responseCode = "201", description = "Libro creado correctamente")
    @PostMapping
    public BookResponse createBook(
            @Parameter(description = "Datos del libro a crear")
            @Valid @RequestBody BookRequest book) {
        return bookService.create(book);
    }

    @Operation(summary = "Actualizar un libro existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Libro actualizado correctamente"),
        @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @PutMapping("/{id}")
    public BookResponse updateBook(
            @Parameter(description = "ID del libro a actualizar", example = "1")
            @Valid @PathVariable Long id,
            @Parameter(description = "Datos actualizados del libro")
            @RequestBody BookRequest book) {
        return bookService.update(id, book);
    }

    @Operation(summary = "Eliminar un libro por ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Libro eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @DeleteMapping("/{id}")
    public void deleteBook(
            @Parameter(description = "ID del libro a eliminar", example = "1")
            @PathVariable("id") Long id) {
        bookService.delete(id);
    }
}
