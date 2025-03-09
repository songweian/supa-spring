package org.opengear.supa.framework.common;

public interface UniMessage {

    static UniMessage ofText(String message) {
        return new UniMessageImpl(message);
    }
}
