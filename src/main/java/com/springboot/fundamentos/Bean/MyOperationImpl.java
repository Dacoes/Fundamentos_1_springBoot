package com.springboot.fundamentos.Bean;

public class MyOperationImpl implements MyOperation{

    @Override
    public int sum(int number) {
        return number+1;
    }
}
