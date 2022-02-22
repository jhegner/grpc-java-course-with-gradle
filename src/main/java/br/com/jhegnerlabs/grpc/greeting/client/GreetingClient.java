package br.com.jhegnerlabs.grpc.greeting.client;

import br.com.jhegnerlabs.proto.dummy.Greeting;
import br.com.jhegnerlabs.proto.dummy.GreetingRequest;
import br.com.jhegnerlabs.proto.dummy.GreetingServiceGrpc;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {

        System.out.println("Hello Im a gRPC client");

        var channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // sync
//        var syncClient = DummyServiceGrpc.newBlockingStub(channel);

        System.out.println("Criando stub");
        var syncClient = GreetingServiceGrpc.newBlockingStub(channel);

        var greeting = Greeting.newBuilder()
                .setFirstName("Manuel")
                .setLastName("Lourenco")
                .build();

        var request = GreetingRequest.newBuilder().setGreeting(greeting).build();

        var response = syncClient.greet(request);

        System.out.println(response.getResult());


        // async
//        var asyncClient = DummyServiceGrpc.newFutureStub(channel);

        // executa alguma computacao aqui

        System.out.println("Desligando o canal");
        channel.shutdown();


    }

}

