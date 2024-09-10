package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Before;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    private  BuggyAList<Integer> new_BuggyAList;
    private AListNoResizing<Integer> new_AListNoResizing;
    @Before
    public void setUp()
    {
        new_BuggyAList = new BuggyAList<>();
        new_AListNoResizing = new AListNoResizing<>();
    }
    @Test
    public void testThreeAddThreeRemove()
    {
        for(int i = 0; i < 3; i++)
        {
            new_AListNoResizing.addLast(i);
            new_BuggyAList.addLast(i);
        }
        int removeItem;
        for (int j = 2; j >= 0; j--)
        {
            removeItem = new_AListNoResizing.removeLast();
            assertEquals(j,removeItem);
            removeItem = new_BuggyAList.removeLast();
            assertEquals(j,removeItem);
        }
    }
    @Test
    public void randomizedTest()
    {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyL.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size_L = L.size();
                int size_buggyL = buggyL.size();
                //System.out.println("size of L: " + size_L);
                //System.out.println("size of buggyL:" + size_buggyL);
            } else if (operationNumber == 2) {
                if (L.size() > 0)
                {
                    int last_L = L.getLast();
                    int last_buggyL = buggyL.getLast();
                    //System.out.println("getLast(" + last_L + ")" + "--L");
                    //System.out.println("getLast(" + last_buggyL + ")" + "--buggyL");
                }
            } else if (operationNumber == 3) {
                if (L.size() > 0)
                {
                    int rmLast_L = L.getLast();
                    int rmLast_buggyL = buggyL.getLast();
                    L.removeLast();
                    buggyL.removeLast();
                    //System.out.println("removeLast(" + rmLast_L + ")" + "--L");
                    //System.out.println("removeLast(" + rmLast_buggyL + ")" + "--buggyL");
                }
            }
        }
    }
}
