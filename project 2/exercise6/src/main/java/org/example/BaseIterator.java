package org.example;

interface BaseIterator<T> {
    T next();
    boolean hasNext();
    void reset();
}