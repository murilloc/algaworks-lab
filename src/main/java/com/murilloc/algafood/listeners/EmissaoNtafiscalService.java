package com.murilloc.algafood.listeners;

import com.murilloc.algafood.service.ClienteAtivadoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class EmissaoNtafiscalService {

    @EventListener
    @Order(2)
    public void clienteAtivadoListener(ClienteAtivadoEvent event){
        System.out.println("A nota fiscal do cliente " + event.getCliente().getNome() + " foi emitida");
    }
}
