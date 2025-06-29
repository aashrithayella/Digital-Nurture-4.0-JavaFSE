package com.example.Exercise2;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    AdditionTest.class,
    SubtractionTest.class,
    MultiplicationTest.class
})
public class AllTests {
}
