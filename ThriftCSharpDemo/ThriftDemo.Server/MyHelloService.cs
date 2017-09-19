using System;
using ThriftDemo.Interface;

namespace ThriftDemo.Server
{
    public class MyHelloService : HelloService.Iface
    {
        public bool HelloBoolean(bool para)
        {
            Console.WriteLine("客户端调用了HelloBoolean方法");

            return para;
        }

        public int HelloInt(int para)
        {
            Console.WriteLine("客户端调用了HelloInt方法");

            return para;
        }

        public string HelloNull()
        {
            Console.WriteLine("客户端调用了HelloNull方法");

            return null;
        }

        public string HelloString(string para)
        {
            Console.WriteLine("客户端调用了HelloString方法");

            return para;
        }

        public void HelloVoid()
        {
            Console.WriteLine("客户端调用了HelloVoid方法");

            Console.WriteLine("HelloWorld");
        }
    }
}
