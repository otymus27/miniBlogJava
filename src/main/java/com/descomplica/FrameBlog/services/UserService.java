package com.descomplica.FrameBlog.services;

import com.descomplica.FrameBlog.models.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User save(final User user);

    User get(final Long id);


    User update(final Long id, final User user);

    void delete(final Long id);
}
