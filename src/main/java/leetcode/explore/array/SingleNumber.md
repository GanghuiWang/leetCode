只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4

题解：
利用set得到不重复的元素，然后将其*2,得到sum1，同时将nums遍历求和得sum2，
此时2*sum1恰好比sum2多出那唯一的不重复元素。
return 2*sum1-sum2 即可得到答案。