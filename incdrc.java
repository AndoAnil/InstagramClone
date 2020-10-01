class incdrc
{
public static void main(String args[])
{
int a=1;
int b=2;
int c;
int d;
byte f=8;
f+=2.5;
c=++b;
d=a++ + b++ - c++ + ++a - b-- + c-- + b++;
c++;
int e=2;
e-=2;
System.out.println("a = "+ a++);
System.out.println("b = "+b);
System.out.println("c = "+c);
System.out.println("d = "+d);
System.out.println("e = "+e);
System.out.println("f = "+f);
}
}
