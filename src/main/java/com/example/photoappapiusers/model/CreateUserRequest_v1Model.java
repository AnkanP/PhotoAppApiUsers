package com.example.photoappapiusers.model;

public class CreateUserRequest_v1Model {
    private long id;
   // @NotNull(message = "first Name cannot be null")
  //  @Size(min = 2,message = "first name must not be less than 2 characters")
    private String firstName;
   // @NotNull(message = "last Name cannot be null")
   // @Size(min = 2,message = "last name must not be less than 2 characters")
    private String lastName;
    //@NotNull(message = "password cannot be null")
   // @Size(min = 2,max =5,message = "password must be min 2 & max 5 characters")
    private String encryptedPassword;
    //@NotNull(message = "email cannot be null")
   // @Email
    private String email;
    private String userId;


}
