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
            list = list.next;
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

    public void split(Node head) {
        Node p = head;
        int size = head.size(head);
        System.out.println("first half:");
        int i = 0;
        while (i < size) {
            System.out.print(p.data + " ");
            p = p.next;
            i++;
            if (i == size/2) {
                System.out.println();
                System.out.println("Second half:");
            }
        }
    }
    public Node getLast(Node head) {
        Node p = head;
        while(p.next != null) {
            p = p.next;
        }
        return p;
    }

    public int maxFromBoth(Node head1, Node head2) {
        int max = Integer.MIN_VALUE;
        Node p = head1;
        while(p != null) {
            if (p.data > max) {
                max = p.data;
            }
            p = p.next;
        }
        Node q = head2;
        while(q != null) {
            if (q.data > max) {
                max = q.data;
            }
            q = q.next;
        }
        return max;
    }

    
    public int secondLast(Node head) {
        Node p = head;
        while(p.next.next != null) {
            p = p.next;
        }
        return p.data;
    }
    
    public int lowest(Node head) {
        int min = Integer.MAX_VALUE;
        Node p = head;
        while(p != null) {
            if (p.data < min) {
                min = p.data;
            }
            p = p.next;
        }
        return min;
    }
    public Node insertUnsorted(int data, Node head) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = head;
            return newNode;
        }
        Node p = head;
        while(p.next != null) {
            p = p.next;
        }
        p.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head = head.insertUnsorted(9, head);
        head = head.insertUnsorted(5, head);
        head = head.insertUnsorted(1, head);
        head = head.insertUnsorted(0, head);

        head.print(head);
    }
}