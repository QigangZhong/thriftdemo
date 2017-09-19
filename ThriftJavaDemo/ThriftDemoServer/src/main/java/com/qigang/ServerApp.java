package com.qigang;

import com.qigang.thrift.HelloService;
import com.qigang.thrift.impl.MyHelloService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Hello world!
 *
 */
public class ServerApp
{
    public static void main( String[] args )
    {
        try {
            // 设置服务端口为 8080
            TServerSocket serverTransport = new TServerSocket(8080);
            // 设置协议工厂为 TBinaryProtocol.Factory
            TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
            // 关联处理器与 HelloService 服务的实现
            TProcessor processor = new HelloService.Processor(new MyHelloService());

            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverTransport);
            tArgs.processor(processor);
            tArgs.protocolFactory(factory);

            TServer server = new TThreadPoolServer(tArgs);
            System.out.println("Start server on port 8080...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
