class Node {
    LinkedList name;  // Harf harf tutulan isim (oyun sırasında harf kaybeder)
    String fullName;
    Node next;        // Bir sonraki düğüm referansı

    public Node(String name) {
        this.fullName = name;  // Tam ismi sakla
        this.name = new LinkedList(name);  // Harf harf tutulan isim
        this.next = null;
    }

    // isöin bir harf kaybetmesi
    public void loseLetter() {
        name.removeFirstChar();
    }

    // ismin eksilmiş halini göster
    public void printCurrentName() {
        name.print();
    }

    // harf kalıp kalmadığını kontrol et
    public boolean hasLettersLeft() {
        return !name.isEmpty();
    }

    // full ismi geri döndür
    public String getFullName() {
        return fullName;
    }
}
