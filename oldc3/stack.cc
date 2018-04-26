#include "stack.h"



int main(int argc, char* argv[]){
    stackNode<int> n(5);
    std::cout << n.getItem() << std::endl;
    stackNode<int> m(7);
    n.setNext(m);
    std::cout << n.getNext()->getItem() << std::endl;

    stack<int> s = stack<int>();
    s.push(2);
    std::cout << s.peek() << std::endl;
    s.push(6);
    std::cout << s.peek() << std::endl;
    s.pop();
    std::cout << s.peek() << std::endl;

    return 0;
}
