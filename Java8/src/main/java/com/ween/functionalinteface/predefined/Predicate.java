package com.ween.functionalinteface.predefined;

import java.util.Objects;

/**
 * @author weenhall
 */
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> and(Predicate<? super T> other){
        Objects.requireNonNull(other);
        return (t)->test(t)&&other.test(t);
    }

    default Predicate<T> negate(){
        return (t)->!test(t);
    }

    default Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

    static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }
}
