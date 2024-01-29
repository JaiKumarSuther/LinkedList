import java.util.ArrayList;

public class Node {
    int data;
    Node next;

    Node() {

    }

    Node(int data) {
        this.data = data;
    }

    public Node insert(int data, Node head) {
        Node newNode = new Node(data);
        if (head == null || data < head.data) {
            newNode.next = head;
            return newNode;
        } else {
            Node p = head;
            while (p.next != null && p.next.data < data) {
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
            return head;
        }
    }

    public int size(Node list) {
        int size = 0;
        while (list != null) {
            size++;
        }
        return size;
    }

    public Node delete(int index, Node head) {
        if (index == 1) {
            return head.next;
        }
        int pos = 1;
        Node p = head;
        while (pos < index - 1) {
            p = p.next;
            pos++;
        }
        p.next = p.next.next;
        return head;
    }

    public Node pop(Node head) {
        Node p = head;
        if (p.next == null) {
            return null;
        }
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
        return head;
    }

    public void print(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.print("null");
    }

    public Node mergeList(Node head1, Node head2) {
        // Node p = head2;
        // while(p != null) {
        // head1.insert(p.data, head1);
        // p = p.next;
        // }
        // return head1;
        for (Node q = head2; q != null; q = q.next) {
            head1 = head1.insert(q.data, head1);
        }
        return head1;
    }

    Node delete(Node head, int data) {
        if (head == null || head.data > data) {
            return head;
        }
        Node p = head;
        if (p.data == data) {
            return p.next;
        }
        while (p != null) {
            if (p.data > data) {
                break;
            }
            if (p.next.data == data) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        return head;
    }

    public Node addList(Node head1, Node head2) {
        Node p = head1;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head2;

        return head1;
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr.next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean search(int data, Node head) {
        if (head == null || head.data > data) {
            return false;
        }
        Node p = head;
        while (p != null) {
            if (p.data == data) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public Node replace(int data, int index, Node head) {
        int pos = 1;
        Node p = head;
        while (pos < index) {
            p = p.next;
            pos++;
        }
        p.data = data;
        return head;
    }

    public int sum(Node head) {
        Node p = head;
        int sum = 0;
        while (p != null) {
            sum += p.data;
            p = p.next;
        }
        return sum;
    }

    public int oddSum(Node head) {
        int sum = 0;
        Node p = head;
        while (p != null) {
            sum += p.data;
            if (p.next == null) {
                break;
            }
            p = p.next.next;

        }
        return sum;
    }

    public int evenSum(Node head) {
        int sum = 0;
        Node p = head.next;
        while (p != null) {
            sum += p.data;
            if (p.next == null) {
                break;
            }
            p = p.next.next;
        }
        return sum;
    }

    public Node copy(Node head) {
        Node p = head;
        Node copy = new Node();
        while (p != null) {
            copy.insert(p.data, copy);
            p = p.next;
        }
        return copy;
    }

    public Node subList(Node head, int start, int end) {
        Node mynewlist = null;
        int si = 0;
        Node p = head;

        while (si < start && p.next != null) {
            p = p.next;
            si++;
        }

        while (si <= end && p != null) {
            mynewlist = insert(p.data, mynewlist);
            p = p.next;
            si++;
        }
        return mynewlist;
    }

    public Node shuffle(Node list) {
        ArrayList<Integer> arrlist = new ArrayList<>();
        Node q = list;

        while (q != null) {
            arrlist.add(q.data);
            q = q.next;
        }

        int[] arr = new int[arrlist.size()];
        int i = 0;
        while (arrlist.size() != 0) {
            int rand = (int) (Math.random() * arrlist.size());
            arr[i] = arrlist.get(rand);
            arrlist.remove(rand);
            i++;
        }

        Node mylist = null;
        Node p = null;

        for (int j = 0; j < arr.length; j++) {
            if (mylist == null) {
                mylist = new Node(arr[j]);
                p = mylist;
            } else {
                p.next = new Node(arr[j]);
                p = p.next;
            }
        }

        return mylist;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head = head.insert(2, head);
        head = head.insert(3, head);
        head = head.insert(4, head);
        head = head.insert(5, head);
        head = head.insert(6, head);
        head = head.insert(7, head);

        head = head.shuffle(head);
        head.print(head);
    }
}