package com.company.ioctest;

import org.springframework.stereotype.Component;

@Component("Dog")
public class Dog  implements Animal{
    @Override public String eat() { return "Dog-eat"; }
    @Override public String sleep() { return "Dog-sleep"; }
    @Override public String poo() { return "Dog-poo"; }
 } 