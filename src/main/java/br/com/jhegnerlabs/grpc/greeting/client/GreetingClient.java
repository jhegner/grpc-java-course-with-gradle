package br.com.jhegnerlabs.grpc.greeting.client;

import br.com.jhegnerlabs.proto.dummy.DummyServiceGrpc;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {

        System.out.println("Hello Im a gRPC client");

        var channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // sync
        var syncClient = DummyServiceGrpc.newBlockingStub(channel);

        // async
//        var asyncClient = DummyServiceGrpc.newFutureStub(channel);

        // executa alguma computacao aqui

        System.out.println("Desligando o canal");
        channel.shutdown();


    }

}
