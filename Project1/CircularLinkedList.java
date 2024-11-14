class CircularLinkedList {
    Node head;
    int size;

    public CircularLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Başa yeni bir düğüm ekle
    public void add(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    public Node playTurn(int k) {
        if (head == null || size == 0) return null;

        Node temp = head;
        Node prev = null;

        for (int i = 1; i < k; i++) {
            prev = temp;
            temp = temp.next;
        }

        temp.loseLetter();

        System.out.println(temp.getFullName() + " lost a letter!");

        if (!temp.hasLettersLeft()) {
            System.out.println(temp.getFullName() + " was eliminated.");
            if (temp == head) {
                if (size == 1) {
                    head = null;
                } else {
                    Node tail = head;
                    while (tail.next != head) {
                        tail = tail.next;
                    }
                    head = head.next;
                    tail.next = head;
                }
            } else {
                prev.next = temp.next;
            }
            size--;
        }

        return temp;
    }

    public Node findWinner() {
        System.out.println("Congratulations! The winner of the game is: " + head.getFullName());
        return head;
    }

    public void printList(Node current) {
        if (head == null || head.next == head) {
            return;
        }

        Node temp = head;
        do {
            temp.printCurrentName();
            if (temp.next != head) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }



    // listenin boyutu
    public int getSize() {
        return size;
    }
}
