package com.murilloc.algafood.notificacao;

import com.murilloc.algafood.modelo.Cliente;
import org.springframework.stereotype.Component;

@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorSMS implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s por SMS através do telefone %s: %s\n",
                cliente.getNome(), cliente.getTelefone(), mensagem);
    }

}
