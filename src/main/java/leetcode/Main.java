package leetcode;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class Main {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++)
            new Thread(Main::increaseOne).start();


        System.out.println(count);
        System.out.println(count);
        System.out.println(count);
        System.out.println(count);
        System.out.println(count);
        System.out.println(count);
        System.out.println(count);
        System.out.println(count);
    }

    private synchronized static void increaseOne() {
        count++;
    }

    public List<Integer> findDuplicates(int[] nums) {
        boolean[] duplicates = new boolean[nums.length + 1];

        List<Integer> res = new ArrayList<>();

        for (int n : nums) {
            if (duplicates[n] && !res.contains(n)) {
                res.add(n);
            }
            duplicates[n] = true;
        }

        return res;
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                res[j][i] = matrix[i][j];

        return res;
    }

    private static String reverse(String str) {

        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = temp;
        }

        return new String(charArray);
    }


    public static int myAtoi(String s) {
        s = s.trim();

        boolean isFindDigit = false;
        int firstIndex = -1;
        StringBuilder collector = new StringBuilder();

        for (int i = 0; i < s.toCharArray().length; i++) {
            char current = s.charAt(i);

            if (!isFindDigit && Character.isLetter(current))
                return 0;

            if (Character.isDigit(current)) {
                if (current == '0')
                    if (!isFindDigit)
                        continue;

                if (firstIndex == -1) {
                    firstIndex = i;
                }

                collector.append(current);
                isFindDigit = true;
            } else {
                if (isFindDigit) {
                    break;
                }
            }
        }

        System.out.println(collector);

        if (firstIndex != 0)
            firstIndex--;

        if (isFindDigit) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < collector.toString().length(); i++) {
                if (collector.charAt(i) != 0) {
                    sb.append(collector.substring(i));
                    break;
                }
            }

            int f = s.charAt(firstIndex) == '-' ? -1 : 1;

            return new BigInteger(sb.toString()).multiply(BigInteger.valueOf(f)).intValue();
        }

        return -1;
    }

    public static void miniMaxSum(List<Integer> arr) {
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        long sum = 0;

        for (int num : arr) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        System.out.println((sum - max) + " " + (sum - min));
    }

    public static void plusMinus(List<Integer> arr) {
        int countPositive = 0, countNegative = 0, countZero = 0;

        for (int num : arr) {
            if (num > 0)
                countPositive++;
            else if (num < 0)
                countNegative++;
            else
                countZero++;
        }

        int size = arr.size();

        System.out.printf("%.6f%n", (double) countPositive / size);
        System.out.printf("%.6f%n", (double) countNegative / size);
        System.out.printf("%.6f%n", (double) countZero / size);
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int last = arr.size() - 1;
        int first = 0, second = 0;

        for (int i = 0; i < arr.size(); i++) {
            first += arr.get(i).get(i);
            second += arr.get(i).get(last--);
        }

        return Math.abs(first - second);
    }

    public static long aVeryBigSum(List<Long> ar) {
        return ar.stream().mapToLong(x -> x).sum();
    }


    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int[] collector = new int[2];

        for (int i = 0; i < a.size(); i++) {
            int a1 = a.get(i);
            int b1 = b.get(i);
            if (a1 > b1)
                collector[0]++;
            else if (b1 > a1)
                collector[1]++;
        }

        return List.of(collector[0], collector[1]);
    }

    public static int minimumCost(int[] nums) {
        Arrays.sort(nums);


        return -1;
    }


    public static int differenceOfSums(int n, int m) {
        int firstSum = 0;
        int secondSum = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0)
                secondSum += i;
            else
                firstSum += i;
        }

        return Math.abs(secondSum - firstSum);
    }

    public static void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(0, 0);

            if (count != 0) {
                nums[i] = 0;
                map.put(0, count - 1);
                continue;
            }

            count = map.getOrDefault(1, 0);

            if (count != 0) {
                nums[i] = 1;
                map.put(1, count - 1);
                continue;
            }

            nums[i] = 2;
            map.put(2, map.getOrDefault(2, 0) - 1);
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        int length = nodeLength(head);

        int swapCount = k % length;

        ListNode next = head;
        int firstCount = length - swapCount;

        while (firstCount > 0) {
            next = next.next;
            firstCount--;
        }

        ListNode res = next;
        ListNode temp = res;

        while (temp.next != null)
            temp = temp.next;

        System.out.println(swapCount);

        while (swapCount >= 0) {
            temp.next = new ListNode(head.val);
            temp = temp.next;
            head = head.next;
            swapCount--;
        }

        return res;
    }

    private static int nodeLength(ListNode head) {
        if (head == null)
            return 0;
        return 1 + nodeLength(head.next);
    }

    public static void reorderList(ListNode head) {
        ListNode head2 = head;

        ListNode reverse = null;
        int count = 0, length;
        while (head2 != null) {
            reverse = new ListNode(head2.val, reverse);
            head2 = head2.next;
            count++;
        }
        length = count;
        count /= 2;

        ListNode res = new ListNode(-1);
        ListNode temp = res;

        head2 = head;

        for (int i = 0; i < count; i++) {
            temp.next = new ListNode(head2.val);
            temp = temp.next;
            temp.next = new ListNode(reverse.val);
            temp = temp.next;

            head2 = head2.next;
            reverse = reverse.next;
        }

        if ((length & 1) == 1)
            temp.next = new ListNode(reverse.val);

        res = res.next;
        ListNode originHead = head;

        while (res != null) {
            originHead.val = res.val;
            res = res.next;
            originHead = originHead.next;
        }
    }


    public static final List<Integer> list = new ArrayList<>();

    public static TreeNode increasingBST(TreeNode root) {
        readValuesInTree(root);

        Collections.sort(list);

        TreeNode res = new TreeNode(list.get(0));
        return generateTreeNode(list, 1, res);
    }

    private static TreeNode generateTreeNode(List<Integer> list, int index, TreeNode temp) {
        if (index < list.size()) {
            temp.right = new TreeNode(list.get(index));
            temp = temp.right;
            generateTreeNode(list, index + 1, temp);
        } else {
            return temp;
        }

        return temp;
    }

    private static void readValuesInTree(TreeNode root) {
        if (root == null)
            return;

        list.add(root.val);

        readValuesInTree(root.left);
        readValuesInTree(root.right);
    }

    public static int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        BigInteger sum1 = new BigInteger("0");
        BigInteger sum2 = new BigInteger("0");

        while (l1 != null) {
            sum1 = sum1.add(BigInteger.valueOf(l1.val));
            sum1 = sum1.multiply(BigInteger.valueOf(10));
            l1 = l1.next;
        }

        sum1 = sum1.divide(BigInteger.valueOf(10));

        while (l2 != null) {
            sum2 = sum2.add(BigInteger.valueOf(l2.val));
            sum2 = sum2.multiply(BigInteger.valueOf(10));
            l2 = l2.next;
        }

        sum2 = sum2.divide(BigInteger.valueOf(10));

        sum1 = sum1.add(sum2);

        ListNode res = new ListNode(-1);
        ListNode temp = res;

        for (char c : sum1.toString().toCharArray()) {
            temp.next = new ListNode(c - '0');
            temp = temp.next;
        }

        return res.next;
    }

    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;

        if (head == null)
            return true;

        if (root.val == head.val)
            return isSubPath(head.next, root.left) || isSubPath(head.next, root.right);

        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode resHead = new ListNode(-1);
        ListNode res = resHead;

        while (head != null) {
            int count = 0;

            ListNode reverse = null;

            while (head != null && count != k) {
                reverse = new ListNode(head.val, reverse);
                head = head.next;
                count++;
            }

            if (count < k)
                res.next = reverseList2(reverse);
            else
                res.next = reverse;

            while (count-- > 0)
                res = res.next;
        }

        return resHead.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(-101);
        ListNode temp = res;

        Map<Integer, Integer> mp = new HashMap<>();

        while (head != null) {
            var val = head.val;

            if (mp.containsKey(val)) {
                mp.put(val, mp.get(val) + 1);
            } else {
                mp.put(val, 1);
            }
            head = head.next;
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == 1) {
                temp.next = new ListNode(entry.getKey());
                temp = temp.next;
            }
        }

        return res.next;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        ListNode reverse = null;
        ListNode temp = head;

        while (temp != null) {
            reverse = new ListNode(temp.val, reverse);
            temp = temp.next;
        }

        while (head != null) {
            if (head.val != reverse.val)
                return false;

            head = head.next;
            reverse = reverse.next;
        }

        return true;
    }

    public static ListNode reverseEvenLengthGroups2(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;

        int counter = 1;
        int currentCounter = 1;

        ListNode innerHead = new ListNode(-1);
        ListNode inner = innerHead;

        while (head != null) {
            if (counter == currentCounter) {
                inner.next = new ListNode(head.val);
                inner = inner.next;

                temp.next = (counter & 1) == 0 ? reverseList(innerHead.next) : innerHead.next;

                while (temp.next != null) {
                    temp = temp.next;
                }

                innerHead = new ListNode(-1);
                inner = innerHead;
                currentCounter = 1;
                counter++;
            } else {
                inner.next = new ListNode(head.val);
                inner = inner.next;
                currentCounter++;
            }
            head = head.next;
        }

        if (currentCounter != 1) {
            ListNode just = innerHead.next;

            int count = 0;
            while (just != null) {
                count++;
                just = just.next;
            }

            temp.next = (count & 1) == 0 ? reverseList(innerHead.next) : innerHead.next;

            while (temp.next != null)
                temp = temp.next;
        }

        show(res.next);

        return res.next;
    }

    public static ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;

        head = head.next;
        int sum = 0;

        while (head != null) {
            int val = head.val;

            if (val == 0) {
                temp.next = new ListNode(sum);
                temp = temp.next;
                head = head.next;
                sum = 0;
                continue;
            }

            sum += val;
            head = head.next;
        }

        return res.next;
    }

    public static ListNode doubleIt2(ListNode head) {
        int helper = 0;

        ListNode reverse = null;

        while (head != null) {
            reverse = new ListNode(head.val, reverse);
            head = head.next;
        }

        ListNode res = null;

        while (reverse != null) {
            int val = reverse.val;

            int dbVal = val * 2;

            res = new ListNode(dbVal % 10 + helper, res);
            helper = dbVal / 10;

            reverse = reverse.next;
        }

        if (helper != 0)
            res = new ListNode(helper, res);

        return res;
    }

    public static ListNode doubleIt(ListNode head) {
        BigInteger num = new BigInteger("0");

        while (head != null) {
            num = num.add(BigInteger.valueOf(head.val));
            num = num.multiply(BigInteger.valueOf(10));
            head = head.next;
        }

        ListNode res = new ListNode(-1);
        ListNode temp = res;

        num = num.divide(BigInteger.valueOf(10));
        num = num.multiply(BigInteger.valueOf(2));

        for (char n : num.toString().toCharArray()) {
            temp.next = new ListNode(n - '0');
            temp = temp.next;
        }

        return res.next;
    }

    public static ListNode insertGreatestCommonDivisors2(ListNode head) {
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            int crt = temp.val, nxt = temp.next.val;

            int gcd = commonDivisor(crt, nxt);

            ListNode next = temp.next;

            temp.next = new ListNode(gcd);
            temp = temp.next;
            temp.next = next;
            temp = temp.next;
        }

        return head;
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;

        while (head != null && head.next != null) {
            int currentVal = head.val;
            int nextVal = head.next.val;

            int gcd = commonDivisor(currentVal, nextVal);

            temp.next = new ListNode(currentVal);
            temp = temp.next;
            temp.next = new ListNode(gcd);
            temp = temp.next;

            head = head.next;
        }

        assert head != null;
        temp.next = new ListNode(head.val);

        return res.next;
    }

    private static int commonDivisor(int a, int b) {
        if (b == 0)
            return a;
        else
            return commonDivisor(b, a % b);
    }

    private static void show(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static ListNode reverseList2(ListNode head) {
        ListNode temp = null;

        while (head != null) {
            temp = new ListNode(head.val, temp);
            head = head.next;
        }

        return temp;
    }


    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return root.val == targetSum;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int sum = 1;

        for (int num : nums)
            sum *= num;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = sum / nums[i];
        }

        return res;
    }

    public static int[][] modifiedMatrix(int[][] matrix) {
        int[][] maxContainer = new int[matrix.length][0];
        int[][] res = new int[matrix.length][matrix[0].length];

        for (int[] nums : maxContainer)
            Arrays.fill(nums, -1);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

            }
        }

        return null;
    }

    public static int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(grid, i, j);
                    return count;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            count++;
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static int pivotInteger(int n) {
        int sumMain = 0;
        for (int i = 1; i < n; i++) {
            sumMain += i;
            int sum = IntStream.range(i, n + 1).sum();
            if (sum == sumMain) {
                return i;
            }

        }
        return -1;
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        int sum = 0;

        Map<Integer, ListNode> map = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        map.put(0, dummy);
        while (head != null) {
            sum += head.val;

            if (map.containsKey(sum)) {
                ListNode start = map.get(sum);
                ListNode temp = start;
                int sumInner = sum;
                while (temp != head) {
                    temp = temp.next;
                    sumInner += temp.val;
                    if (temp != head)
                        map.remove(sumInner);
                }
                start.next = head.next;
            } else {
                map.put(sum, head);
            }
            head = head.next;
        }

        return dummy.next;
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        StringBuilder builder = new StringBuilder();

        for (int n : num)
            builder.append(n);

        List<Integer> list = new LinkedList<>();
        for (char c : new BigInteger(builder.toString()).add(BigInteger.valueOf(k)).toString().toCharArray())
            list.add(c - '0');

        return list;
    }

    public static boolean isMonotonic(int[] nums) {
        int n = nums[0];
        for (int num : nums) {
            if (n >= num) {
                n = num;
            } else {
                int second = nums[0];
                for (int num2 : nums) {
                    if (second <= num2) {
                        second = num2;
                        continue;
                    }

                    return false;
                }
                return true;
            }
        }
        return true;
    }

    public static int distinctAverages(int[] nums) {
        Set<Double> st = new HashSet<>();
        int length = nums.length;

        Arrays.sort(nums);
        int start = 0;
        int end = length - 1;

        while (start < end) {
            int firstNum = nums[start++];
            int secondNum = nums[end--];

            st.add(((firstNum + secondNum) / 2.0));
        }

        System.out.println(Arrays.toString(nums));
        for (Double v : st) {
            System.out.println(v);
        }

        return st.size();
    }

    public static int dominantIndex(int[] nums) {
        int maxNumber = nums[0];
        int index = maxNumber == 0 ? -1 : 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxNumber < nums[i]) {
                maxNumber = nums[i];
                index = i;
            }
        }

        for (int num : nums) {
            if (num == 0)
                continue;

            if (maxNumber == num)
                continue;

            if (maxNumber - num < 2)
                return -1;
        }

        return index;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(b) - map.get(a));

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            pq.add(entry.getKey());

        for (int i = 0; i < k; i++)
            list.add(pq.poll());

        int[] arr = new int[k];

        for (int i = 0; i < k; i++)
            arr[i] = list.get(i);

        return arr;
    }

    public static String customSortString2(String order, String s) {
        int[] sValues = new int[26];

        for (char c : s.toCharArray())
            sValues[c - 'a']++;

        StringBuilder sb = new StringBuilder();

        for (char c : order.toCharArray()) {
            var count = sValues[c - 'a'];
            sValues[c - 'a'] = 0;
            if (count > 0)
                sb.append(String.valueOf(c).repeat(count));
        }

        for (int i = 0; i < values.size(); i++) {
            char current = (char) ('a' + i);
            if (sValues[i] > 0)
                sb.append(String.valueOf(current).repeat(sValues[i]));
        }

        return sb.toString();
    }

    public static String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[s.length()];

        for (int i = 0; i < order.length(); i++) {
            char orderChar = order.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (used[j]) {
                    continue;
                }
                if (s.charAt(j) == orderChar) {
                    sb.append(orderChar);
                    used[j] = true;
                }
            }
        }

        for (int i = 0; i < s.length(); i++)
            if (!used[i])
                sb.append(s.charAt(i));

        return sb.toString();
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums1)
            set.add(i);

        List<Integer> list = new ArrayList<>();

        for (int i : nums2)
            if (set.contains(i))
                list.add(i);

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public int compress(char[] chars) {
        Set<Character> set = new HashSet<>();

        for (char aChar : chars) {
            set.add(aChar);
        }
        return set.size();
    }

    public static ListNode removeNodes(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode help = head;

        do {
            Boolean node = isThereGreaterThanOneNode(head, help.next);
            if (node == null)
                return res.next;
            if (!node) {
                res.next = new ListNode(head.val);
                res = res.next;
            }
            head = head.next;
            help = help.next;

        } while (true);
    }

    private static Boolean isThereGreaterThanOneNode(ListNode current, ListNode head) {
        if (head == null)
            return null;

        ListNode temp = head;
        while (temp != null) {
            if (temp.val > current.val)
                return true;

            temp = temp.next;
        }
        return false;
    }


    public static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode temp = res;

        int count = 1;

        while (head != null) {
            int val = head.val;

            ListNode collector = new ListNode(val);
            ListNode headCollector = collector;
            for (int i = 0; i < count; i++) {
                if (head.next != null) {
                    head = head.next;
                    collector.next = new ListNode(head.val);
                    collector = collector.next;
                } else {
                    break;
                }
            }

            temp.next = headCollector;
            while (temp.next != null) {
                temp = temp.next;
            }
            count++;
        }
        return res.next;
    }

    public static ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        ListNode helper = head;

        while (helper != null) {
            helper.next = helper.next.next;
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);

        ListNode oddHead = odd;
        ListNode evenHead = even;

        boolean isOdd = true;

        while (head != null) {
            if (isOdd) {
                isOdd = false;
                oddHead.next = new ListNode(head.val);
                oddHead = oddHead.next;
                continue;
            } else {
                evenHead.next = new ListNode(head.val);
                evenHead = evenHead.next;
                isOdd = true;
            }
            head = head.next;
        }

        odd = odd.next;
        even = even.next;
        oddHead.next = even;
        return odd;
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int minimum = Integer.MAX_VALUE;

        for (int num : nums1) {
            for (int num2 : nums2) {
                if (num == num2) {
                    minimum = Math.min(minimum, num);
                }
            }
        }

        return minimum;
    }

    public static ListNode sortList(ListNode head) {
        List<Integer> nums = new ArrayList<>();

        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        Collections.sort(nums);

        ListNode res = new ListNode(0);
        ListNode temp = res;

        for (Integer num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return res.next;
    }


    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;

        int index = 0;

        while (index < a) {
            temp = temp.next;
            index++;
        }

        ListNode temp2 = temp;

        while (index < b) {
            temp2 = temp2.next;
            index++;
        }

        while (list2 != null) {
            temp.next = new ListNode(list2.val);
            list2 = list2.next;
            temp = temp.next;
        }

        temp.next = temp2.next;

        return list1;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode res = null;

        while (head != null) {
            res = new ListNode(head.val, res);
            head = head.next;
        }

        return res;
    }

    public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    class MyHashMap {

        private Map<Integer, Integer> map;

        public MyHashMap() {
            map = new HashMap<>();
        }

        public void put(int key, int value) {
            map.put(key, value);
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void remove(int key) {
            map.remove(key);
        }

    }

    class MyHashSet {

        private Set<Integer> set;

        public MyHashSet() {
            set = new HashSet<>();
        }

        public void add(int key) {
            set.add(key);
        }

        public void remove(int key) {
            set.remove(key);
        }

        public boolean contains(int key) {
            return set.contains(key);
        }

    }

    private static int getLength(ListNode head) {
        if (head == null)
            return 0;

        return 1 + getLength(head.next);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        return left == null ? right : left;
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2, new TreeNode());
    }

    private static TreeNode merge(TreeNode root1, TreeNode root2, TreeNode root) {
        if (root1 == null && root2 == null)
            return root;

        if (root1 == null) {
            root.val = root2.val;
            merge(null, root2.right, root);
            merge(null, root2.left, root);
        } else if (root2 == null) {
            root.val = root1.val;
            merge(root1.right, null, root);
            merge(root1.left, null, root);
        } else {
            root.val += root1.val + root2.val;
            merge(root1.right, root2.right, root);
            merge(root1.left, root2.left, root);
        }
        return root;
    }

    private static void read(TreeNode root, Set<Integer> set) {
        if (root == null)
            return;

        set.add(root.val);

        read(root.left, set);
        read(root.right, set);
    }

    public static boolean checkTree(TreeNode root) {
        return root.left.val + root.right.val == root.val;
    }

    TreeNode res = null;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        helper(original, cloned, target);
        return res;
    }

    private void helper(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null)
            return;

        if (original == target)
            res = cloned;

        helper(original.left, cloned.left, target);
        helper(original.right, cloned.right, target);
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        return sum(root, low, high, 0);
    }

    private static int sum(TreeNode root, int low, int high, int sum) {
        if (root == null)
            return 0;

        if (root.val >= low && root.val <= high)
            return root.val + sum(root.left, low, high, sum) + sum(root.right, low, high, sum);

        if (root.val < low)
            return sum(root.right, low, high, sum);
        else
            return sum(root.left, low, high, sum);
    }

    private static List<Integer> values = new ArrayList<>();

    public static int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private static int helper(TreeNode root, int sum) {
        if (root == null)
            return 0;

        sum = +(sum * 10) + root.val;

        if (root.left == null && root.right == null)
            return sum;

        return helper(root.left, sum) + helper(root.right, sum);
    }

    public static int maxFrequencyElements(int[] nums) {
        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        System.out.println(map);

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == max)
                sum += entry.getValue();

        return sum;
    }

    public static String destCity(List<List<String>> paths) {
        Set<String> set1 = new HashSet<>();
        Set<String> set = new HashSet<>();

        for (List<String> path : paths) {
            set1.add(path.get(0));
            set.add(path.get(1));
        }

        for (String checked : set) {
            if (!set1.contains(checked))
                return checked;
        }

        return null;
    }

    public static String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();

        int count = 0;

        while (n > 0) {
            if (count == 3) {
                sb.append(".");
                count = 0;
            }

            sb.append(n % 10);
            n = n / 10;
            count++;
        }

        return sb.reverse().toString();
    }

    public static String capitalizeTitle(String title) {
        String[] words = title.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (word.length() >= 3) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1).toLowerCase());
            } else
                sb.append(word.toLowerCase());

            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private static int countPoints(String rings) {
        int length = rings.length();

        int[][] array = new int[10][3];

        for (int i = 0; i < length; i += 2) {
            char color = rings.charAt(i);
            int number = rings.charAt(i + 1) - '0';

            switch (color) {
                case 'R' -> array[number][0]++;
                case 'G' -> array[number][1]++;
                case 'B' -> array[number][2]++;
            }
        }

        int count = 0;

        for (int[] nums : array)
            if (nums[0] >= 1 && nums[1] >= 1 && nums[2] >= 1)
                count++;

        return count;
    }

    public static List<String> commonChars(String[] words) {
        int length = words.length;

        int[][] arr = new int[length][26];

        for (int i = 0; i < length; i++) {
            String word = words[i];

            for (char c : word.toCharArray())
                arr[i][c - 'a']++;
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            int min = arr[0][i];
            for (int j = 0; j < length; j++)
                min = Math.min(min, arr[j][i]);

            char c = (char) ('a' + i);
            for (int a = 0; a < min; a++)
                res.add(String.valueOf(c));
        }

        return res;
    }

    public static boolean isLongPressedName(String name, String typed) {
        int x = 0;
        int y = 0;
        while (true) {
            if (x >= name.length()) {
                return true;
            }

            if (y >= typed.length())
                return false;

            char xChar = name.charAt(x);
            char yChar = name.charAt(x);


            if (xChar == yChar) {
                x++;
                y++;
            } else {
                y++;
            }
        }
    }

    public static String reformat(String s) {
        StringBuilder res = new StringBuilder();


        StringBuilder digit = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letter.append(c);
            }
        }

        return null;
    }


    private static boolean isSorted(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++)
            if (nums.get(i) > nums.get(i + 1))
                return false;

        return true;
    }

    private static void bogoSort(List<Integer> nums) {
        do {
            if (isSorted(nums))
                return;

            count++;
            Collections.shuffle(nums);
        } while (true);
    }

    private static int binarySearchRecursive(int[] nums, int target, int left, int right) {
        if (left >= right)
            return -1;

        int mid = (left + right) >> 1;

        int num = nums[mid];
        if (num == target)
            return mid;

        if (num < target)
            return binarySearchRecursive(nums, target, mid + 1, right);
        else
            return binarySearchRecursive(nums, target, left, mid);
    }

    private static int binarySearchIterative(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >> 1;

            int num = nums[mid];

            if (num == target)
                return mid;


            if (num < target)
                left = mid + 1;
            else
                right = mid;
        }

        return -1;
    }


    public static ListNode middleNode(ListNode head) {

        ListNode temp = head;
        ListNode help = head;

        while (temp != null && temp.next != null) {
            temp = temp.next.next;
            help = help.next;
        }

        return help;
    }

    public static int trap(int[] height) {
        int sum = 0;

        int left = 0;
        List<Integer> heightsBetween = new ArrayList<>();

        for (int i = 0; i < height.length; i++) {

        }

        return 0;
    }

    public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (!stack.isEmpty())
                    sb.append(c);
                stack.push(c);
            } else {
                stack.pop();
                if (!stack.isEmpty())
                    sb.append(c);
            }
        }

        return sb.toString();
    }

    public static boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length())
            return false;

        int index = 0;

        for (String word : words) {
            char first = s.charAt(index++);
            if (word.charAt(0) != first)
                return false;
        }

        return true;
    }

    public static String decodeMessage(String key, String message) {
        StringBuilder sb = new StringBuilder();

        Map<Character, Character> map = new HashMap<>();

        int bound = 0;
        int index = 0;

        while (index < key.length()) {
            char current = key.charAt(index);

            if (current == ' ' || map.containsKey(current)) {
                index++;
                continue;
            }

            map.put(current, (char) (bound + 'a'));
            index++;
            bound++;
        }

        for (char c : message.toCharArray()) {
            sb.append(c == ' ' ? ' ' : map.get(c));
        }

        return sb.toString();
    }

    public static List<String> cellsInRange(String s) {
        final ArrayList<String> RESULT = new ArrayList<>();

        char secondChar = s.charAt(3);
        char secondNumber = s.charAt(4);

        char firstChar = s.charAt(0);
        char firstNumber = s.charAt(1);

        while (firstChar <= secondChar) {
            int temp = firstNumber;
            while (temp <= secondNumber) {
                RESULT.add(firstChar + "" + (temp - '0'));
                temp++;
            }
            firstChar++;
        }

        return RESULT;
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;

        for (List<String> item : items) {
            int index = -1;
            switch (ruleKey) {
                case "type" -> index = 0;
                case "name" -> index = 1;
                case "color" -> index = 2;
            }
            if (item.get(index).equals(ruleValue))
                count++;
        }

        return count;
    }

    public static int numberOfBeams(String[] bank) {
        int sum = 0;

        int firstCountOfLasers = (int) bank[0].chars()
                .filter(c -> c == '1')
                .count();

        for (int i = 1; i < bank.length; i++) {
            int countOfLasers = (int) bank[i].chars()
                    .filter(c -> c == '1')
                    .count();

            if (countOfLasers == 0)
                continue;

            sum += (firstCountOfLasers * countOfLasers);
            firstCountOfLasers = countOfLasers;
        }

        return sum;
    }

    public static int minPartitions(String n) {
        return n.chars().max().getAsInt() - '0';
    }

    public static int minimumLength(String s) {


        while (true) {
            break;

        }

        return s.length();
    }

    public static List<String> stringMatching(String[] words) {
        final List<String> res = new LinkedList<>();

        for (String word : words)
            if (customContains(word, words))
                res.add(word);

        return res;
    }

    private static boolean customContains(String word, String[] words) {
        return Arrays.stream(words)
                .filter(w -> !w.equals(word))
                .anyMatch(w -> w.contains(word));
    }

    public static int[] diStringMatch(String s) {
        int length = s.length();
        int[] res = new int[length + 1];

        int low = 0, high = length;

        for (int i = 0; i < length; i++)
            res[i] = s.charAt(i) == 'I' ? low++ : high--;

        res[length] = high;
        return res;
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        final List<List<Integer>> RES = new ArrayList<>();

        int startIndex = 0;
        int endIndex = 0;
        char currentChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (currentChar == s.charAt(i)) {
                endIndex++;
            } else {
                if (endIndex + 1 - startIndex >= 3) {
                    RES.add(List.of(startIndex, endIndex));
                }
                startIndex = i;
                endIndex = i;
                currentChar = s.charAt(i);
            }
        }

        if (endIndex + 1 - startIndex >= 3)
            RES.add(List.of(startIndex, endIndex));

        return RES;
    }


    public static String toGoatLatin(String sentence) {
        int countA = 1;
        final StringBuilder res = new StringBuilder();
        final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char current = sentence.charAt(i);
            if (current == ' ') {
                if (!builder.isEmpty()) {
                    String currentWord = builder.toString();
                    char currentChar = currentWord.charAt(0);

                    if (VOWELS.contains(currentChar)) {
                        // Vowel logic here

                        res.append(currentWord)
                                .append("ma")
                                .append("a"
                                        .repeat(countA++))
                                .append(" ");


                        builder = new StringBuilder();
                        continue;
                    }

                    // Consonant  logic here
                    res.append(currentWord.substring(1))
                            .append(currentChar)
                            .append("ma")
                            .append("a"
                                    .repeat(countA++))
                            .append(" ");
                    builder = new StringBuilder();
                }
                continue;
            }
            builder.append(current);
        }

        if (!builder.isEmpty()) {
            String currentWord = builder.toString();
            char currentChar = currentWord.charAt(0);

            if (VOWELS.contains(currentChar)) {
                // Vowel logic here

                res.append(currentWord)
                        .append("ma")
                        .append("a"
                                .repeat(countA));
            } else {
                // Consonant  logic here
                res.append(currentWord.substring(1))
                        .append(currentChar)
                        .append("ma")
                        .append("a"
                                .repeat(countA));
            }
        }

        return res.toString();
    }

    public static String maximumTime(String time) {
        char[] times = time.toCharArray();

        if (times[0] == '?') {
            if (times[1] == '?') {
                times[0] = '2';
                times[1] = '3';
            } else {
                if (times[1] >= '4')
                    times[0] = '1';
                else
                    times[0] = '2';
            }
        }

        if (times[1] == '?')
            times[1] = times[0] == '2' ? '3' : '9';

        if (times[3] == '?')
            times[3] = '5';

        if (times[4] == '?')
            times[4] = '9';

        return new String(times);
    }

    public static String reformatNumber(String number) {
        final StringBuilder PHONE_NUMBER = new StringBuilder();

        StringBuilder numbers = new StringBuilder();

        for (char c : number.toCharArray())
            if (Character.isDigit(c))
                numbers.append(c);

        int count = numbers.length();
        int index = 0;
        while (count > 0) {
            if (count == 4) {
                PHONE_NUMBER.append(numbers.substring(index, index + 2));
                PHONE_NUMBER.append('-');
                PHONE_NUMBER.append(numbers.substring(index + 2, index + 4));
                index += 4;
                count -= 4;
                continue;
            }

            if (count >= 3) {
                PHONE_NUMBER.append(numbers.substring(index, index + 3));
                index += 3;
                count -= 3;

                if (count != 0)
                    PHONE_NUMBER.append('-');

                continue;
            }

            if (count == 2) {
                PHONE_NUMBER.append(numbers.substring(index, index + 2));
                index += 2;
                count -= 2;
            }
        }

        return PHONE_NUMBER.toString();
    }

    public static int uniqueMorseRepresentations(String[] words) {
        final String[] MORSE = new String[]{
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."
        };

        Set<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (char ch : word.toCharArray()) {
                builder.append(MORSE[ch - 'a']);
            }
            set.add(builder.toString());
        }
        return set.size();
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int length = s.length();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char current = s.charAt(i);

            if (current == ' ') {
                if (!builder.isEmpty()) {
                    sb.append(builder.reverse());
                    sb.append(' ');
                    builder = new StringBuilder();
                }
            } else {
                builder.append(current);
            }
        }

        if (!builder.isEmpty())
            sb.append(builder.reverse());

        return sb.substring(0, sb.length() - 1);
    }

    public static String[] findWords(String[] words) {
        final String FIRST_ROW = "qwertyuiop";
        final String SECOND_ROW = "asdfghjkl";
        final String THIRD_ROW = "zxcvbnm";

        List<String> res = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            if (isWritten(FIRST_ROW, lower)) {
                res.add(word);
                continue;
            }

            if (isWritten(SECOND_ROW, lower)) {
                res.add(word);
                continue;
            }

            if (isWritten(THIRD_ROW, lower))
                res.add(word);
        }

        return res.toArray(new String[0]);
    }

    private static boolean isWritten(String ROW, String word) {
        for (char c : word.toCharArray())
            if (!ROW.contains(c + ""))
                return false;

        return true;
    }


    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, word, i, j, 0))
                    return true;

        return false;
    }

    public static boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;

        if (index == word.length() - 1)
            return true;

        board[i][j] = '*';

        boolean exist = dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i, j - 1, index + 1);

        board[i][j] = word.charAt(index);

        return exist;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;

    }

    public static void backtrack(List<String> res, String curr, int open, int close, int n) {
        if (curr.length() == 2 * n) {
            res.add(curr);
            return;
        }
        if (open < n) {
            backtrack(res, curr + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(res, curr + ")", open, close + 1, n);
        }
    }

    public static String convert(String s, int numRows) {
        char[] help = new char[s.length()];

        return null;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int firstNum = getSumInListNode(l1);
        int secondNum = getSumInListNode(l2);

        int sum = firstNum + secondNum;

        if (sum >= 0 && sum < 10)
            return new ListNode(0);

        ListNode res = new ListNode(sum % 10, new ListNode());
        ListNode temp = res;

        sum /= 10;

        while (sum > 0) {
            temp.next = new ListNode();

            temp.next.val = sum % 10;
            temp = temp.next;
            sum /= 10;
        }

        return res;
    }

    private static int getSumInListNode(ListNode listNode) {
        StringBuilder sum = new StringBuilder();

        while (listNode != null) {
            sum.append(listNode.val);
            listNode = listNode.next;
        }

        return Integer.parseInt(sum.reverse().toString());
    }


    public static int[] sortArrayByParity(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 == 1) {
                int j = i;
                while (j > 0 && nums[j - 1] % 2 == 1) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    j--;
                }
            }
        }

        return nums;
    }

    public static int[] numberGame(int[] nums) {
        int length = nums.length;

        int index = 0;
        final int[] res = new int[length];
        final boolean[] removed = new boolean[length];

        while (isRemovedAllIndexes(removed)) {
            int minNumberAlice = getMinimumNumberAndRemove(nums, removed);
            int minNumberBob = getMinimumNumberAndRemove(nums, removed);

            res[index++] = minNumberBob;
            res[index++] = minNumberAlice;
        }

        return res;
    }

    private static int getMinimumNumberAndRemove(int[] nums, boolean[] removed) {
        int minNumber = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (removed[i])
                continue;

            if (minNumber > num) {
                minNumber = num;
                minIndex = i;
            }
        }

        if (minIndex == -1)
            return -1;

        removed[minIndex] = true;
        return minNumber;
    }

    private static boolean isRemovedAllIndexes(boolean[] removed) {
        for (boolean remove : removed)
            if (!remove)
                return true;

        return false;
    }

    public static int deleteGreatestValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        final boolean[][] visited = new boolean[n][m];
        int mainResultCount = 0;

        while (!isVisitedAllIndexes(visited)) {
            int mainMaxNumber = Integer.MIN_VALUE;

            for (int i = 0; i < grid.length; i++)
                mainMaxNumber = Math.max(mainMaxNumber,
                        deleteAndReturnMaxNumber(grid[i], i, visited));

            mainResultCount += mainMaxNumber;
        }

        return mainResultCount;
    }

    private static boolean isVisitedAllIndexes(boolean[][] visited) {
        for (boolean[] visits : visited)
            for (boolean visit : visits)
                if (!visit)
                    return false;

        return true;
    }

    private static int deleteAndReturnMaxNumber(int[] nums, int IIndex, boolean[][] visited) {
        int maxNumber = Integer.MIN_VALUE;
        int maxNumberIndex = -1;

        for (int j = 0; j < nums.length; j++) {
            if (visited[IIndex][j])
                continue;

            if (maxNumber < nums[j]) {
                maxNumber = nums[j];
                maxNumberIndex = j;
            }
        }

        if (maxNumberIndex == -1)
            return -1;

        visited[IIndex][maxNumberIndex] = true;
        return maxNumber;
    }

    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> collector = new HashMap<>();
        Map<Integer, Integer> targetCounter = new HashMap<>();

        for (int num : nums) {
            if (num == target) {
                targetCounter.put(num, targetCounter.getOrDefault(num, 0) + 1);
                continue;
            }

            if (target > num)
                collector.put(num, collector.getOrDefault(num, 0) + 1);
        }

        int countCollector = getCountAtomic(collector);
        int targetCount = getCountAtomic(targetCounter);

        for (int i = targetCount - 1; i >= 0; i--)
            res.add(countCollector++);

        return res;
    }

    public static int splitNum(int num) {
        List<Integer> res = new ArrayList<>();

        while (num != 0) {
            int target = num % 10;

            if (target != 0)
                res.add(target);

            num /= 10;
        }

        Collections.sort(res);

        int firstNum = 0, secondNum = 0;

        while (true) {
            if (res.isEmpty())
                break;

            firstNum += res.get(0);
            res.remove(0);
            firstNum *= 10;

            if (res.isEmpty())
                break;

            secondNum += res.get(0);
            res.remove(0);
            secondNum *= 10;

            if (res.isEmpty())
                break;
        }

        if (firstNum % 10 == 0)
            firstNum /= 10;

        if (secondNum % 10 == 0)
            secondNum /= 10;

        return firstNum + secondNum;

    }

    private static int getCountAtomic(Map<Integer, Integer> collector) {
        AtomicInteger countAtomic = new AtomicInteger();
        collector.forEach((key, value) -> countAtomic.addAndGet(value));

        return countAtomic.get();
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        Map<List<Integer>, Integer> temp = new HashMap<>();

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int first = arr[i];
            int second = arr[i + 1];


            int diff = Math.abs(first - second);
            minDiff = Math.min(diff, minDiff);
            temp.put(List.of(first, second), diff);
        }

        int finalMinDiff = minDiff;
        temp.forEach(
                (key, value) -> {
                    if (value == finalMinDiff)
                        res.add(key);
                }
        );

        res.sort(Comparator.comparingInt(list -> list.get(0)));

        return res;
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;

        ListNode fast = head;

        int count = 0;
        while (fast != null) {
            fast = fast.next;
            count++;
        }

        if (count == n)
            return head.next;

        int length = count - n;

        ListNode temp = head;

        length--;
        while (length > 0) {
            if (temp == null)
                return head;

            temp = temp.next;
            length--;
        }

        if (temp == null || temp.next == null)
            return head;

        temp.next = temp.next.next;

        return head;
    }

    public static String[] findRelativeRanks(int[] score) {
        final String[] RES = new String[score.length];

        return RES;
    }

    public static int countPrefixes(String[] words, String s) {
        int count = 0;

        for (String word : words)
            if (s.startsWith(word))
                count++;

        return count;
    }

    public static int countValidWords(String sentence) {
        String regex = "^([a-z]+(-?[a-z]+)?)?(!|\\.|,)?$";
        String r2 = "[^0-9]+";
        String[] arr = sentence.split("\\s+");

        int count = 0;

        for (String checked : arr)
            if (checked.matches(regex) && checked.matches(r2))
                count++;

        return count;
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new LinkedList<>();

        for (int i = 0; i < words.length; i++)
            for (char c : words[i].toCharArray())
                if (c == x) {
                    indices.add(i);
                    break;
                }

        return indices;
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;

        boolean isFind = false;

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if (Character.isLetter(current)) {
                isFind = true;

                if (brokenLetters.indexOf(current) != -1) {
                    int index = text.indexOf(' ', i);

                    if (index == -1)
                        return count;

                    i = index;
                    isFind = false;
                }
            } else {
                if (!isFind) {
                    i++;
                    continue;
                }

                count++;
                isFind = false;
            }
        }

        if (isFind)
            count++;

        return count;
    }

    public static int countGoodSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 1) != s.charAt(i + 2)) {
                count++;
            }
        }

        return count;
    }

    public static boolean squareIsWhite(String coordinates) {
        boolean first = (coordinates.charAt(0) & 1) == 0;
        boolean second = (coordinates.charAt(1) & 1) == 0;

        return first ^ second;
    }

    public static int numDifferentIntegers(String word) {
        Set<BigInteger> nums = new TreeSet<>();

        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                if (!sb.isEmpty()) {
                    nums.add(new BigInteger(sb.toString()));
                    sb = new StringBuilder();
                }
            }
        }

        if (!sb.isEmpty())
            nums.add(new BigInteger(sb.toString()));

        return nums.size();
    }

    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }


    // Given an unsorted integer array nums, return the smallest missing positive integer.
    // You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
    public static int firstMissingPositive(int[] nums) {
        int[] array = Arrays.stream(nums)
                .distinct()
                .toArray();

        Arrays.sort(array);

        int firstNumber = 1;

        for (int num : array) {
            if (num <= 0)
                continue;

            if (num == firstNumber) {
                firstNumber++;
            } else {
                return firstNumber;
            }
        }

        return firstNumber;
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null || root.left == null)
            return 0;

        int sum = 0;

        if (root.left.left == null && root.left.right == null)
            sum += root.left.val;

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}