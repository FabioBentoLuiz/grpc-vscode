package com.fabiobentoluiz.grpc.server;

import java.io.IOException;

import io.grpc.ServerBuilder;

public class HelloServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting Hello server...");

        var server = ServerBuilder.forPort(50051)
        .addService(new HelloServiceImpl())
        .build();
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown request received...");
            server.shutdown();
            System.out.println("Sucessfully stopped.");
        }));

        server.awaitTermination();
    }
}