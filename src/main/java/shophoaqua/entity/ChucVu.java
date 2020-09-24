package shophoaqua.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "CHUCVU")
public class ChucVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maChucVu;
	private String tenChucVu;

	public int getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

}
