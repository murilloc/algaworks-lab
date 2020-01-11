package com.murilloc.algafood.notificacao;

import com.murilloc.algafood.modelo.Cliente;


public interface Notificador {

    void notificar(Cliente cliente, String mensagem);

}
