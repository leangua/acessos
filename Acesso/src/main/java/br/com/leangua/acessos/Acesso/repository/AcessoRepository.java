package br.com.leangua.acessos.Acesso.repository;

import br.com.leangua.acessos.Acesso.model.Acesso;
import br.com.leangua.acessos.Acesso.model.AcessoId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AcessoRepository extends JpaRepository<Acesso, AcessoId> {

    Acesso findByAcessoId(AcessoId acessoId);

    void deleteByAcessoId(AcessoId acessoId);
}
