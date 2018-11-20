package pl.kobietydokodu.bazakotow.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class KotDTO {

    @NotEmpty
    private String imie;

    @NotEmpty
    private String dataUrodzenia;

    @NotNull
    private Float waga;

    @NotEmpty
    private String opiekun;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public Float getWaga() {
        return waga;
    }

    public void setWaga(Float waga) {
        this.waga = waga;
    }

    public String getOpiekun() {
        return opiekun;
    }

    public void setOpiekun(String opiekun) {
        this.opiekun = opiekun;
    }
}
