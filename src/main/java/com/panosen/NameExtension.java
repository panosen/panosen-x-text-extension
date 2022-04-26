package com.panosen;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * String 扩展，用于改变名字
 */
public final class NameExtension {

    /**
     * 小写的名称，由Name计算而来
     * 示例：Student -&gt; STUDENT
     * 示例：StudentScore -&gt; STUDENT_SCORE
     *
     * @param name Name
     * @return 小写的名称
     */
    public static String toUpperCaseUnderLine(String name) {
        List<String> items = ToItems(name);

        return String.join("_", items).toUpperCase();
    }

    /**
     * 小写的名称，由Name计算而来
     * 示例：Student -&gt; student
     * 示例：StudentScore -&gt; student_score
     *
     * @param name Name
     * @return 小写的名称
     */
    public static String toLowerCaseUnderLine(String name) {
        List<String> items = ToItems(name);

        return String.join("_", items);
    }

    /**
     * 小写的名称，由Name计算而来
     * 示例：Student -&gt; student
     * 示例：StudentScore -&gt; student-score
     *
     * @param name Name
     * @return 小写的名称
     */
    public static String toLowerCaseBreakLine(String name) {
        List<String> items = ToItems(name);

        return String.join("-", items);
    }

    /**
     * 将数据库表名转换成实体名称
     * 示例：student_score -&gt; StudentScore
     *
     * @param name Name
     * @return 将数据库表名转换成实体名称
     */
    public static String toUpperCamelCase(String name) {
        List<String> items = ToItems(name);

        StringBuilder builder = new StringBuilder();
        for (int i = 0, length = items.size(); i < length; i++) {
            builder.append(String.valueOf(items.get(i).charAt(0)).toUpperCase()).append(items.get(i).substring(1));
        }

        return builder.toString();
    }

    /**
     * 由Name计算而来
     * 示例：name, studentScore
     *
     * @return 由Name计算而来
     */
    public static String toLowerCamelCase(String name) {
        List<String> items = ToItems(name);

        StringBuilder builder = new StringBuilder();
        for (int i = 0, length = items.size(); i < length; i++) {
            if (i == 0) {
                builder.append(items.get(i));
            } else {
                builder.append(String.valueOf(items.get(i).charAt(0)).toUpperCase() + items.get(i).substring(1));
            }
        }

        return builder.toString();
    }

    private static CharType ToCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return CharType.UpperLetter;
        }
        if (ch >= 'a' && ch <= 'z') {
            return CharType.LowerLetter;
        }
        if (ch >= '0' && ch <= '9') {
            return CharType.Number;
        }
        if (ch == '-') {
            return CharType.BreakLine;
        }
        if (ch == '_') {
            return CharType.UnderLine;
        }
        return CharType.None;
    }

    /**
     * 拆分字符串
     */
    private static List<String> ToItems(String text) {
        List<String> items = Lists.newArrayList();
        StringBuilder builder = new StringBuilder();

        CharItem lastCharItem = null;

        for (int i = 0, length = text.length(); i < length; i++) {
            CharItem currentCharItem = new CharItem();
            currentCharItem.setCh(text.charAt(i));
            currentCharItem.setType(ToCharType(text.charAt(i)));

            if (lastCharItem == null) {
                builder.append(currentCharItem.getCh());

                lastCharItem = currentCharItem;
                continue;
            }

            if (currentCharItem.getType() == CharType.BreakLine || currentCharItem.getType() == CharType.UnderLine) {
                if (builder.length() > 0) {
                    items.add(builder.toString().toLowerCase());
                    builder = new StringBuilder();
                }

                lastCharItem = currentCharItem;
                continue;
            }

            if (lastCharItem.getType() == CharType.LowerLetter && currentCharItem.getType() == CharType.UpperLetter) {
                items.add(builder.toString().toLowerCase());
                builder = new StringBuilder();

                builder.append(currentCharItem.getCh());

                lastCharItem = currentCharItem;
                continue;
            }

            if (lastCharItem.getType() == CharType.UpperLetter && currentCharItem.getType() == CharType.LowerLetter) {
                builder.append(currentCharItem.getCh());

                lastCharItem = currentCharItem;
                continue;
            }

            if (lastCharItem.getType() != currentCharItem.getType()) {
                items.add(builder.toString().toLowerCase());
                builder = new StringBuilder();

                builder.append(currentCharItem.getCh());

                lastCharItem = currentCharItem;
                continue;
            }

            builder.append(currentCharItem.getCh());

            lastCharItem = currentCharItem;
        }

        items.add(builder.toString().toLowerCase());
        items = items.stream().filter(v -> v.length() > 0).collect(Collectors.toList());
        return items;
    }
}