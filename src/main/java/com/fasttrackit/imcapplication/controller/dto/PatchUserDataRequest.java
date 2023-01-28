package com.fasttrackit.imcapplication.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record PatchUserDataRequest(@JsonFormat(pattern = "dd-MM-yyyy") Date date, int weight, float height) {
}
