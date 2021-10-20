package main.java.tuple;

import java.util.Objects;

/**
 * Class for storing a tuple of 2 elements (item1, item2).
 */
public class Tuple2<T1, T2> {

    private T1 item1;
    private T2 item2;

    public Tuple2(T1 item1, T2 item2)
    {
        this.item1 = item1;
        this.item2 = item2;
    }

    public T1 getItem1() {
        return item1;
    }

    public T2 getItem2() {
        return item2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.equals(item1, tuple2.item1) && Objects.equals(item2, tuple2.item2);
    }
}
