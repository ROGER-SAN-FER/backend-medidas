package medidasBackend.service;

import medidasBackend.entity.Measure;
import medidasBackend.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User registerUser(User user);
    public User updateUser(User user);
    public String deleteUser(Long id);
    public List<Measure> getAllMeasuresByUser(Long id);
}
