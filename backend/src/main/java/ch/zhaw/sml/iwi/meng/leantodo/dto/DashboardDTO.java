package ch.zhaw.sml.iwi.meng.leantodo.dto;

import java.sql.Time;

import lombok.Data;

@Data
public class DashboardDTO {

    private Long levelanzeige;

    private Time mappergebnis;

    private Long coordinates;

    private Long uebungsergebnis;


}

