package com.murilloc.algafood.notificacao;

import com.murilloc.algafood.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {

//    @Value("${notificador.email.host-servidor}")
//    private String host;
//    @Value("${notificador.email.porta-servidor}")
//    private  Integer porta;

    @Autowired
    NotificadorPorperties notificadorPorperties;

    public NotificadorEmail() {
        System.out.println("NotificadorEmail REAL");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem) {

        System.out.println("Host: " + notificadorPorperties.getHostServidor());
        System.out.println("Porta: " + notificadorPorperties.getPortaServidor());
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}
