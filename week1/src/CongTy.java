public class CongTy {
    public static class Nhanvien {
        String name;
        String viTri;
        String diaChi;
        int tuoi;

        public void setName(String name) {
            this.name = name;
        }

        public void setTuoi(int tuoi) {
            this.tuoi = tuoi;
        }

        public void setViTri(String viTri) {
            this.viTri = viTri;
        }

        public void setDiaChi(String diaChi) {
            this.diaChi = diaChi;
        }
        public void print(){
            System.out.println("Họ và tên: " + name);
            System.out.println("Tuổi: " + tuoi);
            System.out.println("Địa chỉ: " + diaChi);
            System.out.println("Vị trí: " + viTri);
        }
    }
    public static void main(String[] args) {
        Nhanvien NV = new Nhanvien();
        NV.setName("Đỗ Hữu Đức Mạnh");
        NV.setTuoi(24);
        NV.setDiaChi("14 ngõ 236 Khương Đình");
        NV.setViTri("Intern Java dev");

        NV.print();
    }
}