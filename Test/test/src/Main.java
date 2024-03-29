/*
 1.2-3 将编译程序分成若干个“遍”是为了（ ）。使程序的结构更加清晰
 1.2 -2通常一个编译程序中，不仅包含词法分析，语法分析，中间代码生成，代码优化，目 标代码生成等五个部分，还应包括（ ）。表格处理和出错处理
 1.1-1 编译程序绝大多数时间花在（ ） 上。表格管理
 1.3-1翻译程序和解释程序的最大区别是（）。是否生成目标代码
 1.2-1编译程序前三个阶段完成的工作是（ ）。词法分析、语法分析、语义分析和中间代码生成
 与编译系统相比，解释系统（ ）。比较简单 , 可移植性好 , 执行速度慢
 1.1-2 编译程序是一种（ ）。翻译程序
 1.1-3（ ）不是编译程序的组成部分。设备管理程序
1.1一个上下文无关文法 G 包括四个组成部分，它们是：一组非终结符，一组终结符号， 一个开始符号，以及一组（ ）。产生式
1.5文法G产生的（ ）的全体是该文法描述的语言。句子
2.2 文法 G 所描述的语言是（ ）的集合。由文法的开始符号推出的所有终结符串
2.3文法G：S→xSx|y 所识别的语言是（ ）。x(n)yx(n)
2.1文法 G[N]= （ {b} ， {N ， B} ， N ， {N→b│ bB ， B→bN} ），该文法所描述 的语言是( ) L(G[N])={b(2i+1)│ i ≥ 0}
1.4( )被称为规范推导，对应的句型称为规范句型。最右推导
4.1 描述语言L={1(n)0(m)1(m)0(n)| n ，m>=0 }的文法为（ ）。S→1S0|A  A→0A1|ε
3.2 描述语言L ={a(n)b(n)c(i)|n≥1,i≥0}的文法为 （ ）。S→AB  A→aAb|ab B→cB|ε
2.5 $$已知文法G[S]：
S->Ac|aB
A->ab
B->bc
该文法描述的元素是（ ）。abc
2.6∗文法G[N]：
N->D|ND
D->0|1|2|3|4|5|6|7|8|9
G[N]描述的语言是（ ）。0~9组成的数字串
3.3 ∗设有文法G[S]：S->SS∗|SS+|a，符号串aa+a*规范推导是（ ）。
S => SS ∗   => Sa∗=> SS+a ∗=> Sa+a ∗=> aa+a*
1.2 文法G产生的( )的全体是该文法描述的语言。句子
1.3 若文法G定义的语言是无限集，则文法必然是( )。递归的
3.1文法G为:E-> E+F+E|k
F->F∗k|k
下面( )是句子k+k∗k+k的最右推导。
E=>E+F+E=>E+F+k=>E+F∗k+k=>E+k∗k+k=>k+k∗k+k



2-2.1 ∗已知文法G：

<表达式>::=<项>｜<表达式>＋<项>

<项>::=<因子>｜<项>*<因子>

<因子>::=（<表达式>）｜i

则表达式i+i*i的最左推导和语法树分别是( )
1.<表达式> => <表达式>＋<项> => <项>＋<项> =><因子>＋<项> => i+<项>=>i＋<项>∗<因子>=> i＋<因子>∗<因子>=> i＋i∗<因子>=> i＋i*i
2.（图片的列从左到右，从上到下）表达式 项 因子 i -> + -> 项 因子 i -> * -> 因子 i
    即
                       <表达式>
             <表达式>       +          <项>
              <项>                 <项>  *  <因子>
              <因子>                <因子>      i
              i                       i

2-1.1 ∗已知文法G[S]为：
S→Ac|aB
A→ab
B→bc
给定句子abc，其语法树是（ ），请问该文法（ ）二义性文法。
（图片的列从左到右，从上到下）
1.S -> a -> B b c

            S
        a       B
            b       c

2.S -> A a b -> c
            S
        A       c
      a    b
3.是

2-2.2 ∗已知文法G：
E→E+T|E-T|T

T→T∗F | T/F | F

F→(E)|i

（1）表达式 i∗i+i 的最左推导是( )

（2）表达式 i∗i+i 的语法树是( )

（1）E=>E+T=>T+T=>T∗F+T=>F∗F+T=>i∗F+T=>i∗i+T=>i∗i+F=>i∗i+i
（2）     E
    E     +         T
    T               F
 T   *  F           i
 F      i
 i


  2-1.4设有文法G[S]：S->S*S|S+S|(S)|a，

给定句子a+a*a，其语法树是（ ） ，请问该文法（ ）二义性文法 。
1.
                            S
                    S       *       S
          S       +      S          a
          a              a

 2.                     S
                S       +       S
                a           S   *   S
                            a       a
3.是


 */
/*小C语言--词法分析程序
 Input
输入一个小C语言源程序，源程序长度不超过2000个字符，保证输入合法。

Output
按照源程序中单词出现顺序输出，输出二元组形式的单词串。

(单词种类,单词值)

单词一共5个种类：

关键字：用keyword表示
自定义标识符：用identifier表示
整数：用integer表示
界符：用boundary表示
运算符：用operator表示

每种单词值用该单词的符号串表示。



#include<bits/stdc++.h>

using namespace std;

string S[6] = {"main", "for", "if", "else", "int", "while"};

void display(string s)
{
    if(s[0] >= '0' && s[0] <= '9')

        cout<<"(integer,"<<s<<")"<<endl;
    else
    {
        int flag = 1;
        for(int i = 0; i < 6; i++)
        {
            if(s == S[i])
            {
                flag = 0;
                cout<<"(keyword,"<<s<<")"<<endl;
            }
        }
        if(flag == 1)
            cout<<"(identifier,"<<s<<")"<<endl;
    }
}

int main()
{
    string s;
    while(cin>>s)
    {
        int len = s.length();
        string a = "";
        for(int i = 0; i < len; i++)
        {
            if(s[i] == '=' || s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/' || s[i] == '<' || s[i] == '>' || s[i] == '!')
            {
                if(a.length())
                    display(a);
                a = "";
                if(i + 1 < len && s[i + 1] == '=')
                {
                    cout<<"(operator,"<<s[i]<<s[i + 1]<<")"<<endl;
                    i++;
                }
                else
                    cout<<"(operator,"<<s[i]<<")"<<endl;

            }
            else if(s[i] == '(' || s[i] == ')' || s[i] == '{' || s[i] == '}' || s[i] == ',' || s[i] == ';')
            {
                if(a.length())
                    display(a);
                a = "";
                cout<<"(boundary,"<<s[i]<<")"<<endl;
            }
            else
                a = a + s[i];
        }
        if(a.length())
            display(a);
    }
    return 0;
}

*/
