package com.mintgestao.Application.Service.Local;

import com.mintgestao.Application.Service.Infrastructure.ServiceBase;
import com.mintgestao.Domain.Entity.Local;
import com.mintgestao.Domain.Enum.EnumStatusLocal;
import com.mintgestao.Infrastructure.Repository.LocalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocalService extends ServiceBase<Local, LocalRepository> {

    @Autowired
    public LocalService(LocalRepository repository) {
        super(repository);
    }

    public Local ativar(UUID id) throws Exception {
        try {
            Local local = repository.findById(id).orElseThrow();
            local.setStatus(EnumStatusLocal.Ativo);
            return repository.save(local);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Local desativar(UUID id) throws Exception {
        try {
            Local local = repository.findById(id).orElseThrow();
            local.setStatus(EnumStatusLocal.Inativo);
            return repository.save(local);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
