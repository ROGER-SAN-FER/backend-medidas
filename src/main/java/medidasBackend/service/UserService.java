package medidasBackend.service;

import medidasBackend.model.dto.UserDTO;
import medidasBackend.model.entity.Measure;
import medidasBackend.model.entity.User;

import java.util.List;

public interface UserService {
    public List<UserDTO> getAllUsers();
    public User registerUser(User user);
    public User updateUser(User user);
    public String deleteUser(Long id);
    public List<Measure> getAllMeasuresByUser(Long id);
}
