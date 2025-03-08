package org.opengear.supa.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
@Data
public class UniResultImpl<T> implements UniResult<T> {

    protected final String code;
    protected final T data;
    protected final String message;
    @JsonIgnore
    protected final Throwable throwable;

    public UniResultImpl(String code, T data, Throwable throwable, String message) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.throwable = throwable;
    }

    @Override
    public T get() {
        return data;
    }
}
