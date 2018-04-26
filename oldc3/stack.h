#ifndef _STACK_
#define _STACK_

#include <iostream>

template <typename T>
class stackNode {
private:
    T item;
    stackNode<T> *next;
public:
    stackNode();
    stackNode(T item);
    T getItem();
    void setNext(stackNode<T> next);
    stackNode<T>* getNext();
};

template <typename T>
stackNode<T>::stackNode() {
    // empty for a reason!
}

template<typename T>
stackNode<T>::stackNode(T item) {
    this->item = item;
}

template<typename T>
T stackNode<T>::getItem() {
    return this->item;
}

template<typename T>
void stackNode<T>::setNext(stackNode<T> next) {
    this->next = &next;
}

template<typename T>
stackNode<T>* stackNode<T>::getNext() {
    return this->next;
}

template<typename T> 
class stack {
private:
    stackNode<T> top;
    int size;
public:
    stack();
    T pop();
    void push(T item);
    T peek();
    int getSize();
};

template <typename T>
stack<T>::stack() {
    top = NULL;
    size = 0;
}

template <typename T>
T stack<T>::pop() {
    T item = top.getItem();
    stackNode<T> temp = *top.getNext();
    top = temp;
    size--;
    return item;
}

template<typename T>
void stack<T>::push(T item) {
    stackNode<T> node(item);
    node.setNext(top);
    top = node;
    size++;
}

template<typename T>
T stack<T>::peek() {
        return top.getItem();
}

template<typename T>
int stack<T>::getSize() {
    return size;
}




#endif
