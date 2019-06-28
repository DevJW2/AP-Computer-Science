public interface List{
    //void add(int newVal);
    //void add(int index, int newVal);
    boolean add(Object x);
    Object get(int index);
    Object set(int index, Object o);
    //void remove(int index);
    int size();
}
