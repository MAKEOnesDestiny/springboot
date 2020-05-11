package strategic.support.utilities;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class OverrideExclusiveArrayList<E> extends AbstractList<E> implements ExclusiveList<E> {

    //note: not thread-safe
    public List<E> target;

    public OverrideExclusiveArrayList() {
        target = new ArrayList();
    }

    @Override
    public boolean add(E e, RepeatStrategic<E> strategic) {
        if (e == null) {
            return false;
        }
        for (int i = 0; i < target.size(); i++) {
            if(strategic.isEqual(e,target.get(i))){
                //相等则覆盖
                target.set(i,e);
                return true;
            }
        }
        //如果列表中还没有数据
        target.add(e);
        return true;
    }

    @Override
    public boolean add(E e) {
        return add(e, new ExclusiveList.RepeatStrategic<E>() {
        });
    }

    @Override
    public E get(int index) {
        return (E) target.get(index);
    }

    @Override
    public int size() {
        return target.size();
    }

    @Override
    public List reset() {
        target = new ArrayList<>();
        return this;
    }

}
