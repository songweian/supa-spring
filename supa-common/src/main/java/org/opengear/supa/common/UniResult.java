package org.opengear.supa.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface UniResult<T> {

    String CODE_OK = "0";

    static <T> UniResult<T> of(String code, T data, Throwable throwable, String message) {
        return new UniResultImpl<>(code,data,throwable,message);
    }

    static <T> UniResult<T> of(String code,T data, String message) {
        return new UniResultImpl<>(code,data,null,message);
    }
    static <T> UniResult<T> ofOk() {
        return new UniResultImpl<>(CODE_OK,null,null,"ok");
    }

    static <T> UniResult<T> ofOk(T data) {
        return new UniResultImpl<>(CODE_OK,data,null,"ok");
    }

    static <T> UniResult<T> ofError(String code, T data, Throwable throwable, String message) {
        return new UniResultImpl<>(code,data,null,message);
    }
    static <T> UniResult<T> ofError(String code, T data, String message) {
        return new UniResultImpl<>(code,data,null,message);
    }
    static <T> UniResult<T> ofError(String code, T data) {
        return new UniResultImpl<>(code,data,null,"error");
    }

    T get();

    default String getCode() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @JsonIgnore
    default boolean isOk() {
        return "0".equals(getCode());
    }

    @JsonIgnore
    default boolean isError() {
        return !isOk();
    }

    @JsonIgnore
    default boolean isNonNull() {
        return get() != null;
    }

    @JsonIgnore
    default boolean isNull() {
        return get() == null;
    }

    @JsonIgnore
    default Throwable getException() {
        throw new UnsupportedOperationException("Not implemented");
    }

    default String getMessage() {
        throw new UnsupportedOperationException("Not implemented");
    }

}
