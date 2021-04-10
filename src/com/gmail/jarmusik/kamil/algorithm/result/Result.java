package com.gmail.jarmusik.kamil.algorithm.result;


public class Result<T> {
    private T result;

    public Result(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return String.valueOf(result);
    }
}