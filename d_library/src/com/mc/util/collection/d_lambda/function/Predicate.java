package com.mc.util.collection.d_lambda.function;

@FunctionalInterface
public interface Predicate<T> {
	
	boolean test(T t);

}
