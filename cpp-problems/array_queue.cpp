#include<iostream>
#include<stdlib.h>
using namespace std;
typedef struct ArrQueue
{
int *arr;
int Front,rear;
int Size;
int capacity;
}Q;
struct ArrQueue* create(long int capacity)
{
Q* sq=(Q*)malloc(sizeof(Q));
sq->Front=0;
sq->Size=0;
sq->rear=capacity-1;
sq->capacity=capacity;
sq->arr=(int*)malloc(sizeof(sq->capacity)*sizeof(int));
}
int isFull(Q *obj)
{
    return (obj->Size==obj->capacity);
}
int isEmpty(Q *obj)
{
    return (obj->Size==0);
}
void enqueue(Q *obj,int val)
{
    if(isFull(obj))
    {
        return;
    }
    obj->rear=(obj->rear+1)%obj->capacity;  /// to move in circular fashion.
    obj->arr[obj->rear]=val;
    obj->Size++;
}
int dequeue(Q *obj)
{
    if(isEmpty(obj))
    {
        return 0;
    }
    int data=obj->arr[obj->Front];
    obj->Size--;
    obj->Front=(obj->Front+1)%obj->capacity;  /// to move in circular fashion
    return data;
}
int main()
{
struct ArrQueue* Q=create(10000);
enqueue(Q,10);
enqueue(Q,20);
enqueue(Q,30);
enqueue(Q,40);
cout<<dequeue(Q);
return 0;
}
