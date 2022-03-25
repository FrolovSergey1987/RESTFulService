package com.example.questiontesting.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class Mapper {

    private static   ModelMapper mapper = new ModelMapper();

    public  <T,S> T mapper(S source, Class<T> tClass){
        return mapper.map(source,tClass);
    }
}
