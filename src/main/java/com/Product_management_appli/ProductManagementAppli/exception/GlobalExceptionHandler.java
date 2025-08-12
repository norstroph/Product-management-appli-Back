package com.Product_management_appli.ProductManagementAppli.exception;

import com.Product_management_appli.ProductManagementAppli.dtos.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundHandlerException.class)
    public ResponseEntity<String> handleResourceNotFound(NotFoundHandlerException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(NotEnoughStockException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotEnoughStock(NotEnoughStockException exception) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                "Stock insuffisant",
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(TechnicalDatabaseException.class)
    public ResponseEntity<String> handleDatabaseError( TechnicalDatabaseException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur technique : " + e.getMessage());
    }

}
