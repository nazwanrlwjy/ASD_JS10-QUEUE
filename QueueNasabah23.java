public class QueueNasabah23 {
    Nasabah23[] data;
    int front;
    int rear;
    int size;
    int max;

    public QueueNasabah23(int n) {
        max = n;
        data = new Nasabah23[max];
        size = 0;
        front = rear = -1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == max);
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println("Elemen Terdepan: " + data[front].norek + " " + data[front].nama + " "+ data[front].alamat + " " + data[front].umur + " " + data[front].saldo );
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            do {
                System.out.println(data[i].norek + " " + data[i].nama + " "+ data[i].alamat + " " + data[i].umur + " " + data[i].saldo );
                i = (i + 1) % max;
            } while (i != (rear + 1) % max);
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void clear() {
        if (isEmpty()) {
            System.out.println("Queue sudah kosong");
        } else {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        }
    }

    public void Enqueue(Nasabah23 dt) {
        if (isFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % max;
            }
            data[rear] = dt;
            size++;
        }
    }

    public Nasabah23 Dequeue() {
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
            return null;
        } else {
            Nasabah23 dt = data[front];
            size--;
            if (isEmpty()) {
                front = rear = -1;
            } else {
                front = (front + 1) % max;
            }
            return dt;
        }
    }

    public void peekRear() {
        if (!isEmpty()) {
            System.out.println("Elemen Paling Belakang: " + data[rear].norek + " " + data[rear].nama + " " + data[rear].alamat + " " + data[rear].umur + " " + data[rear].saldo);
        } else {
            System.out.println("Queue masih kosong");
    }
}

