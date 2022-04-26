package com.panosen;

import org.junit.Assert;
import org.junit.Test;

public class NameExtensionTest {

    @Test
    public void ToUpperCaseUnderLine() {
        Assert.assertEquals("ZHANG_SAN", NameExtension.toUpperCaseUnderLine("ZhangSan"));
        Assert.assertEquals("ZHANG_SAN", NameExtension.toUpperCaseUnderLine("zhang-san"));
        Assert.assertEquals("ZHANG_SAN", NameExtension.toUpperCaseUnderLine("zhang_san"));

        Assert.assertEquals("ZHANG_SAN_111", NameExtension.toUpperCaseUnderLine("ZhangSan111"));
        Assert.assertEquals("ZHANG_222_SAN", NameExtension.toUpperCaseUnderLine("Zhang222San"));
        Assert.assertEquals("ZHANG_333_SAN", NameExtension.toUpperCaseUnderLine("Zhang333san"));

        Assert.assertEquals("NGRAM_3", NameExtension.toUpperCaseUnderLine("NGRAM_3"));

        Assert.assertEquals("SSL", NameExtension.toUpperCaseUnderLine("SSL"));
        Assert.assertEquals("SSL", NameExtension.toUpperCaseUnderLine("ssl"));
    }

    @Test
    public void ToLowerCaseUnderLine() {
        Assert.assertEquals("zhang_san", NameExtension.toLowerCaseUnderLine("ZhangSan"));
        Assert.assertEquals("zhang_san", NameExtension.toLowerCaseUnderLine("zhang-san"));
        Assert.assertEquals("zhang_san", NameExtension.toLowerCaseUnderLine("zhang_san"));

        Assert.assertEquals("zhang_san_444", NameExtension.toLowerCaseUnderLine("ZhangSan444"));
        Assert.assertEquals("zhang_555_san", NameExtension.toLowerCaseUnderLine("Zhang555San"));
        Assert.assertEquals("zhang_666_san", NameExtension.toLowerCaseUnderLine("Zhang666san"));

        Assert.assertEquals("ngram_3", NameExtension.toLowerCaseUnderLine("ngram_3"));

        Assert.assertEquals("ssl", NameExtension.toLowerCaseUnderLine("SSL"));
        Assert.assertEquals("ssl", NameExtension.toLowerCaseUnderLine("ssl"));
    }

    @Test
    public void ToLowerCaseBreakLine() {
        Assert.assertEquals("zhang-san", NameExtension.toLowerCaseBreakLine("ZhangSan"));
        Assert.assertEquals("zhang-san", NameExtension.toLowerCaseBreakLine("zhang-san"));
        Assert.assertEquals("zhang-san", NameExtension.toLowerCaseBreakLine("zhang-san"));

        Assert.assertEquals("zhang-san-444", NameExtension.toLowerCaseBreakLine("ZhangSan444"));
        Assert.assertEquals("zhang-555-san", NameExtension.toLowerCaseBreakLine("Zhang555San"));
        Assert.assertEquals("zhang-666-san", NameExtension.toLowerCaseBreakLine("Zhang666san"));

        Assert.assertEquals("ngram-3", NameExtension.toLowerCaseBreakLine("ngram-3"));

        Assert.assertEquals("ssl", NameExtension.toLowerCaseBreakLine("SSL"));
        Assert.assertEquals("ssl", NameExtension.toLowerCaseBreakLine("ssl"));
    }

    @Test
    public void ToUpperCamelCase() {
        Assert.assertEquals("ZhangSan", NameExtension.toUpperCamelCase("ZhangSan"));
        Assert.assertEquals("ZhangSan", NameExtension.toUpperCamelCase("zhang-san"));
        Assert.assertEquals("ZhangSan", NameExtension.toUpperCamelCase("zhang-san"));

        Assert.assertEquals("ZhangSan444", NameExtension.toUpperCamelCase("ZhangSan444"));
        Assert.assertEquals("Zhang555San", NameExtension.toUpperCamelCase("Zhang555San"));
        Assert.assertEquals("Zhang666San", NameExtension.toUpperCamelCase("Zhang666san"));

        Assert.assertEquals("Ngram3", NameExtension.toUpperCamelCase("ngram-3"));

        Assert.assertEquals("Ssl", NameExtension.toUpperCamelCase("SSL"));
        Assert.assertEquals("Ssl", NameExtension.toUpperCamelCase("ssl"));
    }

    @Test
    public void ToLowerCamelCase() {
        Assert.assertEquals("zhangSan", NameExtension.toLowerCamelCase("ZhangSan"));
        Assert.assertEquals("zhangSan", NameExtension.toLowerCamelCase("zhang-san"));
        Assert.assertEquals("zhangSan", NameExtension.toLowerCamelCase("zhang-san"));

        Assert.assertEquals("zhangSan444", NameExtension.toLowerCamelCase("ZhangSan444"));
        Assert.assertEquals("zhang555San", NameExtension.toLowerCamelCase("Zhang555San"));
        Assert.assertEquals("zhang666San", NameExtension.toLowerCamelCase("Zhang666san"));

        Assert.assertEquals("ngram3", NameExtension.toLowerCamelCase("ngram-3"));

        Assert.assertEquals("ssl", NameExtension.toLowerCamelCase("SSL"));
        Assert.assertEquals("ssl", NameExtension.toLowerCamelCase("ssl"));
    }
}