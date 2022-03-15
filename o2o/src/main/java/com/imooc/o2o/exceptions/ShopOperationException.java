package com.imooc.o2o.exceptions;

public class ShopOperationException extends RuntimeException {
    // encapsulation of runtime exception
    // need to be serialized

    public ShopOperationException(String msg) {
        super(msg);
    }
}
