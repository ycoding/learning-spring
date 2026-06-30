package com.moltentech.backend.controller;

import com.moltentech.backend.dto.UserDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Map;

@RestController
@RequestMapping("/api/dummy/users")
public class UserController {

    @GetMapping({"/{userId}/posts/{postId}", "/{userId}"})
    public ResponseEntity<String> searchUserPostsWithMultiPathVariables(@PathVariable String userId, @PathVariable(required = false) String postId) {
        String response = "";
        if (postId != null) {
            response="Fetched user with id: "+userId+" and post id: "+postId;
        }
        else {
            response = "Fetched user with id: "+userId;
        }
       // return response;
        return ResponseEntity.ok().body(response);
    }

    @GetMapping({"/{userId}/orders/{orderId}"})
    public String searchUserOrderWithMultiPathVariables(@PathVariable(name = "userId") String customerId, @PathVariable String orderId) {
        return  "Fetched user with id: "+customerId+" and order id: "+orderId;
    }

    @GetMapping({"/{userId}/address/{addressId}"})
    public String searchUserAddressWithMultiPathVariables(@PathVariable Map<String,String> pathVariablesMap) {
        return  "Fetched user with id: "+pathVariablesMap.get("userId")+" and address id: "+pathVariablesMap.get("addressId");
    }

    @GetMapping("/search")
    public String searchUserWithQueryParams(@RequestParam(required = false,defaultValue = "Guest") String name,
                                            @RequestParam(name = "gender") String  sex) {
        return "Fetched user with query params: "+name+" and gender: "+sex;
    }

    @GetMapping("/search/map")
    public String searchUserWithMapQueryParams(@RequestParam Map<String,String> requestParams) {
        return "Fetched user with query params: "+requestParams.get("name")+" and gender: "+requestParams.get("gender") ;
    }
    @GetMapping("/headers")
    public String readRequestHeaders(@RequestHeader("User-Agent")  String userAgent,
                                     @RequestHeader("User-Location") String userLocation) {
        return  "Received: "+userAgent+" "+userLocation;
    }

    @GetMapping("/headers/map")
    public String readRequestHeadersWithMap(@RequestHeader Map<String,String> requestHeaders) {
        return  "Received: "+requestHeaders.get("User-Agent")+" "+requestHeaders.get("User-Location");
    }

    @GetMapping("/headers/http-headers")
    public String readRequestHeadersWithHttpHeaders(@RequestHeader HttpHeaders requestHeaders) {
        return  "Received: "+requestHeaders.get("User-Agent")+" "+requestHeaders.get("User-Location");
    }

    @PostMapping
    public String createUser(@RequestBody UserDto userDto) {
        return  "Created user with the data: "+userDto.toString();
    }

    @PostMapping("request-entity")
    public ResponseEntity<String> createUserWithRequestEntity(RequestEntity<UserDto> requestEntity) {
        HttpHeaders headers = requestEntity.getHeaders();
        UserDto userDto = requestEntity.getBody();
        String queryParam =requestEntity.getUrl().getQuery();
        String pathVariables = requestEntity.getUrl().getPath();
       // return  "Created user with the data: "+userDto.toString();
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Custom-Header","ExampleValue")
                .body("Created user with the data: "+userDto.toString());
    }
}
