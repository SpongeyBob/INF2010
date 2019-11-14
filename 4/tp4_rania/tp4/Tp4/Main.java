package Tp4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    /**
     * Fonction principale
     */
    public static void main(String[] args) {
        // Creer un monceau avec 22 éléments et un tableau équivalent
        int numItems = 22;
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(true);

        Integer[] items = new Integer[numItems];

        int i;
        int j;

        // En insérant les éléments un a un
        for (i = 11, j = 0; j != numItems; i = (i + 37), j++) {
            heap.offer(i);
            items[j] = i;
            i %= numItems;
        }

        // en construisant le monceau depuis le depart
        System.out.println("Monceau min contruit element par element:");
        System.out.println(heap.printFancyTree());

        heap = new BinaryHeap<Integer>(false);
        // en inserant les elements un a un
        for (Integer item : items)
            heap.offer(item);

        // en construisant le monceau depuis le depart
        System.out.println("Monceau max contruit element par element:");
        System.out.println(heap.printFancyTree());

        heap = new BinaryHeap<Integer>(items, false);
        System.out.println("Monceau max contruit a partir d'un tableau:");
        System.out.println(heap.printFancyTree());

        heap = new BinaryHeap<Integer>(items, true);
        System.out.println("Monceau min contruit a partir d'un tableau:");
        System.out.println(heap.printFancyTree());

        System.out.println();
        System.out.println("Affichage recursif:");
        System.out.println(heap.printFancyTree());

        System.out.println("Affichage non recursif:");
        System.out.println(heap.nonRecursivePrintFancyTree());

        System.out.println();
        System.out.println("Tableau d'origine:");
        System.out.println(printArray(items));

        BinaryHeap.heapSort(items);
        System.out.println("Tableau ordonne:");
        System.out.println(printArray(items));

        BinaryHeap.heapSortReverse(items);
        System.out.println("Tableau inversement ordonne:");
        System.out.println(printArray(items));


        PriorityQueue pq = new PriorityQueue();
        BinaryHeap<Integer> bh = new BinaryHeap(true);

        boolean success = true;

        for (i = 0; i < 11; ++i) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 65);
            pq.offer(randomNum);
            bh.offer(randomNum);
        }
        ArrayList<Integer> list = new ArrayList<>();
        Iterator it = bh.iterator();
        while(it.hasNext()){
            list.add((Integer)it.next());
        }
        ArrayList<Integer> list2 = bh.getArrayList();
        if(list.equals(list2))System.out.println("\n\nyour iterator looks good!\n");


        for (i = 0; i < 11; ++i) {
            Integer pqPoll = (Integer) pq.poll();
            Integer bhPoll = bh.poll();
            if (!bhPoll.equals(pqPoll)) {
                success = false;
            }
            System.out.print("bhPoll : " + bhPoll);
            System.out.println(" || PqPoll : " + pqPoll);
            //System.out.println(bh.printFancyTree());

        }
        if (success) System.out.println("you have succeeded in implementing poll() to your BinaryHeap !");
    }

    private static <AnyType> String printArray(AnyType[] a) {
        String outputString = "";

        for (AnyType item : a) {
            outputString += item;
            outputString += ", ";
        }

        return outputString.substring(0, outputString.length() - 2);
    }
}
