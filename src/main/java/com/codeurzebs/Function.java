package com.codeurzebs;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

import java.util.Optional;


public class Function {
    @FunctionName("HttpExample")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST},
            authLevel = AuthorizationLevel.ANONYMOUS)
             HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
                context.getLogger().info("Java HTTP trigger processed a request.");
                String requestBody = request.getBody().orElse("0");
                int number1 = Integer.parseInt(requestBody);
                int number2 = 10;
                int result = number1 + number2;
                return request.createResponseBuilder(HttpStatus.OK).body(Integer.toString(result)).build();
            }
}
