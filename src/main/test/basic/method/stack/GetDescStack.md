

<h1>用数组实现一个栈的逆序</h1>
```html
<h3>思路</h3>
<h4>
Ⅰ:首先当栈是空的时间，将数组中的元素直接放入
Ⅱ:当栈不是空的，并且栈顶的元素大于数组arr[i],弹出栈顶该元素，并用临时数组记录。
直到while循环结束，将数组该元素arr【i】压入栈。如代码所示：
</h4>

```



```java
int[] tempArray = new int[i];
int index=0;
while (!stack.isEmpty()&&arr[i]<=stack.peek()){
    tempArray[index]=stack.pop();
    index++;
}
stack.push(arr[i]);
```

Ⅱ：在该次循环结束前，开始将临时数组的数据从末尾到头一次入栈。（因为数组头放置的是截止到arr[i]之前最大数据）

```java
for (int j = tempArray.length-1; j >=0 ; j--) {
    if(tempArray[j]!=0)
        stack.push(tempArray[j]);
}
```


Ⅲ：将得到的栈依次遍历，放入数组中，作为该方法返回的结果

```java
//栈是递减的，那么数组就是递增的
for (int i = 0; i < arr.length; i++) {
    result[i]=stack.pop();
}
```