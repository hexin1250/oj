# oj
---
记录在oj上解题的思路，以便温习。
Record my thought how to solve the problems, in case I can review these later.

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