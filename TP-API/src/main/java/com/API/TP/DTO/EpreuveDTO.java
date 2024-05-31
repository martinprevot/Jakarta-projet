package com.API.TP.DTO;

public class EpreuveDTO {
    private Long id;
    private String nom;
    private String date;
    private String lieu;
    private String type;
    private String description;
    private Long idStadium;

    public EpreuveDTO() {
    }

    public EpreuveDTO(Long id, String nom, String date, String lieu, String type, String description, Long idStadium) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.type = type;
        this.description = description;
        this.idStadium = idStadium;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Long getIdStadium() {
        return idStadium;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdStadium(Long idStadium) {
        this.idStadium = idStadium;
    }
}
