#include <iostream>
#include <string>


/**
 * __二进制转十六进制
 */
std::string BinToHex(const std::string &strBin, bool bIsUpper)
{
 std::string strHex;
 strHex.resize(strBin.size() * 2);

 for (size_t i = 0; i < strBin.size(); i++)
 {
     uint8_t cTemp = strBin[i];

     for (size_t j = 0; j < 2; j++)
     {
         uint8_t cCur = (cTemp & 0x0f);

         // 分两种情况
         if (cCur < 10)
         {
             cCur += '0';
         }
         else
         {
             cCur += ((bIsUpper ? 'A' : 'a') - 10); // 大小写-10
         }

         strHex[2 * i + 1 - j] = cCur;
         cTemp >>= 4;
     }
 }

 return strHex;
}


// 十六进制转二进制
std::string HexToBin(const std::string &strHex)
{
    if (strHex.size() % 2 != 0)
    {
        return "";
    }

    std::string strBin;
    strBin.resize(strHex.size() / 2);

    for (size_t i = 0; i < strBin.size(); i++)
    {
        uint8_t cTemp = 0;

        for (size_t j = 0; j < 2; j++)
        {
            char cCur = strHex[2 * i + j];

            if (cCur >= '0' && cCur <= '9')
            {
                cTemp = (cTemp << 4) + (cCur - '0'); // cTemp<<4 较巧妙
            }
            else if (cCur >= 'a' && cCur <= 'f')
            {
                cTemp = (cTemp << 4) + (cCur - 'a' + 10);
            }
            else if (cCur >= 'A' && cCur <= 'F')
            {
                cTemp = (cTemp << 4) + (cCur - 'A' + 10);
            }
            else
            {
                return "";
            }
        }

        strBin[i] = cTemp;
    }

    return strBin;
}

/// main
int main(int argc, char **argv) {
    auto sBin = HexToBin("fecd98");
    auto sRet = BinToHex(sBin, true);
    std::cout << sRet << std::endl;

    return 0;
}
