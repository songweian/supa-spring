package org.opengear.supa.user.model;

import lombok.Data;

import java.util.List;

@Data
public class User {
    List<Role> roleList;
    List<String> funcCodeList;
}
