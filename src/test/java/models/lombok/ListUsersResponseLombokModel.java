package models.lombok;

@lombok.Data
public class ListUsersResponseLombokModel {

    int page, per_page, total, total_pages;
    Data[] data;
    Support support;
}