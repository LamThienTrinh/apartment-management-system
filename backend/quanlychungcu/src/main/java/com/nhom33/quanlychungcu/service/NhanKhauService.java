package com.nhom33.quanlychungcu.service;

import com.nhom33.quanlychungcu.entity.HoGiaDinh;
import com.nhom33.quanlychungcu.entity.NhanKhau;
import com.nhom33.quanlychungcu.exception.ResourceNotFoundException;
import com.nhom33.quanlychungcu.repository.HoGiaDinhRepository;
import com.nhom33.quanlychungcu.repository.NhanKhauRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NhanKhauService {

    private final NhanKhauRepository repo;
    private final HoGiaDinhRepository hoGiaDinhRepo;

    public NhanKhauService(NhanKhauRepository repo, HoGiaDinhRepository hoGiaDinhRepo) {
        this.repo = repo;
        this.hoGiaDinhRepo = hoGiaDinhRepo;
    }

    @Transactional
    public NhanKhau create(NhanKhau nhanKhau) {
        // Kiểm tra số CCCD đã tồn tại chưa
        if (nhanKhau.getSoCCCD() != null && repo.existsBySoCCCD(nhanKhau.getSoCCCD())) {
            throw new IllegalArgumentException(
                "Số CCCD '" + nhanKhau.getSoCCCD() + "' đã tồn tại"
            );
        }

        // Kiểm tra hộ gia đình có tồn tại không
        if (nhanKhau.getHoGiaDinh() != null && nhanKhau.getHoGiaDinh().getId() != null) {
            HoGiaDinh hoGiaDinh = hoGiaDinhRepo.findById(nhanKhau.getHoGiaDinh().getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                    "Không tìm thấy hộ gia đình với ID: " + nhanKhau.getHoGiaDinh().getId()
                ));
            nhanKhau.setHoGiaDinh(hoGiaDinh);
        }

        // Nếu là chủ hộ, kiểm tra đã có chủ hộ chưa
        if (Boolean.TRUE.equals(nhanKhau.getLaChuHo())) {
            repo.findChuHoByHoGiaDinhId(nhanKhau.getHoGiaDinh().getId())
                .ifPresent(existing -> {
                    throw new IllegalArgumentException(
                        "Hộ gia đình đã có chủ hộ: " + existing.getHoTen()
                    );
                });
        }

        return repo.save(nhanKhau);
    }

    @Transactional
    public NhanKhau update(Integer id, NhanKhau updated) {
        NhanKhau exist = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân khẩu với ID: " + id));

        // Kiểm tra nếu đổi CCCD và CCCD mới đã tồn tại
        if (updated.getSoCCCD() != null 
            && !updated.getSoCCCD().equals(exist.getSoCCCD()) 
            && repo.existsBySoCCCD(updated.getSoCCCD())) {
            throw new IllegalArgumentException(
                "Số CCCD '" + updated.getSoCCCD() + "' đã tồn tại"
            );
        }

        // Nếu đổi thành chủ hộ, kiểm tra đã có chủ hộ chưa
        if (Boolean.TRUE.equals(updated.getLaChuHo()) && !Boolean.TRUE.equals(exist.getLaChuHo())) {
            repo.findChuHoByHoGiaDinhId(exist.getHoGiaDinh().getId())
                .ifPresent(chuHo -> {
                    throw new IllegalArgumentException(
                        "Hộ gia đình đã có chủ hộ: " + chuHo.getHoTen()
                    );
                });
        }

        // Cập nhật thông tin
        exist.setHoTen(updated.getHoTen());
        exist.setNgaySinh(updated.getNgaySinh());
        exist.setGioiTinh(updated.getGioiTinh());
        exist.setSoCCCD(updated.getSoCCCD());
        exist.setSoDienThoai(updated.getSoDienThoai());
        exist.setEmail(updated.getEmail());
        exist.setQuanHeVoiChuHo(updated.getQuanHeVoiChuHo());
        exist.setLaChuHo(updated.getLaChuHo());
        exist.setNgayChuyenDen(updated.getNgayChuyenDen());
        exist.setTrangThai(updated.getTrangThai());

        return repo.save(exist);
    }

    @Transactional
    public void delete(Integer id) {
        NhanKhau nhanKhau = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân khẩu với ID: " + id));

        // Không cho xóa chủ hộ
        if (Boolean.TRUE.equals(nhanKhau.getLaChuHo())) {
            throw new IllegalArgumentException(
                "Không thể xóa chủ hộ. Vui lòng chuyển quyền chủ hộ cho người khác trước."
            );
        }

        repo.deleteById(id);
    }

    public NhanKhau getById(Integer id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân khẩu với ID: " + id));
    }

    public NhanKhau getBySoCCCD(String soCCCD) {
        return repo.findBySoCCCD(soCCCD)
            .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân khẩu với CCCD: " + soCCCD));
    }

    public Page<NhanKhau> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public List<NhanKhau> findByHoGiaDinh(Integer idHoGiaDinh) {
        return repo.findByHoGiaDinhId(idHoGiaDinh);
    }

    public Page<NhanKhau> searchByHoTen(String hoTen, Pageable pageable) {
        if (hoTen == null || hoTen.isBlank()) {
            return repo.findAll(pageable);
        }
        return repo.findByHoTenContainingIgnoreCase(hoTen, pageable);
    }

    public Page<NhanKhau> search(String hoTen, String soCCCD, String gioiTinh, 
                                  String trangThai, Integer idHoGiaDinh, Pageable pageable) {
        return repo.search(hoTen, soCCCD, gioiTinh, trangThai, idHoGiaDinh, pageable);
    }

    public long countByHoGiaDinh(Integer idHoGiaDinh) {
        return repo.countByHoGiaDinhId(idHoGiaDinh);
    }

    public long countByGioiTinh(String gioiTinh) {
        return repo.countByGioiTinh(gioiTinh);
    }
}
