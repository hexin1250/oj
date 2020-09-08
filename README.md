# oj
---
记录在oj上解题的思路，以便温习。<br>
Record my thought how to solve the problems, in case I can review these later.<br>
oj链接为[杭州电子科技大学oj网站](http://acm.hdu.edu.cn/listproblem.php?vol=1)。

## [1002 A + B Problem II](http://acm.hdu.edu.cn/showproblem.php?pid=1002)
大数相加问题。将字符串数字转换成数组，然后对位相加即可。<br>
This problem is to plus two big number, which we can't store it with long type.
1. Convert number string to number array.
2. Plus the number of the same index.
---
## [1025 Constructing Roads In JGShining's Kingdom](http://acm.hdu.edu.cn/showproblem.php?pid=1025)
最长单调递增子序列问题，Longest Increasing Subsequence<br>
Data:<br>
|1|2|<br>
|3|4|<br>
|4|5|<br>
|5|8|<br>
|7|9|<br>
|2|3|<br>
|6|1|<br>
|9|7|<br>
|8|6|<br>
需要首先对数据进行排序，以左边进行排序，得到下表:<br>
|1|2|<br>
|2|3|<br>
|3|4|<br>
|4|5|<br>
|5|8|<br>
|6|1|<br>
|7|9|<br>
|8|6|<br>
|9|7|<br>
则求数组*s=[2,3,4,5,8,1,9,6,7]*的最长递增子序列。<br>
维护一个数组a，初始化a[0]=s[0]，总长度为1。<br>
遍历数组s，第二个数据3>a[0]，将数字3加入数组a，*a=[2,3]*<br>
以此类推，得到*a=[2,3,4,5,8]*<br>
s[5]=1<a[4]=8，对数组进行递归，查找第一个大于s[5]的数字，由于找不到，则替换数组的第一个元素，此时*a=[1,3,4,5,8]*<br>
s[6]=9>a[4]=8，则加入数组，*a=[1,3,4,5,8,9]*<br>
s[7]=6<a[5]=9，对数组进行递归，查找第一个大于s[7]的数字，替换a[4]，*a=[1,3,4,5,6,8]*<br>
s[8]=7<a[5]=8，对数组进行递归，查找第一个大于s[8]的数字，替换a[4]，*a=[1,3,4,5,6,9]*<br>
则最后输出结果为6。<br>
注：在查找的过程中，用**二分查找**，可使时间复杂度从**O(n^2)**降到**O(nlogn)**。

## [1026 Ignatius and the Princess I](http://acm.hdu.edu.cn/showproblem.php?pid=1026)
广度优先搜索问题，参考[广度优先搜索策略](https://blog.csdn.net/weixin_40953222/article/details/80544928).
### 广度优先搜索和深度优先搜索
两者最大的区别是，到底是优先循环还是优先递归。<br>
优先循环，则是广度优先搜索；优先递归，则是深度优先搜索。<br>
深度优先搜索虽然好用，但并不是所有的场景都适用。当问题可能没有解时，深度优先搜索会导致timeout。因此此时需要用广度优先搜索来解决。
### 广度优先搜索的原理：
1. 选定初始节点，标记为**已访问**过的元素，入列。
2. 将队列中第一个元素出列。
3. 遍历该元素的所有**未访问过**的相邻节点，标记为**已访问**过的元素，入列。
4. 重复步骤2/3，直到队列为空时，结束搜索。
### 广度优先搜索的一些特殊处理
#### 如何记录路径
在遍历每个节点的过程中，在当前节点信息Status对象中，保存父节点信息，使之成为单向链表。<br>
#### 当需要在某一处节点需要时间惩罚时该如何处理
该节点信息Status加入cost时间信息，当未达到惩罚时间时，cost时间增加，将变化后的新节点信息Status加入到队列中。因此后续队列中读取到的数据依然是该节点信息，只不过是停留n秒之后的状态。

## [1027 Ignatius and the Princess II](http://acm.hdu.edu.cn/showproblem.php?pid=1027)
参考[逆康托展开](https://blog.csdn.net/qq_40061421/article/details/81915838).

### 康托展开
举个例子说明。在（1，2，3，4，5）5个数的排列组合中，计算 34152的康托展开值。
* 首位是3，则小于3的数有两个，为1和2，a[5]=2，则首位小于3的所有排列组合为 a[0]*(5-1)!
* 第二位是4，则小于4的数有两个，为1和2，注意这里3并不能算，因为3已经在第一位，所以其实计算的是在第二位之后小于4的个数。因此a[4]=2
* 第三位是1，则在其之后小于1的数有0个，所以a[3]=0
* 第四位是5，则在其之后小于5的数有1个，为2，所以a[2]=1
* 最后一位就不用计算啦，因为在它之后已经没有数了，所以a[1]固定为0
##### 根据公式： 
X = 2 * 4! + 2 * 3! + 0 * 2! + 1 * 1! + 0 * 0! 
= 2 * 24 + 2 * 6 + 1 
= 61<br>
所以比 34152 小的组合有61个，即34152是排第62。

### 逆康托展开
一开始已经提过了，康托展开是一个全排列到一个自然数的双射，因此是可逆的。即对于上述例子，在（1，2，3，4，5）给出61可以算出起排列组合为 34152。由上述的计算过程可以容易的逆推回来，具体过程如下：
* 用 61 / 4! = 2余13，说明a[5]=2,说明比首位小的数有2个，所以首位为3。
* 用 13 / 3! = 2余1，说明a[4]=2，说明在第二位之后小于第二位的数有2个，所以第二位为4。
* 用 1 / 2! = 0余1，说明a[3]=0，说明在第三位之后没有小于第三位的数，所以第三位为1。
* 用 1 / 1! = 1余0，说明a[2]=1，说明在第二位之后小于第四位的数有1个，所以第四位为5。
* 最后一位自然就是剩下的数2啦。
##### 通过以上分析，所求排列组合为 34152。

## [1030 Delta-wave](http://acm.hdu.edu.cn/showproblem.php?pid=1030)
公式计算题：<br>
第n层最后一个元素是n^2。根据层数n和数字m，确定数字m的索引及上下区。<br>
较小的数字为a，较大的数字为b。结果route初始值为(l2-l1)*2<br>
* 如果a和b在同层，则结果是b-a。
* 如果a在上区，b在下区，则结果+1，同时a与b的索引差值大于(l2-l1+1)或小于0，则结果+Math.abs(offset-(l2-l1+1))*2。
* 如果a在下区，b在上区，则结果-1，同时a与b的索引差值大于(l2-l1-1)或小于0，则结果+Math.abs(offset-(l2-l1-1))*2。
* 如果a和b同区，则a与b的索引差值大于(l2-l1)或小于0，则结果+Math.abs(offset-(l2-l1))*2。
