﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Thrift;
using Thrift.Protocol;
using Thrift.Server;
using Thrift.Transport;
using ThriftDemo.Interface;

namespace ThriftDemo.Server
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                //设置服务端口为8080
                TServerSocket serverTransport = new TServerSocket(8080);
                //设置传输协议工厂
                TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
                //关联处理器与服务的实现
                TProcessor processor = new HelloService.Processor(new MyHelloService());
                //创建服务端对象
                TServer server = new TThreadPoolServer(processor, serverTransport, new TTransportFactory(), factory);

                Console.WriteLine("服务端正在监听8080端口");
                server.Serve();

                Console.Read();
            }
            catch (TTransportException ex)//捕获异常信息
            {
                //打印异常信息
                Console.WriteLine(ex.Message);
            }
        }
    }
}
