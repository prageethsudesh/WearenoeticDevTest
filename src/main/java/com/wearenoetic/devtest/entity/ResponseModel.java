package com.wearenoetic.devtest.entity;

public class ResponseModel<E> {
    private int statusCode;
    private String statusDescription;
    private E entity;

    public ResponseModel() {

    }

    public ResponseModel(int statusCode, String statusDescription) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
    }

    public ResponseModel(int statusCode, String statusDescription, E entity) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.entity = entity;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }
}
