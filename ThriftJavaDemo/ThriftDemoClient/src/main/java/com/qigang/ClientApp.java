package com.qigang;

import com.qigang.thrift.HelloService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Hello world!
 *
 */
public class ClientApp
{
    public static void main( String[] args )
    {
        try {
            /// 设置调用的服务地址为本地，端口为 7911
            TTransport transport = new TSocket("localhost", 8080);
            transport.open();
            // 设置传输协议为 TBinaryProtocol
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloService.Client client = new HelloService.Client(protocol);
            // 调用服务的 helloVoid 方法
            String result = client.HelloString("this is test string");
            System.out.println(result);
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
