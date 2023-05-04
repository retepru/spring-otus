package ru.otus.spring.io;

public class ConsoleOutImpl implements ConsoleOut{
    @Override
    public void out(String out) {
        System.out.print(out);
    }

    @Override
    public void outln(String out) {
        out(out+ "\n");
    }
}
