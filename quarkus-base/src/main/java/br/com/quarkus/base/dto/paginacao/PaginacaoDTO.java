package br.com.quarkus.base.dto.paginacao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginacaoDTO {

    private Integer pageCurrent;

    private Integer pageSize;

    private Integer numberOfPages;

    private Integer fieldOrder;

    private Integer typeOrder;

    private Object filters;

    private List<?> listaRegistros;

    public PaginacaoDTO(Integer pageCurrent, Integer pageSize, Integer numberOfPages, List<?> listaRegistros) {
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
        this.numberOfPages = numberOfPages;
        this.listaRegistros = listaRegistros;
    }
}
