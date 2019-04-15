package com.berthoud.p7.webserviceapp.endpoints;

import com.berthoud.p7.webserviceapp.business.CustomerManager;
import com.berthoud.p7.webserviceapp.model.entities.CustomerEntity;
import com.berthoud.p7.webserviceapp.ws.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CustomerEndpoint {
    public static final String NAMESPACE_URI = "http://com.berthoud.p7";

    @Autowired
    private CustomerManager customerManager;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerByNicknameRequest")
    @ResponsePayload
    public GetCustomerByNicknameResponse getCustomerByNickname(@RequestPayload GetCustomerByNicknameRequest request) {
        GetCustomerByNicknameResponse response = new GetCustomerByNicknameResponse();
        CustomerEntity customerEntity = customerManager.findByNickname(request.getNickname());

        CustomerType customerWs = new CustomerType();

        BeanUtils.copyProperties(customerEntity, customerWs);

        response.setCustomerType(customerWs);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerByIdRequest")
    @ResponsePayload
    public GetCustomerByIdResponse getCustomerById(@RequestPayload GetCustomerByIdRequest request) {
        GetCustomerByIdResponse response = new GetCustomerByIdResponse();
        CustomerEntity customerEntity = customerManager.findById(request.getId());

        CustomerType customerWs = new CustomerType();

        BeanUtils.copyProperties(customerEntity, customerWs);

        response.setCustomerType(customerWs);
        return response;
    }

}






