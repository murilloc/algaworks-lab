package com.murilloc.algafood.listeners;

import com.murilloc.algafood.notificacao.NivelUrgencia;
import com.murilloc.algafood.notificacao.Notificador;
import com.murilloc.algafood.notificacao.TipoDoNotificador;
import com.murilloc.algafood.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    @EventListener
    @Order(1)
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo");
    }
}
