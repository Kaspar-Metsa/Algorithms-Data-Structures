package treeGraphs.general_binaryTreeTraversal.recurrence_relation;

public class Recurrence_n {
    /*
        Tracing Tree
        Test(3)
        /     \
    print 3   Test(2)
             /        \
        print 2       Test(1)
                     /      \
                print 1     Test(0)
                              |
                              x

      Recurrence relation:
        T(n)=C+T(n-1) where C is constant: if condition and printing out

        T(n)= T(n-1) + C when n>0
        T(n)= C          when n=0

      We solve recurrence relation by substitution
        T(n)= T(n-1) + C
        T(n-1)= T(n-2) + C
            We substitute T(n-1): T(n)=[T(n-2)+C]+C=T(n-2)+2C=T(n-2)+2C
        T(n-2)= T(n-3) + C
            We substitute T(n-2): T(n)=T(n-2)+C=[T(n-3)+C]+C=T(n-3)+3C
        ... we continue for k times
        T(n)=T(n-k)+k*C=T(n-k)+k
            We can assume n-k=0 => n=k
        T(n)=T(n-n)+n=T(0)+n=1+n => O(n), theta of n, MOTT

    */
    public void Test(int n) {
        if (n > 0) {
            System.out.printf("%d", n);
            Test(n - 1);
        }
    }
}
