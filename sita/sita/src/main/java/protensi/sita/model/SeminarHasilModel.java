package protensi.sita.model;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seminar_hasil")
public class SeminarHasilModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seminar_hasil", updatable = false, nullable = false)
    private Long idSeminarHasil;

    @Lob
    @Column(name = "persetujuan_pembimbing", nullable = false)
    private byte[] persetujuanPembimbing;

    @Lob
    @Column(name = "laporan_kp", nullable = false)
    private byte[] laporanKP;

    @Lob
    @Column(name = "risalah_sempro", nullable = false)
    private byte[] risalahSempro;

    @Lob
    @Column(name = "catatan_sempro", nullable = false)
    private byte[] catatanSempro;

    @Lob
    @Column(name = "saps", nullable = false)
    private byte[] saps;

    @Lob
    @Column(name = "draft_laporan_ta", nullable = false)
    private byte[] draftLaporanTa;

    @Size(max = 100)
    @Column(name = "status_dokumen")
    private String statusDokumen;

    @Size(max = 100)
    @Column(name = "status_semhas")
    private String statusSemhas;

    @Lob
    @Column(name = "catatan")
    private String catatan;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "nilai")
    private Long nilai;

    @Column(name = "tanggal_lulus")
    private LocalDateTime tanggalLulus;

    @OneToOne
    @JoinColumn(name = "id_ugb")
    private UgbModel ugb;

    @OneToOne
    @JoinColumn(name = "id_seminar_proposal")
    private SeminarProposalModel seminarProposal;

}