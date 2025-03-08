package org.opengear.supa.common;

public interface UniMessage {

    static UniMessage ofPain(String message) {
        return new UniMessageImpl(message);
    }
}
