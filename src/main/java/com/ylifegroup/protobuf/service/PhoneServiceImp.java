package com.ylifegroup.protobuf.service;

import com.ylifegroup.protobuf.PhoneServiceGrpc;
import com.ylifegroup.protobuf.Phonebook.AddPhoneToUserRequest;
import com.ylifegroup.protobuf.Phonebook.AddPhoneToUserResponse;

import io.grpc.stub.StreamObserver;

public class PhoneServiceImp extends PhoneServiceGrpc.PhoneServiceImplBase{

	@Override
	public void addPhoneToUser(AddPhoneToUserRequest request, StreamObserver<AddPhoneToUserResponse> responseObserver) {
		// TODO Auto-generated method stub
		AddPhoneToUserResponse response = null;
		if(request.getPhoneNumber().length() == 11 ){
			System.out.printf("uid = %s , phone type is %s, nubmer is %s\n", request.getUid(), request.getPhoneType(), request.getPhoneNumber());
			response = AddPhoneToUserResponse.newBuilder().setResult(true).build();
		}else{
			System.out.printf("The phone nubmer %s is wrong!\n",request.getPhoneNumber());
			response = AddPhoneToUserResponse.newBuilder().setResult(false).build();
		}
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
}
