import java.util.LinkedList;

public class MyHashMap<K,V> {
    private int size = 16;
    private LinkedList<Entryy<K,V>>[] linkedLists;
    public MyHashMap(int size){
        this.size = size;
        linkedLists = new LinkedList[size];
        for(int i=0;i<size;i++){
            linkedLists[i] = new LinkedList<>();
        }
    }
    public void put(K key,V value){
        int index = key.hashCode()%size;
        LinkedList<Entryy<K,V>> linkedList = linkedLists[index];
        for(Entryy<K,V> entryy : linkedList){
            if(entryy.key.equals(key)){
                entryy.value = value;
                return;
            }
        }
        linkedList.add(new Entryy<>(key, value));
    }
    public V get(K key) {
        int index = key.hashCode()%size;
        LinkedList<Entryy<K,V>> bucket = linkedLists[index];
        for(Entryy<K,V> entry:bucket){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }
    public static class Entryy<K,V>{
        public K key;
        public V value;
        public Entryy(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5000];
        long start = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            int finalI = i;
            threads[i] = new Thread(()->{
                System.out.println("threads "+finalI+" is working.");
            });
            threads[i].start();
            threads[i].join();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println("!!!!!!!");
    }
}
