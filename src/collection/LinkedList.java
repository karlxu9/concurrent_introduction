package collection;

/**
 * 简单的链表结构
 *
 * @param <E>
 */
public class LinkedList<E> {

    transient Node<E> last;
    transient Node<E> first;

    int size = 0;


    public void put(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public Node<E> get(int index) {
        return node(index);
    }

    Node<E> node(int index) {
        Node<E> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.put(1);
        list.put(2);
        Node<Integer> integerNode = list.get(0);
        System.out.println(integerNode.item);

        // 容量
        int n = 16;
        int h;
        String key = "zhangsan";
        // 取模运行
        System.out.println(((h = key.hashCode()) ^ (h >>> 16)) % n);
        // 与预算
        System.out.println(((h = key.hashCode()) ^ (h >>> 16)) & (n - 1));

    }

}
