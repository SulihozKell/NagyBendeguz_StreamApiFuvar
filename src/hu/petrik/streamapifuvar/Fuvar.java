package hu.petrik.streamapifuvar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fuvar {
    private int taxiId;
    private LocalDateTime indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetesModja;

    public Fuvar(String sor) {
        String[] adatok = sor.split(";");
        this.taxiId = Integer.parseInt(adatok[0]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.indulas = LocalDateTime.parse(adatok[1], formatter);
        this.idotartam = Integer.parseInt(adatok[2]);
        this.tavolsag = Double.parseDouble(adatok[3].replace(',', '.'));
        this.viteldij = Double.parseDouble(adatok[4].replace(',', '.'));
        this.borravalo = Double.parseDouble(adatok[5].replace(',', '.'));
        this.fizetesModja = adatok[6];
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public LocalDateTime getIndulas() {
        return indulas;
    }

    public void setIndulas(LocalDateTime indulas) {
        this.indulas = indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public void setIdotartam(int idotartam) {
        this.idotartam = idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public void setTavolsag(double tavolsag) {
        this.tavolsag = tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public void setViteldij(double viteldij) {
        this.viteldij = viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public void setBorravalo(double borravalo) {
        this.borravalo = borravalo;
    }

    public String getFizetesModja() {
        return fizetesModja;
    }

    public void setFizetesModja(String fizetesModja) {
        this.fizetesModja = fizetesModja;
    }
}
