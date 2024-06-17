public class QueuePasien23 {
    Pasien23[] antrian;
    int front, rear, size, max;

    public QueuePasien23(int n) {
        max = n;
        antrian = new Pasien23[max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty() {
        return size == 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(Pasien23 p) {
        if (isFull()) {
            System.out.println("Antrian sudah penuh");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % max;
            }
            antrian[rear] = p;
            size++;
            System.out.println("Pasien " + p.nama + " berhasil ditambahkan ke dalam antrian");
        }
    }

    public Pasien23 dequeue() {
        Pasien23 p = null;
        if (isEmpty()) {
            System.out.println("Antrian masih kosong");
        } else {
            p = antrian[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % max;
            }
            size--;
        }
        return p;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(antrian[i].nama + " " + antrian[i].noID + " " + antrian[i].jenisKelamin + " " + antrian[i].umur);
                i = (i + 1) % max;
            }
            System.out.println(antrian[i].nama + " " + antrian[i].noID + " " + antrian[i].jenisKelamin + " " + antrian[i].umur);
        }
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println("Pasien terdepan: " + antrian[front].nama);
        } else {
            System.out.println("Antrian masih kosong");
        }
    }

    public void peekRear() {
        if (!isEmpty()) {
            System.out.println("Pasien terbelakang: " + antrian[rear].nama);
        } else {
            System.out.println("Antrian masih kosong");
        }
    }

    public void peekPosition(String nama) {
        if (!isEmpty()) {
            for (int i = front; i != rear; i = (i + 1) % max) {
                if (antrian[i].nama.equals(nama)) {
                    System.out.println("Posisi antrian pasien " + nama + " : " + ((i - front + max) % max + 1));
                    return;
                }
            }
            if (antrian[rear].nama.equals(nama)) {
                System.out.println("Posisi antrian pasien " + nama + " : " + ((rear - front + max) % max + 1));
            } else {
                System.out.println("Pasien " + nama + " tidak ditemukan dalam antrian");
            }
        } else {
            System.out.println("Antrian masih kosong");
        }
    }

    public void daftarPasien() {
        if (!isEmpty()) {
            System.out.println("Daftar Pasien:");
            int i = front;
            while (i != rear) {
                System.out.println(antrian[i].nama + " " + antrian[i].noID + " " + antrian[i].jenisKelamin + " " + antrian[i].umur);
                i = (i + 1) % max;
            }
            System.out.println(antrian[i].nama + " " + antrian[i].noID + " " + antrian[i].jenisKelamin + " " + antrian[i].umur);
        } else {
            System.out.println("Antrian masih kosong");
        }
    }
}