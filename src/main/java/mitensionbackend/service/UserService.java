package mitensionbackend.service;

import mitensionbackend.model.dto.UserDTO;
import mitensionbackend.model.entity.Measure;
import mitensionbackend.model.entity.User;

import java.util.List;

public interface UserService {
    public List<UserDTO> getAllUsers();
    public User registerUser(User user);
    public User updateUser(User user);
    public String deleteUser(Long id);
    public List<Measure> getAllMeasuresByUser(Long id);
}
