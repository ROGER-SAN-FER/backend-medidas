package medidasBackend.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import medidasBackend.entity.Measure;
import medidasBackend.entity.User;
import medidasBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User existente = userRepository.findById(user.getId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario con id: " + user.getId() + " no encontrado."));
        if (user.getName() != null) {
            existente.setName(user.getName());
        }

        if (user.getSex() != null) {
            existente.setSex(user.getSex());
        }

        if (user.getBirthday() != null) {
            existente.setBirthday(user.getBirthday());
        }

        if (user.getEmail() != null) {
            existente.setEmail(user.getEmail());
        }

        if (user.getPhone() != null) {
            existente.setPhone(user.getPhone());
        }

        if (user.getTown() != null) {
            existente.setTown(user.getTown());
        }

        if (user.getPassword() != null) {
            existente.setPassword(user.getPassword());
        }

        return userRepository.save(existente);
    }

    @Override
    public String deleteUser(Long id) {
        User existente = userRepository.findById(id).orElse(null);
        if (existente != null) {
            userRepository.delete(existente);
            return "User \"" + existente.getName() + "\" ha sido eliminado.";
        } else {
            return "Usuario con id: " + id + " no encontrado.";
        }
    }

    @Override
    public List<Measure> getAllMeasuresByUser(Long id) {
        User existente = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Usuario con id: " + id + " no encontrado."));
        return existente.getMeasures();

    }
}
