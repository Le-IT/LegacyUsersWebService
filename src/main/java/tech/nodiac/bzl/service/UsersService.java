package tech.nodiac.bzl.service;


import tech.nodiac.bzl.response.UserRest;

public interface UsersService {
   UserRest getUserDetails(String userName, String password);
   UserRest getUserDetails(String userName);
}
