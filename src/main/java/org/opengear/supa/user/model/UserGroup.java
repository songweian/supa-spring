package org.opengear.supa.user.model;

import lombok.Data;

import java.util.List;

@Data
public class UserGroup {
    private String groupName;
    private List<User> userList;
    private List<Role> roleList;
}
