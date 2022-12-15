package com.mc.util.collection.d_lambda.function;

@FunctionalInterface
public interface Function<T> {
	
	T apply(T t, T u);

}
