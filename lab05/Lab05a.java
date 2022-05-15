import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lab05a implements Runnable{

    int minimos;

    public int getMinimos() {
        return minimos;
    }

    public void setMinimos(int minimos) {
        this.minimos = minimos;
    }

    public Lab05a(int[] vektor, int inf, int sup){
        int min = vektor[inf];
        for (int i = inf+1; i < sup; i++) {
            if(vektor[i]< min){
                min=vektor[i];
            }
        }
        setMinimos(min);
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        
        int[] vector;
        List<Integer> minFinal = new ArrayList<>();
        Scanner inputx = new Scanner(System.in);
        int readIntegers = inputx.nextInt();
        int numberThreads = inputx.nextInt();
        List<Thread> threadList = new ArrayList<>(numberThreads);
        vector = new int[readIntegers];
        for (int i = 0; i < readIntegers; i++) {
            vector[i] = inputx.nextInt();
        }
        inputx.close();

        List<Lab05a> procesos = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < numberThreads; i++) {
            procesos.add(new Lab05a(vector, (i * (readIntegers/numberThreads)),((i+1) * (readIntegers/numberThreads))));

            threadList.add(new Thread(procesos.get(i)));
            threadList.get(i).start();
            try {
                threadList.get(i).join();
                minFinal.add(procesos.get(i).getMinimos());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(minFinal.toString());
        System.out.println(Collections.min(minFinal));
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);

    }

}



