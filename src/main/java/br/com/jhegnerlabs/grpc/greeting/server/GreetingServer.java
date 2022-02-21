package br.com.jhegnerlabs.grpc.greeting.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreetingServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello GRPC");

        var server = ServerBuilder.forPort(50051)
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Recebendo requisicao de desligamento");
            server.shutdown();
            System.out.println("Servidor finalizado com sucesso");
        }));

        server.awaitTermination();
    }


}
