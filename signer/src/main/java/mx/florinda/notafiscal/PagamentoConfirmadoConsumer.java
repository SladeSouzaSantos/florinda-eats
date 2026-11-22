package mx.florinda.notafiscal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class PagamentoConfirmadoConsumer {

    @Inject
    Hash hash;

    @Incoming("pagamentosConfirmados")
    public void consumo(PagamentoConfirmadoEvent evento){
        String hashGerado = hash.geraHash(evento.toString());
        System.out.println("Hash do pagamento: " + hashGerado);
    }
}
