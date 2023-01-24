package com.fasttrackit.imcapplication.controller.dto;

import java.util.Date;

public record PatchUserDataRequest(Date date,int weight, float height) {
}
