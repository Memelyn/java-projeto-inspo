package br.com.erudio.java_springboot_erudio.services;

import br.com.erudio.java_springboot_erudio.Controller.UserController;
import br.com.erudio.java_springboot_erudio.Exception.BadRequestException;
import br.com.erudio.java_springboot_erudio.Exception.ResourceNotFoundException;
import br.com.erudio.java_springboot_erudio.Model.User;
import br.com.erudio.java_springboot_erudio.data.dto.UserDTO;
import br.com.erudio.java_springboot_erudio.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import static br.com.erudio.java_springboot_erudio.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Service
public class UserServices {

    private Logger logger = LoggerFactory.getLogger(UserServices.class.getName());

    @Autowired
    UserRepository repository;

    @Autowired
    PagedResourcesAssembler<UserDTO> assembler;

    public PagedModel<EntityModel<UserDTO>> findAll(Pageable pageable) {
        logger.info("Finding all Users!");

        var users = repository.findAll(pageable);

        var usersWithLinks = users.map(user -> {
            var dto = parseObject(user, UserDTO.class);
            addHateoasLinks(dto);
            return dto;
        });

        Link findAllLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(UserController.class)
                        .findAll(pageable.getPageNumber(),
                                pageable.getPageSize(),
                                String.valueOf(pageable.getSort()))).withSelfRel();

        return assembler.toModel(usersWithLinks, findAllLink);
    }

    public UserDTO findById(Long id) {
        logger.info("Finding one User!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var dto = parseObject(entity, UserDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public UserDTO create(UserDTO user) {
        if (user == null) throw new BadRequestException();

        logger.info("Creating one User!");

        var entity = parseObject(user, User.class);
        var dto = parseObject(repository.save(entity), UserDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public UserDTO update(UserDTO user) {
        if (user == null) throw new BadRequestException();

        logger.info("Updating one User!");

        User entity = repository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setUserName(user.getUserName());
        entity.setFullName(user.getFullName());
        entity.setPassword(user.getPassword());
        entity.setAccountNonExpired(user.getAccountNonExpired());
        entity.setAccountNonLocked(user.getAccountNonLocked());
        entity.setCredentialsNonExpired(user.getCredentialsNonExpired());
        entity.setEnabled(user.getEnabled());
        // NOTA: Permissões devem ser gerenciadas separadamente, se necessário.

        var dto = parseObject(repository.save(entity), UserDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public void delete(Long id) {
        logger.info("Deleting one User!");

        User entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    private void addHateoasLinks(UserDTO dto) {
        dto.add(linkTo(methodOn(UserController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(UserController.class).findAll(1, 12, "asc")).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(UserController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(UserController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(UserController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
