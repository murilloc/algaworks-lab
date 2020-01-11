package com.murilloc.algafood.service;

import com.murilloc.algafood.modelo.Cliente;
import com.murilloc.algafood.notificacao.NivelUrgencia;
import com.murilloc.algafood.notificacao.Notificador;
import com.murilloc.algafood.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class AtivacaoClienteService {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void ativar(Cliente cliente) {

        cliente.ativar();

        // Infiormar ao contaier que o cliente esta ativo
        // notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
    }

    @PostConstruct
    public void init() {
        System.out.println("Init method" + notificador);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy Method");
    }

}
