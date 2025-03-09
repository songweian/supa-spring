package org.opengear.supa.framework.exception;

import org.opengear.supa.framework.common.UniResult;

public class UniException  extends RuntimeException {
    private String code;
    private Object data;
    protected UniException(String code,Object data,Throwable throwable,String message) {
        super(message,throwable);
        this.code = code;
        this.data = data;
    }

    public static UniException of(String code, Object data,Throwable throwable, String message) {
        return new UniException(code,data,throwable,message);
    }

    public UniResult<?> toUniResult() {
        return UniResult.of(code,data,this,getMessage());
    }

}
