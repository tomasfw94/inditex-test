package com.inditex.inditextest.controller;

import lombok.Data;
import lombok.NonNull;

@Data
public class RestExceptionResponseBody {

    @NonNull private String errorMessage;

}
