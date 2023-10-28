package com.crud.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.crud.crud.domain.Cidadao;

@Component
public class CidadaoDAO {
    @Autowired
    JdbcTemplate db;

    public List<Cidadao> getCidadaos(){
        String sql = "select id, nome, email, celular from info";
        return db.query(sql, (res, rowNum) -> {
            return new Cidadao(
                res.getInt("id"),
                res.getString("nome"),
                res.getString("email"),
                res.getString("celular")
            );
        });
    }

    public List<Cidadao> getCidadaos(String nome) {
        String sql = "select id, nome, email, celular from info where lower(nome) like ?";
        return db.query(sql,
            new BeanPropertyRowMapper<>(Cidadao.class),
            new Object[]{"%"+nome.toLowerCase()+"%"});
    }

    public Cidadao getCidadaos(int id) {
        String sql = "select id, nome, email, celular from info where id = ?";
            List<Cidadao> cidadaos = db.query(sql,
                new BeanPropertyRowMapper<>(Cidadao.class),
                new Object[]{id});

                if(cidadaos != null && cidadaos.size() > 0){
                    return cidadaos.get(0);
                }else{
                    return null;
                }
    }

    public void insertCidadao(Cidadao cidadao){
        //o parametro será passado na url RequestParam -> ?
        String sql = "insert into info(id, nome, email, celular) values (?, ?, ?, ?)";

        db.update(sql, new Object[]{cidadao.getId(), cidadao.getNome(), cidadao.getEmail(), cidadao.getCelular()});
    }

    public void updateCidadao(Cidadao cidadao){
        String sql = "update info set nome = ?, email = ?, celular = ? where id = ?";

        db.update(sql, new Object[]{cidadao.getNome(), cidadao.getEmail(), cidadao.getCelular(), cidadao.getId()});
    }

    public void deleteCidadao(int id){
        String sql = "delete from info where id = ?";

        db.update(sql, new Object[]{id});
    }
}
