import java.util.Scanner;

public class BaiTap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key;
        do{
            System.out.println("1: Tính chiều dài cạnh huyền của một tam giác vuông");
            System.out.println("2: Tính giá trị đơn thức P(x) = ax^n với 8x cho trước");
            System.out.println("3: Tính nhập số nguyên dương n với 2 ký số");
            System.out.println("4: Tính gi trị trung bình của 5 số nđược nhập từ bàn phím");
            System.out.println("5: Tính độ C Sang Độ F");
            System.out.println("6: Tính tỉ giá VND-USD");
            System.out.println("Chọn 1 Chương Trình :");
            key = sc.nextInt();
            if(key < 1){
                System.out.println("Vui lòng nhập số bài lớn hơn 0");
            }
            switch (key) {
                case 1 :
                    Bai1();
                    break;
                case 2 :
                    Bai2();
                    break;
                case 3 :
                    Bai3();
                    break;
                case 4 :
                    Bai4();
                    break;
                case 5 :
                    Bai5();
                    break;
                case 6 :
                    Bai6();
                    break;
                default :
                    System.out.println("Vui lòng nhập lại!!!");
            }
        }while (key != 0);
    }

    public static void Bai1() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập cạnh A: ");
        double a = sc.nextDouble();

        System.out.println("Nhập cạnh B: ");
        double b = sc.nextDouble();

        double c = Math.sqrt(a * a + b * b);

        System.out.printf("Chiều dài cạnh huyền là: %.2f\n", c);
    }

    public static void Bai2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập A :");
        double a = sc.nextDouble();

        System.out.println("Nhập X : ");
        double x = sc.nextDouble();

        System.out.println("Nhập N : ");
        int n = sc.nextInt();

        if(n < 0){
            System.out.println("Số N phải là số nguyên âm!");
        }else{
            double result = a * Math.pow(x, n);
            System.out.printf("Giá trị của P(%.2f) = %.2f * %.2f^%d là: %.2f\n", x, a, x, n, result);
        }
    }

    public static void Bai3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 2 Số Nguyên Dương : ");
        int a = sc.nextInt();
        if(a < 10 || a > 99){
            System.out.println("Vui lòng nhập 2 chữ số từ 10 đến 99");
        }else{
            int hangChuc = a / 10;
            int hangDonVi = a % 10;
            int sum = hangChuc + hangDonVi;

            System.out.printf("Tổng 2 ký s của %d là: %d\n", a, sum);
        }
    }

    public static void Bai4(){
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        double sum = 0;

        for(int i = 0; i < a.length; i++){
            System.out.printf("Nhập số thứ %d: ", i + 1);
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        double tinhTrungBinh = sum / a.length;

        System.out.printf("Giá trị trung binh của 5 số là : %.2f\n", tinhTrungBinh);
    }

    public static void Bai5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Độ C : ");
        double doC = sc.nextDouble();

        double doF = doC * 1.8 + 32;

        System.out.printf("Độ C Sang F là : %.2fF\n", doF);
    }

    public static void Bai6(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tỷ giá hiện tại: ");
        double tyGia = sc.nextDouble();

        System.out.println("Nhập số USD muốn đổi sang VND : ");
        double usd = sc.nextDouble();

        double toVnd = tyGia * usd;

        System.out.printf("Số tiền USD sang VND là: %.2f\n", toVnd);
    }
}
