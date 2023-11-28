package com.github.var4yn.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

@FunctionalInterface
interface ModelToXml<T> {
    Node get(T item, Document document);
}
