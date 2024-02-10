package ch.zhaw.sml.iwi.meng.leantodo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class StatusDTO {
    public StatusDTO(String name2, Integer groesse2, Integer gewicht2) {
        //TODO Auto-generated constructor stub
    }
    private String name;
    private Integer groesse;
    private Integer gewicht;
    
}
