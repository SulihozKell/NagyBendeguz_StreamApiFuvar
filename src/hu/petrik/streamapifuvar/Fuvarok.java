package hu.petrik.streamapifuvar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fuvarok {
    private List<Fuvar> fuvarok;

    public Fuvarok(String fajlnev) {
        this.fuvarok = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fajlnev));
            br.readLine();
            String sor = br.readLine();
            while (sor != null) {
                this.fuvarok.add(new Fuvar(sor));
                sor = br.readLine();
            }
            br.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public long getFuvarokSzama() {
        return this.fuvarok.stream().count();
    }

    public long getFuvarokSzamaById(int id) {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getTaxiId() == id)
                .count();
    }

    public double getOsszesBevetelById(int id) {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getTaxiId() == id)
                .mapToDouble(fuvar -> fuvar.getViteldij() + fuvar.getBorravalo())
                .sum();
    }

    public double getOsszesMerfold() {
        return this.fuvarok.stream()
                .mapToDouble(fuvar -> fuvar.getTavolsag())
                .sum();
    }

    public Fuvar getLeghosszabbIdo() {
        return this.fuvarok.stream()
                .max(Comparator.comparing(fuvar -> fuvar.getIdotartam()))
                .get();
    }

    public Fuvar getLegbokezubbBorravalo() {
        return this.fuvarok.stream()
                .max(Comparator.comparing(fuvar -> fuvar.getBorravalo() / fuvar.getViteldij()))
                .get();
    }

    public double getOsszesKmById(int id) {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getTaxiId() == id)
                .mapToDouble(fuvar -> fuvar.getTavolsag() * 1.6)
                .sum();
    }

    public long getHibasakSzama() {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getIdotartam() > 0 && fuvar.getViteldij() > 0 && fuvar.getTavolsag() == 0)
                .count();
    }

    public int getHibasakOsszesIdo() {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getIdotartam() > 0 && fuvar.getViteldij() > 0 && fuvar.getTavolsag() == 0)
                .mapToInt(fuvar -> fuvar.getIdotartam())
                .sum();
    }

    public double getHibasakTeljesBevetel() {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getIdotartam() > 0 && fuvar.getViteldij() > 0 && fuvar.getTavolsag() == 0)
                .mapToDouble(fuvar -> fuvar.getViteldij() + fuvar.getBorravalo())
                .sum();
    }

    public boolean getLetezikEById(int id) {
        return this.fuvarok.stream()
                .anyMatch(fuvar -> fuvar.getTaxiId() == id);
    }

    public List<Fuvar> getHaromLegrovidebbUtazasNemNulla() {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getIdotartam() > 0)
                .sorted(Comparator.comparingInt(fuvar -> fuvar.getIdotartam()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public long getFuvarokSzamaByDate(int honap, int nap) {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getIndulas().getMonthValue() == honap && fuvar.getIndulas().getDayOfMonth() == nap)
                .count();
    }

    public double getBorravalokByDate(int honap, int nap) {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getIndulas().getMonthValue() == honap && fuvar.getIndulas().getDayOfMonth() == nap)
                .mapToDouble(fuvar -> fuvar.getBorravalo() / fuvar.getViteldij())
                .sum();
    }
}
