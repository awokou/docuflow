package com.server.apidocuflow.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import javax.naming.ServiceUnavailableException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

        /**
         * Handles ResourceNotFoundException and returns a 404 response.
         */
        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
                log.error("Not found: {}", ex.getMessage());
                ErrorResponse error = ErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.NOT_FOUND.value())
                                .error("Not Found")
                                .message(ex.getMessage())
                                .path(request.getRequestURI())
                                .build();

                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        /**
         * Handles AlreadyExistException and returns a 409 response.
         */
        @ExceptionHandler(AlreadyExistException.class)
        public ResponseEntity<ErrorResponse> handleAlreadyExists(AlreadyExistException ex, HttpServletRequest request) {
                log.error("Conflict: {}", ex.getMessage());
                ErrorResponse error = ErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.CONFLICT.value())
                                .error("Conflict")
                                .message(ex.getMessage())
                                .path(request.getRequestURI())
                                .build();

                return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }

        /**
         * Handles validation errors and returns a 400 response.
         */
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex,
                        HttpServletRequest request) {

                String errorMsg = ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                                .collect(Collectors.joining(", "));

                ErrorResponse error = ErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.BAD_REQUEST.value())
                                .error("Bad Request")
                                .message(errorMsg)
                                .path(request.getRequestURI())
                                .build();

                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        /**
         * Handles ConstraintViolationException and returns a 400 response.
         */
        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<ErrorResponse> handleConstraintViolation(HttpServletRequest request) {

                ErrorResponse error = ErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.BAD_REQUEST.value())
                                .error("Bad Request")
                                .message("Invalid request parameters")
                                .path(request.getRequestURI())
                                .build();

                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        /**
         * Handles ServiceUnavailableException and returns a 503 response.
         */
        @ExceptionHandler(ServiceUnavailableException.class)
        public ResponseEntity<ErrorResponse> handleServiceUnavailable(ServiceUnavailableException ex,
                        HttpServletRequest request) {

                ErrorResponse error = ErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.SERVICE_UNAVAILABLE.value())
                                .error("Service unavailable")
                                .message(ex.getMessage())
                                .path(request.getRequestURI())
                                .build();

                return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);
        }

        /**
         * Handles BadCredentialsException and returns a 401 response.
         */
        @ExceptionHandler(BadCredentialsException.class)
        public ResponseEntity<ErrorResponse> handleBadCredentials(
                        HttpServletRequest request) {

                ErrorResponse error = ErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.UNAUTHORIZED.value())
                                .error("Unauth")
                                .message("Email ou mot de passe invalide")
                                .path(request.getRequestURI())
                                .build();

                return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        }

        /**
         * Handles DisabledException and returns a 403 response.
         */
        @ExceptionHandler(DisabledException.class)
        public ResponseEntity<ErrorResponse> handleDisabled(
                        HttpServletRequest request) {

                ErrorResponse error = ErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.FORBIDDEN.value())
                                .error("FORBIDDEN")
                                .message("Votre compte n'est pas activé. Veuillez contacter l'administrateur.")
                                .path(request.getRequestURI())
                                .build();

                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
        }

        /**
         * Handles all other exceptions and returns a 500 response.
         */
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleGlobalException(
                        HttpServletRequest request) {

                ErrorResponse error = ErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .error("INTERNAL_SERVER_ERROR")
                                .message("An unexpected error occurred")
                                .path(request.getRequestURI())
                                .build();

                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
