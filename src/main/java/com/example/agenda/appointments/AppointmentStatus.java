package com.example.agenda.appointments;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AppointmentStatus {

    AGENDADO ("A", "Agendado"),
    CONCLUIDO ("C", "Concluído"),
    CANCELADO ("CA", "Cancelado");

     private String codigo;
     private String descricao;

    private AppointmentStatus(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @JsonValue
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonCreator
    public static AppointmentStatus doValor(String codigo) {
        if(codigo.equals("A")) {
            return AGENDADO;
        }else if(codigo.equals("C")) {
            return CONCLUIDO;
        }else if(codigo.equals("CA")) {
            return CANCELADO;
        }else {
            return null;
        }
    }
}
