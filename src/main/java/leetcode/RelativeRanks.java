package leetcode;


import java.util.*;

public class RelativeRanks {
    public static void main(String[] args) {

    }

    public static String[] findRelativeRanks(int[] score) {
        final String[] RES = new String[score.length];

        RES[2] = "";
        return RES;
    }

    public static int minDeletionSize(String[] strs) {
        int count = 0;

        for (String str : strs)
            if (!isSorted(str))
                count++;

        return count;
    }

    private static boolean isSorted(String str) {
        if (str.length() == 1)
            return true;

        int first = str.charAt(0);
        int inc = 1;

        for (int i = 1; i < str.length(); i++) {
            if (first >= str.charAt(i)) {
                if (inc <= 0)
                    return false;

                inc++;
            } else {
                if (inc > 1)
                    return false;
                else
                    inc--;
            }

            first = str.charAt(i);
        }

        return true;
    }

    public static List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        int length = words.length;

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                Integer count = map.get(ch);

                if (count == length) {
                    map.put(ch, 0);
                    list.add(ch + "");
                }
            }
        }

        return list;
    }

    public static boolean buddyStrings(String s, String goal) {
        int length = s.length();

        if (length != goal.length())
            return false;


        return false;
    }

    public static String[] uncommonFromSentences2(String s1, String s2) {
        List<String> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        calc2(s1.split(" "), map);
        calc2(s2.split(" "), map);

        map.forEach((key, value) -> {
            if (value == 1) {
                list.add(key);
            }
        });

        return list.toArray(new String[0]);
    }

    private static void calc2(String[] s, Map<String, Integer> map) {
        for (String word : s)
            map.put(word, map.getOrDefault(word, 0) + 1);
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        List<String> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        calc(s1, map);
        calc(s2, map);

        map.forEach((key, value) -> {
            if (value == 1) {
                list.add(key);
            }
        });

        return list.toArray(new String[0]);
    }


    private static void calc(String word, Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i))) {
                builder.append(word.charAt(i));
            } else {
                if (!builder.isEmpty()) {
                    String targetWord = builder.toString();
                    map.put(targetWord, map.getOrDefault(targetWord, 0) + 1);

                    builder = new StringBuilder();
                }
            }
        }

        if (!builder.isEmpty()) {
            String targetWord = builder.toString();
            map.put(targetWord, map.getOrDefault(targetWord, 0) + 1);
        }
    }

    public static int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == c) {
                res[i] = 0;
                continue;
            }

            int left = s.lastIndexOf(c, i);
            int right = s.indexOf(c, i + 1);

            if (left == -1) {
                res[i] = right - i;
                continue;
            }

            if (right == -1) {
                res[i] = Math.abs(i - left);
                continue;
            }

            int absLeft = Math.abs(i - left);
            int absRight = Math.abs(i - right);

            System.out.println("absLeft = " + absLeft);
            System.out.println("absRight = " + absRight);

            res[i] = Math.min(absLeft, absRight);
        }

        return res;
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();

        paragraph = paragraph.toLowerCase();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {

            char c = paragraph.charAt(i);

            if (Character.isLetter(c)) {
                builder.append(c);
            } else {
                if (!builder.isEmpty()) {
                    String word = builder.toString();
                    builder = new StringBuilder();

                    if (!isExistInArray(banned, word)) {
                        map.put(word, map.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        if (!builder.isEmpty()) {
            String word = builder.toString();
            if (!isExistInArray(banned, word))
                map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
    }

    private static boolean isExistInArray(String[] banned, String word) {
        return Arrays.asList(banned).contains(word);
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];

        for (int i = 0; i < s.length(); i++) {
            int w = widths[s.charAt(i) - 'a'];

            if (res[1] + w > 100) {
                res[0]++;
                res[1] = w;
            } else {
                res[1] += w;
            }
        }

        res[0]++;
        return res;
    }

    public static boolean isPossibleToSplit(int[] nums) {


        return false;
    }

    public static int maxNumberOfBalloons(String text) {
        int[] array = new int[5];

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b') array[0]++;
            if (c == 'a') array[1]++;
            if (c == 'l') array[2]++;
            if (c == 'o') array[3]++;
            if (c == 'n') array[4]++;
        }
        System.out.println(Arrays.toString(array));

        int count = 0;
        while (true) {
            if (array[0] == 0)
                return count;

            if (array[1] == 0)
                return count;

            if (array[2] <= 1)
                return count;

            if (array[3] <= 1)
                return count;

            if (array[4] == 0)
                return count;

            array[0]--;
            array[1]--;
            array[2] -= 2;
            array[3] -= 2;
            array[4]--;
            count++;
        }
    }

//    14 19 19 19 14 - 1
//    13 18 17 17 13 - 2
//    12 17 15 15 12 - 3
//    11 16 13 13 11 - 4
//    10 15 11 11 10 - 5
//    9 14 9 9 9 - 6
//    8 13 7 7 8 - 7
//    7 12 5 5 7 - 8
//    6 11 3 3 6 - 9
//    5 10 1 1 5 - 10

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>(list1.length + list2.length);

        for (int i = 0; i < list1.length; i++) {
            int value = map.getOrDefault(list1[i], 0) + i;
            map.put(list1[i], value);
        }

        for (int i = 0; i < list2.length; i++) {
            int value = map.getOrDefault(list2[i], 0) + i;
            map.put(list2[i], value);
        }

        int count = 0;
        int min = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                count = 1;
            } else if (entry.getValue() == min) {
                count++;
            }
        }

        String[] result = new String[count];
        int resCount = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                result[resCount] = entry.getKey();
                resCount++;
            }
        }
        return result;
    }

    public static boolean isPowerOfTwo(int n) {

        int power = 1;

        while (power <= n) {
            if (power == n)
                return true;
            power *= 2;
        }

        return false;
    }

    public static int missingNumber(int[] nums) {
        Boolean[] array = new Boolean[nums.length + 1];

        for (int num : nums)
            array[num] = true;

        for (int i = 0; i < array.length; i++)
            if (array[i] == null)
                return i;

        return -1;
    }

    public static String task() {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            int number = scanner.nextInt();

            sum += number;


            max = Math.max(max, number);
            min = Math.min(min, number);
        }
        return (sum - max + " " + (sum - min));
    }
}