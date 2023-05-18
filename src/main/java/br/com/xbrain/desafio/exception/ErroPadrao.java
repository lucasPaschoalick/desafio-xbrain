package br.com.xbrain.desafio.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class ErroPadrao {
    private Instant timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
