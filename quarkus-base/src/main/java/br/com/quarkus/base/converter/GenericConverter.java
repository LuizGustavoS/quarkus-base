package br.com.quarkus.base.converter;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

abstract class GenericConverter<ORM, DTO> {

    public abstract DTO ormToDto(ORM orm);

    public abstract ORM dtoToOrm(DTO dto);

    public Iterable<ORM> dtoToOrm(Iterable<DTO> listDTO) {

        List<ORM> listORM = new ArrayList<>();
        if (listDTO != null) {
            for (DTO dto : listDTO) {
                listORM.add(dtoToOrm(dto));
            }
        }

        return listORM;
    }

    public Iterable<DTO> ormToDto(Iterable<ORM> listORM) {

        List<DTO> listDTO = new ArrayList<>();
        if (listORM != null) {
            for (ORM orm : listORM) {
                listDTO.add(ormToDto(orm));
            }
        }

        return listDTO;
    }

    protected void copy(Object from, Object to) {
        BeanUtils.copyProperties(from, to, ignoreProperties());
    }

    protected abstract String[] ignoreProperties();

}
