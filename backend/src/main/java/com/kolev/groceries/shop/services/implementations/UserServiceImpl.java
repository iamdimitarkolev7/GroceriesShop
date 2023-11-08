package com.kolev.groceries.shop.services.implementations;

import com.kolev.groceries.shop.enums.Role;
import com.kolev.groceries.shop.exceptions.user.PasswordsDoNotMatchException;
import com.kolev.groceries.shop.exceptions.user.UserAlreadyExistsException;
import com.kolev.groceries.shop.exceptions.user.UserDoesNotExistException;
import com.kolev.groceries.shop.models.User;
import com.kolev.groceries.shop.repositories.UserRepository;
import com.kolev.groceries.shop.services.interfaces.UserService;
import com.kolev.groceries.shop.utils.requests.user.UserLoginRequest;
import com.kolev.groceries.shop.utils.requests.user.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {

        String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public User registerUser(UserRegisterRequest request) {

        boolean userExists = userExists(request.getUsername());

        if (userExists) {
            throw new UserAlreadyExistsException("User already exists!");
        }

        String password = request.getPassword();
        String confirmPassword = request.getConfirmPassword();

        if (!password.equals(confirmPassword)) {
            throw new PasswordsDoNotMatchException("Passwords do not match!");
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .basket(new ArrayList<>())
                .role(Role.ROLE_USER)
                .build();

        return createUser(user);
    }

    @Override
    public User loginUser(UserLoginRequest request) {

        Optional<User> oUser = getUserByUsername(request.getUsername());

        if (oUser.isEmpty()) {
            throw new UserDoesNotExistException("User does not exist!");
        }

        boolean passwordsMatch = bCryptPasswordEncoder.matches(request.getPassword(), oUser.get().getPassword());

        if (!passwordsMatch) {
            throw new PasswordsDoNotMatchException("Passwords do not match!");
        }

        return oUser.get();
    }
}
