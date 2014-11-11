package com.ultraon.clamp.parser;

import com.ultraon.clamp.parser.model.Clamp;

import java.io.IOException;

/**
 * Created by vitaliypopov on 11.11.14.
 */
public interface ISaver<T> {
    void save(T model, String dirPath) throws IOException;
}
