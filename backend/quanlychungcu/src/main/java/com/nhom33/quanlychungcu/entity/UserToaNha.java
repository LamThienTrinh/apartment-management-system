package com.nhom33.quanlychungcu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entity liên kết User với Tòa nhà.
 * 
 * LOGIC NGHIỆP VỤ:
 * - Manager gắn user (bằng username) vào tòa nhà mình quản lý
 * - User có thể thuộc nhiều tòa nhà
 * - Dùng để xác định user xem được thông báo của tòa nào
 */
@Entity
@Table(name = "UserToaNha", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ID_User", "ID_ToaNha"})
})
@Getter
@Setter
@NoArgsConstructor
public class UserToaNha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_User", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "passwordHash"})
    private UserAccount user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ToaNha", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ToaNha toaNha;

    @Column(name = "NgayThem")
    private LocalDateTime ngayThem = LocalDateTime.now();

    // Explicit default constructor for Hibernate (MacBook Lombok compatibility)
    public UserToaNha() {
        this.ngayThem = LocalDateTime.now();
    }

    public UserToaNha(UserAccount user, ToaNha toaNha) {
        this.user = user;
        this.toaNha = toaNha;
        this.ngayThem = LocalDateTime.now();
    }

    // Explicit getters/setters for MacBook Lombok compatibility
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public UserAccount getUser() { return user; }
    public void setUser(UserAccount user) { this.user = user; }
    public ToaNha getToaNha() { return toaNha; }
    public void setToaNha(ToaNha toaNha) { this.toaNha = toaNha; }
    public LocalDateTime getNgayThem() { return ngayThem; }
    public void setNgayThem(LocalDateTime ngayThem) { this.ngayThem = ngayThem; }
}
