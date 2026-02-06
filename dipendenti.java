package com.betacom.objects;

import java.time.LocalDate;

public class dipendenti {

	private Integer id_dipendente;
	private String nome;
	private String cognome;
	private LocalDate data_assunzione;
	private String telefono;
	private String mansione;
	private Double stipendio;
	private Integer id_ufficio;
	private String code;
	public dipendenti() {
		super();
	}
	public dipendenti(Integer id_dipendente, String nome, String cognome, LocalDate data_assunzione, String telefono,
			String mansione, Double stipendio, Integer id_ufficio, String code) {
		super();
		this.id_dipendente = id_dipendente;
		this.nome = nome;
		this.cognome = cognome;
		this.data_assunzione = data_assunzione;
		this.telefono = telefono;
		this.mansione = mansione;
		this.stipendio = stipendio;
		this.id_ufficio = id_ufficio;
		this.code = code;
	}
	public Integer getId_dipendente() {
		return id_dipendente;
	}
	public void setId_dipendente(Integer id_dipendente) {
		this.id_dipendente = id_dipendente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getData_assunzione() {
		return data_assunzione;
	}
	public void setData_assunzione(LocalDate data_assunzione) {
		this.data_assunzione = data_assunzione;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMansione() {
		return mansione;
	}
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}
	public Double getStipendio() {
		return stipendio;
	}
	public void setStipendio(Double stipendio) {
		this.stipendio = stipendio;
	}
	public Integer getId_ufficio() {
		return id_ufficio;
	}
	public void setId_ufficio(Integer id_ufficio) {
		this.id_ufficio = id_ufficio;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "dipendenti [id_dipendente=" + id_dipendente + ", nome=" + nome + ", cognome=" + cognome
				+ ", data_assunzione=" + data_assunzione + ", telefono=" + telefono + ", mansione=" + mansione
				+ ", stipendio=" + stipendio + ", id_ufficio=" + id_ufficio + ", code=" + code + "]";
	}
	
}
