class LinkedList {
    private Character letter;
    private LinkedList next;

    // Constructor
    public LinkedList(String name) {
        if (name != null && name.length() > 0) {
            letter = name.charAt(0);
            LinkedList current = this;
            for (int i = 1; i < name.length(); i++) {
                current.next = new LinkedList(name.charAt(i));
                current = current.next;
            }
        }
    }


    private LinkedList(char letter) {
        this.letter = letter;
        this.next = null;
    }

    public void removeFirstChar() {
        if (next != null) {
            letter = next.letter;
            next = next.next;
        } else {
            letter = null;
        }
    }

    public void print() {
        LinkedList current = this;
        while (current != null && current.letter != null) {
            System.out.print(current.letter);
            current = current.next;
        }
    }


    public boolean isEmpty() {
        return letter == null;
    }
}
