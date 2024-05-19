package br.com.fernandaslomp.casenotafiscalsystem.mock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Builder
@AllArgsConstructor
public class BasicResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String response;
}
