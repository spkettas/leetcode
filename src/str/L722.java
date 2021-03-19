package str;

import util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * 722. 删除注释
 * 给一个 C++ 程序，删除程序中的注释。这个程序source是一个数组，其中source[i]表示第i行源码。 这表示每行源码由\n分隔。
 *
 * \/**\/ //
 *
 * 1.只需分析两种注释的起始条件，对第行代码处理
 */
public class L722 {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        if (source == null || source.length == 0)  return ans;

        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();

        for (String line : source) {
            int i = 0;
            char[] s = line.toCharArray();

            if (!inBlock) sb = new StringBuilder();     // &&& reset

            // while
            while (i < s.length) {
                if (!inBlock && i < s.length - 1 && s[i] == '/' && s[i+1] == '*') {  // /*
                    inBlock = true;
                    i++;
                } else if (inBlock && i < s.length - 1 && s[i] == '*' && s[i+1] == '/') { // */
                    inBlock = false;
                    i++;
                } else if (!inBlock && i < s.length - 1 && s[i] == '/' && s[i+1] == '/') { //
                    break;
                } else if (!inBlock) {  // &&& !inBlock
                    sb.append(s[i]);
                }

                i++;
            }

            if (!inBlock && sb.length() > 0) {
                ans.add(sb.toString());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] sources = {"/*Test program */",
                "int main()",
                "{ ",
                "  // variable declaration ",
                "int a, b, c;",
                "/* This is a test",
                "   multiline  ",
                "   comment for ",
                "   testing */",
                "a = b + c;",
                "}"
        };

        L722 l = new L722();
        var res = l.removeComments(sources);
        MyPrint.showStrs(res);
    }
}
