package com.ween.functionalinteface.function;

import java.util.Objects;

/**
 * @author weenhall
 */
@FunctionalInterface
public interface Function<T,R> {
    R apply(T t);

    default <V> Function<V,R> compose(Function<?super V,?extends T> before){
        Objects.requireNonNull(before);
        return (V v)->apply(before.apply(v));
    }

    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }


    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
