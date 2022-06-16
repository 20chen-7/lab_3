package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, SLList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = (int) Ns.get(i);
            double time = times.get(i);
            int opCount = (int) opCounts.getLast(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Double> times = new AList();
        AList Ns = new AList();
        SLList ns = new SLList();
        SLList opCounts = new SLList();
        int M = 10000;
        for(int j = 1000; j <= 128000; j *= 2){
            ns.addLast(j);
            Ns.addLast(j);

            Stopwatch sw = new Stopwatch();
            for(int i = 0; i <= M ;i += 1) {
                opCounts.addLast(i);
                ns.getLast(i);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);


        }printTimingTable(Ns,times,opCounts);


    }

}
