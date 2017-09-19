package com.qigang.thrift.impl;

import com.qigang.thrift.HelloService;
import org.apache.thrift.TException;

public class MyHelloService implements HelloService.Iface {
    @Override
    public String HelloString(String para) throws TException {
        System.out.println("HelloString is called...");
        return para;
    }

    @Override
    public int HelloInt(int para) throws TException {
        System.out.println("HelloInt is called...");
        return para;
    }

    @Override
    public boolean HelloBoolean(boolean para) throws TException {
        System.out.println("HelloBoolean is called...");
        return para;
    }

    @Override
    public void HelloVoid() throws TException {
        System.out.println("HelloVoid is called...");
    }

    @Override
    public String HelloNull() throws TException {
        System.out.println("HelloNull is called...");
        return null;
    }
}
