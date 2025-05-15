package com.liceolapaz.des.jarv;

public class Libro {
    private String isbn;
    private String titulo;
    private String genero;
    private int nPaginas;
    private boolean borrowed = false;
    private Socio socio;

    public Libro(String isbn, String titulo, String genero, int nPaginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.genero = genero;
        this.nPaginas = nPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
