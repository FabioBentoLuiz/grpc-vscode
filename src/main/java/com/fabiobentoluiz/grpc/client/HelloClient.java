package com.fabiobentoluiz.grpc.client;

import com.proto.hello.HelloParams;
import com.proto.hello.HelloRequest;
import com.proto.hello.HelloServiceGrpc;

import io.grpc.ManagedChannelBuilder;

public class HelloClient {

    public static void main(String[] args) {
        var channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        System.out.println("Creating Hello client...");

        var param = HelloParams.newBuilder()
                        .setFirstName("Fabio")
                        .setLastName("Bento Luiz")
                        .build();

        var request = HelloRequest.newBuilder().setParam(param).build();

        var calcClient = HelloServiceGrpc.newBlockingStub(channel);
        var response = calcClient.hello(request);
        System.out.println(response.getResult());
        channel.shutdown();
    }
}