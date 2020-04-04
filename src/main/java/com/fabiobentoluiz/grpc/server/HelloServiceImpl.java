package com.fabiobentoluiz.grpc.server;

import com.proto.hello.HelloRequest;
import com.proto.hello.HelloResponse;
import com.proto.hello.HelloServiceGrpc.HelloServiceImplBase;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceImplBase{

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        var result = String.format("Hello %s %s", request.getParam().getFirstName(), request.getParam().getLastName());
        var response = HelloResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}