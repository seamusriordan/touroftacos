package dev.revived.touroftacos.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public interface TacoPository extends CrudRepository<Taco, Long> {}
