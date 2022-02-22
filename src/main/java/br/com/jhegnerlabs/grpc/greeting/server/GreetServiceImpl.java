package br.com.jhegnerlabs.grpc.greeting.server;

import br.com.jhegnerlabs.proto.dummy.GreetingRequest;
import br.com.jhegnerlabs.proto.dummy.GreetingResponse;
import br.com.jhegnerlabs.proto.dummy.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greet(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {

        // obtem o valor da requisicao do cliente
        var greeting = request.getGreeting();
        var firstName = greeting.getFirstName();

        var result = "Hello" + firstName;

        System.out.println(result);

        // cria uma resposta
        var response = GreetingResponse.newBuilder()
                .setResult(result)
                .build();

        // envia a mensagem para o cliente
        responseObserver.onNext(response);

        // completa a chamad RPC
        responseObserver.onCompleted();

    }
}
