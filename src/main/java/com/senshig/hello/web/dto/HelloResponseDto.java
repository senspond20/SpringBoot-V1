package com.senshig.hello.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;

}
