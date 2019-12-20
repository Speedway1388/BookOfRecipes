package com.softserve.edu.items.dto;

import java.util.ArrayList;
import java.util.List;

public class UsersDto {
//    private String username;
    private List<UserDto> userDtos;
    private int pageCount;
    private int pageOffset;

//    public UsersDto(String username, int pageOffset) {
    public UsersDto(int pageOffset) {
//        this.username = username;
        this.userDtos=new ArrayList<>();
        this.pageCount = userDtos.size()/pageOffset+1;
        this.pageOffset = pageOffset;

    }

//    public UsersDto(String username, List<UserDto> userDtos, int pageOffset) {
    public UsersDto(List<UserDto> userDtos, int pageOffset) {
//        this.username = username;
        this.userDtos = userDtos;
        this.pageCount = userDtos.size()/pageOffset;
        this.pageOffset = pageOffset;
    }

//    public String getUsername() {
//        return username;
//    }

    public List<UserDto> getUserDtos() {
        return userDtos;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPageOffset() {
        return pageOffset;
    }

//    public void setUsername(String username) {
//        this.username = username;
//    }

    public void setUserDtos(List<UserDto> userDtos) {
        this.userDtos = userDtos;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }
}
