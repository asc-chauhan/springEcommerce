package com.ecommerce.anshul.exceptions;

public class  ResourceNotFoundException extends RuntimeException {
    String resouceName;
    String fieldName;
    String field;
    Long fieldId;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String resouceName, String fieldName, String field) {
        super(String.format("%s not found with %s: %s", resouceName, field, fieldName));
        this.resouceName = resouceName;
        this.fieldName = fieldName;
        this.field = field;
    }

    public ResourceNotFoundException( String resouceName, String field, Long fieldId) {
        super(String.format("%s not found with %s: %d", resouceName, field, fieldId));
        this.field = field;
        this.resouceName = resouceName;
        this.fieldId = fieldId;
    }
}
