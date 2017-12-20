package com.wesai.kotlin.iterator;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by long
 * on 2017/12/19.
 */

public class MyList implements Iterator<Integer> {

    int size = 10;

    public MyList(int size) {
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return size > 0;
    }

    @Override
    public Integer next() {
        size--;
        return size;
    }

    @Override
    public void remove() {
        size--;
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {

    }

}
