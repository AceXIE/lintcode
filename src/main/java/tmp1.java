///**
// * Created by xk on 2016/3/31.
// */
//public class tmp1 {
//    public static void main(String[] args) {
//        #include <iostream>
//        #include <stdlib.h>
//
//        using namespace std;
//
///* run this program using the console pauser or add your own getch, system("pause") or input loop */
//
//        int findfirstnot(int * a, int begin, int end)
//        {
//            for(int i=begin; i<=end; i++)
//            {
//                if(*(a+i) != i)
//                {
//                    return i;
//                }
//            }
//            return 0;
//
//        }
//
//        void myswap(int *a, int *b)
//        {
//            int tmp=*a;
//            *a=*b;
//            *b=tmp;
//        }
//
//        int main(int argc, char** argv) {
//            int N;
//            cin>>N;
//            int *a=(int *)malloc((N+1)*sizeof(int));
//            for(int i=0; i<N; i++)
//            {
//                int tmp;
//                cin>>tmp;
//                *(a+i)=tmp;
//            }
//
//            int cur=findfirstnot(a,1,N-1);
//            int cnt=0;
//            while(cur !=0 )
//            {
//                if(*a == 0)
//                {
//                    myswap(a, a+cur);
//                    cnt++;
//                }
//                while(*a != 0)
//                {
//                    int curtoswap=*a;
//                    myswap(a,a+curtoswap);
//                    cnt++;
//                }
//                cur=findfirstnot(a,cur,N-1);
//            }
//            cout<<cnt<<endl;
//
//            return 0;
//        }
//    }
//}
