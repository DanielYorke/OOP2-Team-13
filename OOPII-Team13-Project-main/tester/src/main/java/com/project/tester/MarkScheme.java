package com.project.tester;

public abstract class MarkScheme implements Test{
    public abstract int execute();
    public abstract void addTest(Test t);
    public abstract void removeTest(Test t);
}