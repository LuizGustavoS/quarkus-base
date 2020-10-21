package br.com.quarkus.base.controller;

import br.com.quarkus.base.dao.GenericDAO;
import br.com.quarkus.base.dto.paginacao.PaginacaoDTO;

import javax.inject.Inject;
import java.util.List;

public abstract class GenericController {

    @Inject
    GenericDAO genericDAO;

    public PaginacaoDTO loadSearch(PaginacaoDTO paginator, String sqlCount, String sqlQuery){

        int totalRegistros = genericDAO.count(sqlCount);
        int numPaginas = (int) Math.ceil(totalRegistros / (double) paginator.getPageSize());

        paginator.setPageCurrent(paginator.getPageCurrent() > totalRegistros? 1 : paginator.getPageCurrent());
        int offset = paginator.getPageCurrent() > 0? (paginator.getPageCurrent() - 1) *paginator.getPageSize(): 0;

        List<?> data = genericDAO.search(sqlQuery, offset, paginator.getPageSize());
        return new PaginacaoDTO(paginator.getPageCurrent(), paginator.getPageSize(), numPaginas, data);
    }

}
